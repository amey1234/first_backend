package com.statetransport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statetransport.entity.Districts;
import com.statetransport.exception.DistrictException;
import com.statetransport.response.ResponseBean;
import com.statetransport.service.DistrictService;

@RestController
@RequestMapping("/district")
public class DistrictsController {

	@Autowired
	private DistrictService districtsService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseBean> createNewDistrict(@RequestBody Districts district) throws DistrictException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(districtsService.createNewDistrict(district), HttpStatus.CREATED.value()), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseBean> getAllDistricts() throws DistrictException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(districtsService.getAllDistricts(),HttpStatus.OK.value()), HttpStatus.OK);
	}
}
