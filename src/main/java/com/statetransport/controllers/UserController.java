package com.statetransport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statetransport.exception.DepotException;
import com.statetransport.exception.RolesException;
import com.statetransport.exception.UserException;
import com.statetransport.request.UserRequest;
import com.statetransport.response.ResponseBean;
import com.statetransport.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseBean> createUser(@RequestBody UserRequest userRequest) throws UserException, DepotException, RolesException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(userService.createNewUser(userRequest), HttpStatus.CREATED.value()), HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<ResponseBean> getAllUsers() throws UserException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(userService.getAllUsers(), HttpStatus.OK.value()), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseBean> getUserById(@PathVariable("id")Long userId) throws UserException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(userService.getUserById(userId),HttpStatus.OK.value()), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseBean> deleteUserById(@PathVariable("id")Long userId) throws UserException{
		userService.deletUser(userId);
		return new ResponseEntity<ResponseBean>(new ResponseBean(null,HttpStatus.NO_CONTENT.value()), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseBean> updateUser(@RequestBody UserRequest userRequest) throws UserException, DepotException, RolesException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(userService.updateUser(userRequest), HttpStatus.OK.value()), HttpStatus.CREATED);
	}
	
}
