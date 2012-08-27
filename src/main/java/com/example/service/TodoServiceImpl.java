package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.model.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	@PersistenceContext
	EntityManager em;
	
	private static Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	@Override
	public void createTask(Todo todo) {
		em.persist(todo);
		logger.info("Todo created");
		return;
	}

	@Override
	public void deleteTask(Integer id) {
		Todo task = em.find(Todo.class, id);
		if (null != task)
			em.remove(task);
	}

	@Override
	public boolean markAsCompleted(Integer id) {
		Todo task = em.find(Todo.class, id);
		if (null != task){
			task.setCompleted(true);
			em.merge(task);
			return true;
		} else {
			return false;
		}
	}
}
