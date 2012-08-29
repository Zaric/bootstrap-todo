package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="tag")
public class Tag implements Serializable{

	private static final long serialVersionUID = 7586169687511056865L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID")
	private Long tagId;
	
	@Column(name="TAGNAME")
	private String tagName;
	
	@ManyToMany(targetEntity=Task.class, mappedBy="tags", fetch=FetchType.EAGER)
	private List<Task> tasks;

	public Tag() {
	}
	
	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
//	Note to future self: set this whenever you set the tag. 
//	private boolean tagCount; 
}
