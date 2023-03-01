package com.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmailAndPassword(String email, String password);

}
