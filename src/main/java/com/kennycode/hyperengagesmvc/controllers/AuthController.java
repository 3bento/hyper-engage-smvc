package com.kennycode.hyperengagesmvc.controllers;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kennycode.hyperengagesmvc.models.User;
import com.kennycode.hyperengagesmvc.models.UserMessage;
import com.kennycode.hyperengagesmvc.services.Authentication;
import com.kennycode.hyperengagesmvc.util.ValidateUser;

@Controller
public class AuthController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Authentication authentication;

	@PostMapping("/signup/save")
	public String signinSave(RedirectAttributes  redirectAttrs, @ModelAttribute User user, Locale locale) {
		
		// validate user from create Account
		if(ValidateUser.createAccount(user)) { 
			// fields is okay, try to save user.
			UserMessage userMessage = authentication.createUser(user, locale);
			redirectAttrs.addFlashAttribute("message", userMessage);
			
			if(userMessage.getIsError()) {
				// probably got error to save user.
				return "redirect:/signup";
			}
			
			// TODO send email to active account.
 			
			
			// everything is okay.
			return "redirect:/signin";
		}else {
			// fields is not okay.
			// that method should return list of errors with more details, but i don't know how it will looks like (strucutre).
			ValidateUser.createAccountGetErrors(user);
			// temporary message of problem with fields of user to create account.
			UserMessage userMessage = new UserMessage(true, "Cannot create account (check fields) username, email and password.", user);
			redirectAttrs.addFlashAttribute("message", userMessage);
			return "redirect:/signup";
		}
	}

	@GetMapping("/signup")
	public String singup(Map<String, Object> model) {
		return "auth/signup";
	}

	@GetMapping("/signin")
	public String signin(Map<String, Object> model) {
		return "auth/signin";
	}
}
