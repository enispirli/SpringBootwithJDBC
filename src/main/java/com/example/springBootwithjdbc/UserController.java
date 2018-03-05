package com.example.springBootwithjdbc;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("users")
	Collection<User> listUsers() {
		return userRepository.findAll();
	}

}
