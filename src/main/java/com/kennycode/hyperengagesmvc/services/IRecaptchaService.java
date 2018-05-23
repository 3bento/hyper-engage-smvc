package com.kennycode.hyperengagesmvc.services;

import com.kennycode.hyperengagesmvc.models.UserMessage;

public interface IRecaptchaService {

	public boolean isTokenValid(String token);
	public UserMessage process(String token, String ip);
}
