package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User addUser(User adduser);
	
	String deleteUser(Long id);
	
	User updateUser(User updateUser);
	
	Optional<User> getUserById(Long id);

}
