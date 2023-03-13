package com.app.controller;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.SignupDto;
import com.app.dto.UserDto;
import com.app.helper.JwtUtil;
import com.app.model.JwtRequest;
import com.app.model.JwtResponse;
import com.app.pojos.User;
import com.app.repository.UserRepo;
import com.app.service.CustomUserDetailService;
import com.app.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class JwtController {
	
	@Autowired
	private CustomUserDetailService customdetDetailService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userserv;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepo repo;
	
	@RequestMapping(value ="/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest req) throws Exception
	{
		System.out.println(req.getUsername()+" "+req.getPassword());
		try
		{
			System.out.println("in generate token method");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword()));
		
		}
		catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
	}
		User user = repo.findByEmail(req.getUsername()).get();
		UserDto dto = mapper.map(user, UserDto.class);
		UserDetails userDetails= customdetDetailService.loadUserByUsername(req.getUsername());
		String token=jwtutil.generateToken(userDetails);
		System.out.println("Token for user "+token);
		return ResponseEntity.ok(new JwtResponse(token,dto));
	}
	
	@RequestMapping(value = "/signup",method = RequestMethod.POST)
	public JwtResponse signupUser(@RequestBody SignupDto dto) {
		User newUser= mapper.map(dto, User.class);
	    User insertUser= userserv.addUser(newUser); 
	    UserDto dto2 = mapper.map(insertUser, UserDto.class);
		return new JwtResponse(dto2);
	}
		
		

}
