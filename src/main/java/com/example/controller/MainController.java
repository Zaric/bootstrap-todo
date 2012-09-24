package com.example.controller;

import java.security.Principal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.service.TaskService;
import com.example.service.UserRoleService;
import com.example.service.UserService;

@Controller
public class MainController {

//	@Autowired
//	private PersonService personService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private TaskService taskService;
	
	@PersistenceContext
	EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

//	private User sam = new User("sam", "secr3t");
	
//	private Tag defaultTag = new Tag("Default");
//	private Tag workTag = new Tag("Work");
//	private Tag personalTag = new Tag("Personal");

/* 	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String handleDefault(ModelMap model, Principal principal){

		String name = principal.getName();
		if (null != name){
			logger.info("intercepted /. Sending user to /tasks/tasks.jsp");
			return "redirect:/tasks/";
		} else {
			logger.info("caught / Redirecting to login page");
			return "redirect:/login";
		}
		//return "redirect:/welcome";
	}
*/
	
	@RequestMapping(value ="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model, Principal principal) {

		if (null != principal){
			logger.info("intercepted /welcome. name is: "+principal.getName());	
			return "redirect:/tasks/";		
		} else {
			logger.info("weird no principal found:");
			return "redirect:/loginfailed";
		}
		
/*	heroku doesn't like cookies, it seems or maybe I tripped on some settings 
		Cookie newCookie = null;
		Cookie[] myCookie = request.getCookies();
		boolean foundACookie = false;
		
		if (myCookie.length != 0){
			for (Cookie cookie : myCookie) {
				if (cookie.getName().equals("session"));{
					foundACookie = true;
					return "redirect:/tasks/";
				}
			}
		}
		logger.info("Cookie found:"+foundACookie);
		if (!foundACookie){
			newCookie = new Cookie("session", "Sam");
			newCookie.setMaxAge(24*60*60);
			response.addCookie(newCookie);
		}	

		// create a test user if new session 

		if (null == sam) {
			sam = new User("sam", "secr3t");
			userService.addUser(sam);
			map.put("user", sam);
			logger.info("added user "+sam.getUserName()+" to Datastore");			
		} else {
			logger.info("message: " + map.get("message"));
		}
		
		userService.addUser(sam);
		map.put("user", sam);
		logger.info("added user "+sam.getUserName()+" to Datastore");
		
		return "index";
*/	

	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response){

		/* Cookie code here
		
		Cookie newCookie = null;
		Cookie[] myCookie = request.getCookies();
		boolean foundACookie = false;
		
		if (myCookie.length != 0){
			for (Cookie cookie : myCookie) {
				if (cookie.getName().equals("session"));{
					foundACookie = true;
					return "redirect:/tasks/";
				}
			}
		}
		logger.info("Cookie found:"+foundACookie);
		if (!foundACookie){
			newCookie = new Cookie("session", "Sam");
			newCookie.setMaxAge(24*60*60);
			response.addCookie(newCookie);
		}	
		*/
/* 		-- Users and Roles --
		UserRoles userRole = new UserRoles("ROLE_USER");
		List<UserRoles> roles = new ArrayList<UserRoles>();
		roles.add(userRole);
		
		// create a user for the system
		sam.setEnabled(true);
		sam.setUserRoles(roles);
		userService.addUser(sam);
*/		
		logger.info("intercepted /login. Sending to index");
		return "index";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "index";
 
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		/*
		for (Cookie myCookie : request.getCookies()){
			myCookie.setMaxAge(0);
		}
		*/
		return "index";
	}

/* handle tasks here *--
	
	@RequestMapping(value = "/tasks/add", method=RequestMethod.POST)
	public String addTask(@ModelAttribute("task") Task task ){
		
		logger.info("creating a task, with:"+task.getTaskName()+" "+task.getCompleteBy());
		
		task.setCreatedDate(Calendar.getInstance().getTime());
		task.setCompleted(false);
		if (null == task.getCompleteBy())
			task.setCompleteBy(Calendar.getInstance().getTime());
		
		// add some default tags
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(defaultTag);
		tags.add(personalTag);
		tags.add(workTag);
		
		task.setTags(tags);
		
		task.setUser(sam);
		
		logger.info("User sam is :"+sam);
		
		taskService.createTask(task);		
		
		return "redirect:/tasks/";
	}
	
	@RequestMapping("/tasks/delete/{taskId}")
	public String deleteTask(@PathVariable("taskId") Integer taskId){
		logger.info("deleting task with id:"+taskId);
		taskService.deleteTask(taskId);
		return "redirect:/tasks/";
	}

	@RequestMapping("/tasks/")
	public String listTasks(Map<String, Object> map){
		logger.info("handling path /tasks/ ");
		
		map.put("task", new Task());
		map.put("taskList", taskService.listAll());
		
		for (Task task : taskService.listAll()) {
			for (Tag tag : task.getTags()) {
				logger.info("tag fetched: "+tag.getTagName());
			}
		}
		
		return "tasks";
	}
*/
	
}
