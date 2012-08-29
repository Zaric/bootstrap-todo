package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Tag;
import com.example.model.Task;
import com.example.model.User;

@Service
public class TaskServiceImpl implements TaskService {

	@PersistenceContext
	EntityManager em;
	
	private static Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Transactional
	public void createTask(Task task) {
				
		// save the tags first
		for (Tag tag : task.getTags()) {

			if (tag.getTagId() == null){
				logger.info("persisting new tag");
				em.persist(tag);
			} else {
				logger.info("merging existing tag");
				em.merge(tag);
			}
		}
		logger.info("tags persisted");

//		logger.info("user attached? "+em.contains(task.getUser()));
		
		if(task.getUser() != null){
//			User u = task.getUser();
//			List<Task> listOfTask = new ArrayList<Task>();
//			listOfTask.add(task);
//			
//			u.setListOfTasks(listOfTask);
			
			task.setUser(em.merge(task.getUser()));
			
			em.persist(task);
			logger.info("merged existing task");
		}
				
		
		logger.info("Task created");

		return;
	}

	@Transactional
	public void deleteTask(Integer id) {
		Task task = em.find(Task.class, id);
		if (null != task)
			em.remove(task);
		logger.info("task deleted");
	}

	@Transactional
	public boolean markAsCompleted(Integer id) {
		Task task = em.find(Task.class, id);
		if (null != task){
			task.setCompleted(true);
			em.merge(task);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public List<Task> listAll() {
		CriteriaQuery<Task> c = em.getCriteriaBuilder().createQuery(Task.class);
		Root<Task> from = c.from(Task.class);
		c.orderBy(em.getCriteriaBuilder().asc(from.get("taskName")));
		
		return em.createQuery(c).getResultList();
	}
}
