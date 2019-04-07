package com.statetransport.response;

import com.statetransport.constants.Constants;

public class ResponseBean {

	private int statusCode;
	private int errorCode;
	private String message;
	private Object data;

	public ResponseBean() {
		
	}
	
	public ResponseBean(Object data, int statusCode) {
		this.data = data;
		this.statusCode = statusCode;
		this.message = Constants.SUCCESS_MESSAGE;
	}
	
	public ResponseBean(int statusCode) {
		this.statusCode = statusCode;
		this.message = Constants.SUCCESS_MESSAGE;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
