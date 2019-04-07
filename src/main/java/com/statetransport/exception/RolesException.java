package com.statetransport.exception;

public class RolesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum RoleException{
		ROLE_NOT_FOUND(600),
		ROLE_ALREADY_EXIST(601);
		
		 private int value;
	    private RoleException(int value){
	        this.value = value;
	    }
		
		public int getValue() {
			return value;
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
	public RolesException(RoleException ex) {
		super();
		this.errorCode = ex.getValue();
		this.message = ex.name();
	}
	
	

}
