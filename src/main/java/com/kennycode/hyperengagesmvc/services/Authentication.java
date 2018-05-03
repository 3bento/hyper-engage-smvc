package com.kennycode.hyperengagesmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennycode.hyperengagesmvc.irepository.UserRepository;
import com.kennycode.hyperengagesmvc.models.User;

@Service
public class Authentication {
	
	@Autowired
	private UserRepository userRepository;

	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User existUserName(String userName){
		return userRepository.findByUserName(userName);
	}
}
