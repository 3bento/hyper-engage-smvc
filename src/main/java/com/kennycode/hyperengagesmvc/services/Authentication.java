package com.kennycode.hyperengagesmvc.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennycode.hyperengagesmvc.irepository.UserRepository;
import com.kennycode.hyperengagesmvc.models.User;
import com.kennycode.hyperengagesmvc.util.PasswordEncrypt;

@Service
public class Authentication {
	
	@Autowired
	private UserRepository userRepository;

	public User create(User user) {
		long now = Calendar.getInstance().getTimeInMillis();
		user.setCreated(now);
		user.setUpdated(now);
		user.setPassword(PasswordEncrypt.encryptSHA(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User existUserName(String userName){
		return userRepository.findByUsername(userName);
	}
}
