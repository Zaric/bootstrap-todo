package com.example.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Tag;
import com.example.model.Task;
import com.example.model.User;
import com.example.service.TaskService;


@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PersistenceContext
	EntityManager em;
	
	private User sam = null;	// = new User("sam", "secr3t");
	
	private Tag defaultTag = new Tag("Default");
	private Tag workTag = new Tag("Work");
	private Tag personalTag = new Tag("Personal");
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
/* handle tasks here */
	
	@RequestMapping(value = "/tasks/add", method=RequestMethod.POST)
	public String addTask(@ModelAttribute("task") Task task, Principal authToken ){
		
		logger.info("creating a task, with:"+task.getTaskName()+" "+task.getCompleteBy());
		
		org.springframework.security.core.userdetails.User user = 
				(org.springframework.security.core.userdetails.User)((UsernamePasswordAuthenticationToken) authToken).getPrincipal();
		
		sam = new User(user.getUsername(), user.getPassword());
		
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


	
	
}
