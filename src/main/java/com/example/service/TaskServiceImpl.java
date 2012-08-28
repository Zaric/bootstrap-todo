package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@PersistenceContext
	EntityManager em;
	
	
	private static Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Transactional
	public void createTask(Task task) {
		
		em.persist(task);
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
