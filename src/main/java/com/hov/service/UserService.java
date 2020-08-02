package com.hov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hov.model.User;
import com.hov.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public boolean addUser(User user) {
		try {
			userRepository.save(user);
			return true;
		}
		catch(Exception e) {
		}
		return false;
	}
	
	public boolean updateUser(User user) {
		try {
			if(!"".equals(user.getUserId())) {
				userRepository.save(user);
				return true;
			}
		}
		catch(Exception e) {
		}
		return false;
	}
	
	public boolean deleteUser(User user) {
		try {
			userRepository.delete(user);
			return true;
		}
		catch(Exception e) {
		}
		return false;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
