package com.kennycode.hyperengagesmvc.services;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kennycode.hyperengagesmvc.config.RecaptchaSettings;
import com.kennycode.hyperengagesmvc.models.UserMessage;


@Service
public class RecaptchaService implements IRecaptchaService{
	
	private static Pattern TOKEN_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	RecaptchaSettings recaptchaSettings;
	
	@Override
	public UserMessage process(String token, String ip) {
		UserMessage userMessage = new UserMessage();
		
		// check if recaptcha token is valid!
		if(isTokenValid(token)) {
			// create body to send to google recaptcha to check the token!
			Map<String, String> body = new HashMap<>();
			body.put("secret", recaptchaSettings.getSecret());
			body.put("response", token);
			body.put("remoteip", ip);
			
			// build the uri and send post to google recaptcha
			URI verifyUri = URI.create(String.format(recaptchaSettings.getUrl()+"?secret=%s&response=%s&remoteip=%s", recaptchaSettings.getSecret(), token, ip));
			ResponseEntity<Map> recaptchaResponseEntity = restTemplateBuilder.build().postForEntity(verifyUri.toString(), body, Map.class, body);
			
			// get the response and check if got success message.
			Map<String, Object> responseBody = recaptchaResponseEntity.getBody();
			boolean recaptchaSuccess = (Boolean) responseBody.get("success");
			
			// check if recaptcha is okay or not.
			if(recaptchaSuccess) {
				userMessage.setIsError(false);
				userMessage.addDescription("Recaptcha is okay!");
			}else {
				// get the list of errors and put in userMessage (my default object to errors)
				List<String> errorCodes = (List<String>) responseBody.get("error-codes");
				userMessage.setIsError(true);
				for(String errorCode:errorCodes) {
					userMessage.addDescription(errorCode);
				}
			}
		} else {
			// token of recaptcha is invalid!
			userMessage.setIsError(true);
			userMessage.addDescription("Recaptcha Token is invalid! try again!");
		}

		return userMessage;
	}

	@Override
	public boolean isTokenValid(String token) { 
		return StringUtils.hasLength(token) && TOKEN_PATTERN.matcher(token).matches();
	}
}
