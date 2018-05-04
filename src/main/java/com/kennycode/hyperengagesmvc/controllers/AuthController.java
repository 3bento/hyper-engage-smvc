package com.kennycode.hyperengagesmvc.controllers;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kennycode.hyperengagesmvc.models.User;
import com.kennycode.hyperengagesmvc.models.UserMessage;
import com.kennycode.hyperengagesmvc.services.Authentication;

@Controller
public class AuthController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Authentication authentication;

	@RequestMapping(name = "/signup/save", method = RequestMethod.POST)
	public String signinSave(RedirectAttributes  redirectAttrs, @ModelAttribute User user, Locale locale) {
		
		UserMessage userMessage = authentication.createUser(user, locale);
		redirectAttrs.addFlashAttribute("message", userMessage);
		
		if(userMessage.isError()) {
			return "redirect:/signup";
		}

		return "redirect:/";
	}

	@RequestMapping("/signup")
	public String singup(Map<String, Object> model) {
		return "auth/signup";
	}

	@RequestMapping("/signin")
	public String signin(Map<String, Object> model) {
		return "auth/signin";
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Error> handle(RuntimeException ex) {
		System.out.println("controller local exception handling @ExceptionHandler");
		Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
