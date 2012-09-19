package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
@SequenceGenerator(name = "user_sequence", sequenceName="user_sequence")
public class User implements Serializable {

	private static final long serialVersionUID = 4586638386332302861L;

	@Id
	@GeneratedValue(generator="user_sequence")
	@Column(name="user_id")
	private Long id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="passwd")
	private String passwd;

	@Column(name="enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy="user")
	private List<Task> listOfTasks;
	
//	@ManyToMany(targetEntity=UserRoles.class, mappedBy="users", fetch=FetchType.EAGER)
	@ManyToMany
	@JoinTable(name="USER_ROLE_JOIN")
	private List<UserRoles> userRoles;
	
	/* Constructors */
	public User() {
		
	}
	
	public User(String userName, String passwd) {
		super();
		this.userName = userName;
		this.passwd = passwd;
	}

	/* getters/setters */
	
	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public List<Task> getListOfTasks() {
		return listOfTasks;
	}

	public void setListOfTasks(List<Task> listOfTasks) {
		this.listOfTasks = listOfTasks;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
