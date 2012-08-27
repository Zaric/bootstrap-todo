package com.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String taskName;
	
	private Date createdDate;
	
	private Date completeBy;
	
	private boolean isCompleted;

	public Todo() {
	}
	
	public Todo(String taskName, Date createdDate, Date completeBy,
			boolean isCompleted) {
		super();
		this.taskName = taskName;
		this.createdDate = createdDate;
		this.completeBy = completeBy;
		this.isCompleted = isCompleted;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCompleteBy() {
		return completeBy;
	}

	public void setCompleteBy(Date completeBy) {
		this.completeBy = completeBy;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
	
	
}
