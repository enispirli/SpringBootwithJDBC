package com.example.springBootwithjdbc;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	Collection<User> listUsers() {
		return userRepository.findAll();
	}

	@GetMapping("{id}")
	User getUser(@PathVariable("id") int id) {
		return userRepository.findUserById(id);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	User createUser(@RequestBody User user) {
		return userRepository.create(user);
	}
	
	
	@DeleteMapping("{id}")
	void deleteUser(@PathVariable("id") int id) {
		userRepository.delete(id);
	}
	
	@PutMapping
	void update(@RequestBody User user) {
		userRepository.update(user);
	}
}
