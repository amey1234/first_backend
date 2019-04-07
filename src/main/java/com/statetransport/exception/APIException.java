package com.statetransport.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.statetransport.response.ResponseBean;

@ControllerAdvice
public class APIException {

	@ExceptionHandler(InternalServerError.class)
	@ResponseBody
	public ResponseEntity<ResponseBean> handleInternalServerErrorException(Exception e) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseBean.setMessage(e.getMessage());
		return new ResponseEntity<>(responseBean, HttpStatus.OK);
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ResponseEntity<ResponseBean> handleAPINotFound(Exception e) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setErrorCode(HttpStatus.NOT_FOUND.value());
		responseBean.setMessage(e.getMessage());
		return new ResponseEntity<>(responseBean, HttpStatus.OK);
	}
	
	@ExceptionHandler(RolesException.class)
	@ResponseBody
	public ResponseEntity<ResponseBean> handleRoleException(RolesException e) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setErrorCode(e.getErrorCode());
		responseBean.setMessage(e.getMessage());
		return new ResponseEntity<>(responseBean, HttpStatus.OK);
	}
	
	@ExceptionHandler(DepotException.class)
	@ResponseBody
	public ResponseEntity<ResponseBean> handleDepotException(DepotException e) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setErrorCode(e.getErrorCode());
		responseBean.setMessage(e.getMessage());
		return new ResponseEntity<>(responseBean, HttpStatus.OK);
	}
}
