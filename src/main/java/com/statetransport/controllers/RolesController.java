package com.statetransport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statetransport.entity.Roles;
import com.statetransport.exception.RolesException;
import com.statetransport.response.ResponseBean;
import com.statetransport.service.RolesService;

@RestController
@RequestMapping("role")
public class RolesController {

	@Autowired
	public RolesService rolesService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseBean> createRole(@RequestBody Roles role) throws RolesException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(rolesService.createNewRole(role), HttpStatus.CREATED.value()), HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseBean> getAllRoles() throws RolesException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(rolesService.getAllRoles(), HttpStatus.OK.value()), HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseBean> updateRole(@RequestBody Roles role) throws RolesException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(rolesService.updateRole(role), HttpStatus.NO_CONTENT.value()), HttpStatus.OK);
		
	}
	
}
