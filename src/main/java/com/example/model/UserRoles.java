package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
@SequenceGenerator(name="user_role_sequence", sequenceName="user_role_sequence")
public class UserRoles implements Serializable{

	private static final long serialVersionUID = -5116150317039379211L;

	@Id
	@GeneratedValue(generator="user_role_sequence")
	@Column(name="user_role_id")
	private Long userRoleId;
	
	@ManyToMany(targetEntity=User.class, mappedBy="userRoles", fetch=FetchType.EAGER)
	private List<User> users;
	
	@Column(name="authority")
	private String authority;

	/*	Constructors	*/
	
	public UserRoles() { }
	
	public UserRoles(String authority) {
		this.authority = authority;
	}
	
	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
