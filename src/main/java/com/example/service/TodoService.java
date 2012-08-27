package com.example.service;

import com.example.model.Todo;

public interface TodoService {

	public void createTask(Todo todo);

	public void deleteTask(Integer id);

	public boolean markAsCompleted(Integer id);

}
