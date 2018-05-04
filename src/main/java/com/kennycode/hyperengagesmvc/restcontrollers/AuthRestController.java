package com.kennycode.hyperengagesmvc.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kennycode.hyperengagesmvc.models.User;
import com.kennycode.hyperengagesmvc.models.UserMessage;
import com.kennycode.hyperengagesmvc.services.Authentication;

@RestController
public class AuthRestController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private Authentication authentication;

	/**
	 * Receive the username by pathVarible, check if that user name is avaliable and return
	 * the userMessage.
	 * @param userName
	 * @return
	 */
	@RequestMapping("/signup/search/{uName}")
	public UserMessage signinFindName(@PathVariable(value="uName") String userName) {

		User user = authentication.existUserName(userName);
		UserMessage userMessage = new UserMessage();

		if(user == null) {
			userMessage.setError(false);
			userMessage.setMessage("User name is avaliable.");
		}else {
			userMessage.setError(true);
			userMessage.setMessage("User is not avaliable.");
		}

		return userMessage;
	}
	
}
