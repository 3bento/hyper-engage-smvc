package com.kennycode.hyperengagesmvc.models;

public class UserMessage {

	private boolean error;
	private String description;
	private Object object;

	public UserMessage() {

	}

	public UserMessage(boolean error, String description, Object object) {
		super();
		this.error = error;
		this.description = description;
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
