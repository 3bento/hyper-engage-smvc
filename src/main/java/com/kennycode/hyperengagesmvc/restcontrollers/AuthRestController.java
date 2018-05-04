package com.kennycode.hyperengagesmvc.restcontrollers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kennycode.hyperengagesmvc.models.UserMessage;
import com.kennycode.hyperengagesmvc.services.Authentication;

@RestController
public class AuthRestController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Authentication authentication;

	private UserMessage userMessage;


	@RequestMapping("/signup/search/{uName}")
	public UserMessage signinFindName(@PathVariable(value = "uName") String userName, Locale locale) {

		userMessage = authentication.checkUsername(userName, locale);
		return userMessage;

	}

}
