package com.kennycode.hyperengagesmvc.models;

import java.util.ArrayList;
import java.util.List;
/**
 * I am using that class to send information to front-end, success and errors action
 * @author kenny
 *
 */
public class UserMessage {

	private boolean isError;
	private List<String> descriptions;
	private Object object;

	public UserMessage() {
		descriptions = new ArrayList<String>();
	}

	public UserMessage(boolean error, String description, Object object) {
		super();
		descriptions = new ArrayList<String>();
		this.isError = error;
		this.descriptions.add(description);
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public boolean getIsError() {
		return isError;
	}

	public void setIsError(boolean error) {
		this.isError = error;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public void addDescription(String description) {
		this.descriptions.add(description);
	}
}
