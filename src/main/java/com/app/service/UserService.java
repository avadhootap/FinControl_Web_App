package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.SignInDto;
import com.app.dto.UpdateNames;
import com.app.dto.UpdatePassword;
import com.app.pojos.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User addUser(User adduser);
	
	String deleteUser(Long id);
	
	User updateUser(User updateUser);
	
	User getUserById(Long id);
	
	Optional<User> findByEmailAndPassword(SignInDto dto);
	
	public String updateNames(Long id, UpdateNames updatename);
	
	public String updatePassword(Long id,UpdatePassword updatepassword);

}
