package com.statetransport.exception;

public class DepotException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum DepoException {

		DEPOT_NOT_FOUND(700), DEPOT_ALREADY_EXIST(701);

		private int value;

		private DepoException(int value) {
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

	public DepotException(DepoException ex) {
		super();
		this.errorCode = ex.getValue();
		this.message = ex.name();
	}

}
