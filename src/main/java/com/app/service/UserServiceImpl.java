package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.SignInDto;
import com.app.dto.UpdateNames;
import com.app.dto.UpdatePassword;
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
	public User getUserById(Long id) {
		return userrepo.findById(id).get();
	}

	@Override
	public String updateNames(Long id, UpdateNames updatename) {
		if(userrepo.existsById(id)) {
			User updateName=getUserById(id);
			updateName.setFirstName(updatename.getFirstName());
			updateName.setLastname(updatename.getLastname());
			userrepo.save(updateName);
			return "Name Change SucessFull";
			
		}
		return "Error Changing Name Check Id";
	}

	@Override
	public User findByEmailAndPassword(SignInDto dto) {
		return userrepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
	}

	@Override
	public String updatePassword(Long id, UpdatePassword updatepassword) {
		if(userrepo.existsById(id)) {
			User updatePassword=getUserById(id);
			updatePassword.setPassword(updatepassword.getPassword());
			updatePassword.setConfirmPassword(updatepassword.getConfirmPassword());
			userrepo.save(updatePassword);
			return "Password Changed SuccessFully...";
		}
		return "Updation Failed Check Id";
	}



}
