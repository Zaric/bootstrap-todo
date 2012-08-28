package com.example.service;

import java.util.List;

import com.example.model.Task;

public interface TaskService {

	public void createTask(Task task);

	public void deleteTask(Integer id);

	public boolean markAsCompleted(Integer id);

	public List<Task> listAll();
}
