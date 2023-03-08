package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.SignInDto;
import com.app.dto.UpdateNames;
import com.app.dto.UpdatePassword;
import com.app.pojos.User;
import com.app.service.UserService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservices;
	
	@GetMapping
	public List<User>getAllUser(){
		return userservices.getAllUsers();
	}
	
	@GetMapping("/updateName")
	public String updateNames(Long id, UpdateNames updatename) {
		return userservices.updateNames(id, updatename);
	}
	
	@GetMapping("/signin")
	User findByEmailAndPassword(SignInDto dto) {
		return userservices.findByEmailAndPassword(dto);
	}
	
	@GetMapping("/Changepassword")
	public String updatePassword(Long id, UpdatePassword updatepassword) {
		return userservices.updatePassword(id, updatepassword);
	}
	
	@PostMapping("/adduser")
	User addUser(@RequestBody User user) {
		return userservices.addUser(user);
	}
	
	@PostMapping("/findbyid")
	public User getUserById(Long id){
	return userservices.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	String deleteUser(@PathVariable Long id) {
		return userservices.deleteUser(id);
	}
	
	@PutMapping
	User updateUser(@RequestBody User updateuser) {
	return userservices.updateUser(updateuser);
	}

}
