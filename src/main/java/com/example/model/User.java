package com.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class User implements Serializable {

	private static final long serialVersionUID = 4586638386332302861L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String userName;
	
	private String passwd;

	public User() {
		
	}
	
	public User(String userName, String passwd) {
		super();
		this.userName = userName;
		this.passwd = passwd;
	}

	public String getUserName() {
		return userName;
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
	
	
	
}
