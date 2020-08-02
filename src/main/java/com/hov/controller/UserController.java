package com.hov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hov.model.User;
import com.hov.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		if(userService.addUser(user)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);	 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		if(userService.addUser(user)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY); 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@RequestBody User user) {
		if(userService.deleteUser(user)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@GetMapping("/getall")
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/getbyemail/{email}")
	public ResponseEntity<User> getAllUsers(@PathVariable("email") String email) {
		return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
	}
}
