package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.pojos.BaseEntity;
import com.app.pojos.User;
import com.app.repository.UserRepo;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userrepo;
     

	@Override
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	@Override
	public User addUser(User adduser) {
		return userrepo.save(adduser);
	}

	@Override
	public String deleteUser(Long id) {
	if(userrepo.existsById(id)) {
		userrepo.deleteById(id);
		return "User Deleted Successfully....";
	}
		return "Deletion Failed";
	}

	@Override
	public User updateUser(User updateUser) {
		if(userrepo.existsById(updateUser.getId())) {
			return userrepo.save(updateUser);
		}
		return null;
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userrepo.findById(id);
	}

}
