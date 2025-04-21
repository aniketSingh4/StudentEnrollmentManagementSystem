package org.project.entity;

public class ResponseStructure <T>
{
	private long statusCode;
	
	private String message;
	
	private T Data;
	

	//Getter and Setter Method
	public long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}
}
