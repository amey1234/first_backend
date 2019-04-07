package com.statetransport.exception;


public class DistrictException extends Exception {

	public enum DistrictsException {

		DISTRICTS_NOT_FOUND(700), DISTRICT_ALREADY_EXIST(701);

		private int value;

		private DistrictsException(int value) {
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

	public DistrictException(DistrictsException ex) {
		super();
		this.errorCode = ex.getValue();
		this.message = ex.name();
	}

}
