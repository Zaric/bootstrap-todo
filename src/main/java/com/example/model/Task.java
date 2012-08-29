package com.example.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task implements Serializable{

	private static final long serialVersionUID = 872251771684862390L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="taskId")
	private Integer id;
	
	@Column(name="taskname", length=50, nullable=false)
	private String taskName;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="completeBy")
	private Date completeBy;
	
	@Column(name="isCompleted")
	private boolean isCompleted;

	@ManyToMany(targetEntity = Tag.class, fetch=FetchType.EAGER)
	@JoinTable(name="TASK_TAG")
	private List<Tag> tags;
	
	public Task() {
	}
	
	public Task(String taskName, Date createdDate, Date completeBy,
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
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
