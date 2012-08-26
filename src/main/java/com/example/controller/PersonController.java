package com.example.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.model.Person;
import com.example.model.User;
import com.example.service.PersonService;
import com.example.service.UserService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	private User sam = null;
	
	@RequestMapping("/")
	public String listPeople(Map<String, Object> map, HttpServletRequest request) {
		
		logger.info("request is empty? "+request.getAttribute("message"));
		
		if (null == sam){
			sam = new User("sam","secr3t");
			userService.addUser(sam);
			map.put("user", sam);
		} else {
			logger.info("message: "+map.get("message"));
		}
		return "index";
	}

	@RequestMapping(value = "/people/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person,
			BindingResult result) {

		personService.addPerson(person);

		logger.info("added person");
		return "redirect:/people/";
	}

	@RequestMapping("/people/delete/{personId}")
	public String deletePerson(@PathVariable("personId") Integer personId) {

		personService.removePerson(personId);
		logger.info("removed person");
		return "redirect:/people/";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) {
		
		logger.info("user recieved is: "+user.getUserName()+" with passwd: "+ user.getPasswd());
		if (userService.validateUser(user)){
			return "redirect:/people/";
		}else{
			logger.info("login failed");
			request.setAttribute("message", "loginFail");
			return "forward:/";
		}
	}
	
	@RequestMapping("/people/")
	public String handlePeople(Map<String, Object> map){
		
		map.put("person", new Person());
		map.put("peopleList", personService.listPeople());

		logger.info("handled loading of /people/");
		return "people";
	}
	
}
