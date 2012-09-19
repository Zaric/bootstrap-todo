package com.example.service;

import com.example.model.User;

public interface UserService {

	public void addUser(User user);
	public boolean validateUser(User user);
//	public void removeUser(User user);
//	public void addUser(User user, List<UserRoles> userRoles);
}
