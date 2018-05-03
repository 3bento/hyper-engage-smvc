package com.kennycode.hyperengagesmvc.controllers;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kennycode.hyperengagesmvc.models.User;
import com.kennycode.hyperengagesmvc.models.UserMessage;
import com.kennycode.hyperengagesmvc.services.Authentication;

@Controller
public class AuthController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Authentication authentication;

	// inject via application.properties
	@Value("${welcome.message:test")
	private String message = "Hi quiin, welcome to JAVA EE";

	@RequestMapping("/")
	public String welcome(Locale locale, Model model) {

		// add parametrized message from controller
		String welcome = messageSource.getMessage("welcome.message", new Object[] { "K3nny C0d3" }, locale);
		model.addAttribute("message", welcome);

		// obtain locale from LocaleContextHolder
		Locale currentLocale = LocaleContextHolder.getLocale();
		model.addAttribute("locale", currentLocale);
		model.addAttribute("startMeeting", "10:30");

		return "welcome";
	}

	@RequestMapping(name = "/signup/save", method = RequestMethod.POST)
	public String signinSave(Map<String, Object> model, @ModelAttribute User user) {

		UserMessage userMessage = new UserMessage();

		// try to save user
		if (user != null) {
			// user = authentication.create(user);
			userMessage.setError(false);
			userMessage.setMessage("User created with success!");
		} else {
			userMessage.setError(true);
			userMessage.setMessage("User not created with success!");
		}

		model.put("message", this.message);
		return "auth/signin";
	}

	@RequestMapping("/xxxxxx")
	public String singupxx(Map<String, Object> model) {
		model.put("message", this.message);
		return "auth/signup";
	}

	@RequestMapping("/signup")
	public String singup(Map<String, Object> model) {
		model.put("message", this.message);
		return "auth/signup";
	}

	@RequestMapping("/signin")
	public String signin(Map<String, Object> model) {
		model.put("message", this.message);
		return "auth/signin";
	}

	@RequestMapping("/aboutus")
	public String aboutus(Map<String, Object> model) {
		model.put("message", this.message);
		return "aboutus";
	}

	@RequestMapping("/sayHi")
	@ResponseBody
	String name() {
		return "Hello Quiin, that is Java Web Example!!!!";
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Error> handle(RuntimeException ex) {
		System.out.println("controller local exception handling @ExceptionHandler");
		Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
