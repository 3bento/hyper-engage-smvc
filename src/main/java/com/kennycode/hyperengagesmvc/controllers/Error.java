package com.kennycode.hyperengagesmvc.controllers;

public class Error {
	private int code;
	private String message;

	public Error() {

	}

	public Error(int code, String message) {

	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}