package com.statetransport.exception;

public class UserException extends Exception{

	public enum UserExceptionMessage{
		
		USERS_NOT_FOUND(800),
		USER_NOT_FOUND(801);
		
		int code;
		
		private UserExceptionMessage(int code) {
			this.code=code;
		}
		
		public int getCode() {
			return code;
		}
	}
	
	private int errorCode;
	private String message;

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
	
	public UserException(UserExceptionMessage message) {
		errorCode=message.getCode();
		this.message=message.name();
	}
}
