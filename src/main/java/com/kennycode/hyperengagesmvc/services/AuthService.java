package com.kennycode.hyperengagesmvc.services;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.kennycode.hyperengagesmvc.irepository.UserRepository;
import com.kennycode.hyperengagesmvc.models.User;
import com.kennycode.hyperengagesmvc.models.UserMessage;
import com.kennycode.hyperengagesmvc.util.PasswordEncrypt;

@Service
public class AuthService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserRepository userRepository;

	private UserMessage userMessage;

	private boolean existUsername(String username) {
		if (userRepository.findFirstByUsername(username) != null)
			return true;
		return false;
	}

	private boolean existEmail(String email) {
		if (userRepository.findFirstByEmail(email) != null)
			return true;
		return false;
	}
	public UserMessage createUser(User user, Locale locale) {

		userMessage = new UserMessage();

		// if user is null, set message and return.
		if (user == null) {
			userMessage.setIsError(true);
			userMessage.addDescription(messageSource.getMessage("usermessage.user.not.created", null, locale));
			userMessage.setObject(user);
			return userMessage;
		}

		// verified if username and email exist.
		boolean existUsername = existUsername(user.getUsername());
		boolean existEmail = existEmail(user.getEmail());

		// if they don't exist go forward and register.
		if (!existUsername && !existEmail) {
			long now = Calendar.getInstance().getTimeInMillis();
			user.setCreated(now);
			user.setUpdated(now);
			user.setPassword(PasswordEncrypt.encryptSHA(user.getPassword()));
			user = userRepository.save(user);
			userMessage.setIsError(false);
			userMessage.addDescription(messageSource.getMessage("usermessage.user.created", null, locale));
			userMessage.setObject(user);
		} else {
			userMessage.setIsError(true);
			
			if(existUsername)
				userMessage.addDescription(messageSource.getMessage("usermessage.user.username.exist", null, locale));
			if(existEmail)
				userMessage.addDescription(messageSource.getMessage("usermessage.user.email.exist", null, locale));

			userMessage.setObject(user);
			return userMessage;
		}
		return userMessage;
	}

	/**
	 * Receive the username by pathVarible, check if that user name is avaliable and
	 * return the userMessage.
	 * 
	 * @param userName
	 * @param locale
	 *            need it to internationalization
	 * @return
	 */
	public UserMessage checkUsername(String username, Locale locale) {

		userMessage = new UserMessage();
		User user = userRepository.findFirstByUsername(username);

		if (user == null) {
			userMessage.addDescription(messageSource.getMessage("usermessage.user.username.not.exist", null, locale));
			userMessage.setIsError(false);
			userMessage.setObject(user);
		} else {
			userMessage.addDescription(messageSource.getMessage("usermessage.user.username.exist", null, locale));
			userMessage.setIsError(true);
			userMessage.setObject(user);
		}

		return userMessage;
	}
}
