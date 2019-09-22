package com.onlineshop.service;

import com.onlineshop.model.Users;

public interface UsersService {

	public void addUsers(Users users);
	
	Users findUserByusername(String username);
}
