package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class User implements Serializable {

	private static final long serialVersionUID = 4586638386332302861L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="passwd")
	private String passwd;

	@OneToMany(mappedBy="user")
	private List<Task> listOfTasks;

	/* Constructors */
	public User() {
		
	}
	
	public User(String userName, String passwd) {
		super();
		this.userName = userName;
		this.passwd = passwd;
	}

	/* getters/setters */
	
	public String getUserName() {
		return userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public List<Task> getListOfTasks() {
		return listOfTasks;
	}

	public void setListOfTasks(List<Task> listOfTasks) {
		this.listOfTasks = listOfTasks;
	}
	
}
