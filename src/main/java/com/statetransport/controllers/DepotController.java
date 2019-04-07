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
import com.statetransport.exception.DistrictException;
import com.statetransport.request.Depots;
import com.statetransport.response.ResponseBean;
import com.statetransport.service.DepotService;

@RestController
@RequestMapping("/depot")
public class DepotController {

	@Autowired
	private DepotService depotService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseBean> createDepot(@RequestBody Depots depot) throws DepotException, DistrictException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(depotService.createNewDepot(depot), HttpStatus.CREATED.value()), HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<ResponseBean> getAllDepotList() throws DepotException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(depotService.getall(), HttpStatus.OK.value()), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseBean> getDepotById(@PathVariable(name="id")int depotId) throws DepotException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(depotService.getDepotById(depotId), HttpStatus.FOUND.value()), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseBean> updateDepot(@RequestBody Depots depot) throws DepotException, DistrictException{
		return new ResponseEntity<ResponseBean>(new ResponseBean(depotService.updateDepot(depot), HttpStatus.NO_CONTENT.value()), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseBean> deleteDepotById(@PathVariable(name="id")int depotId) throws DepotException{
		depotService.deleteDepotById(depotId);
		return new ResponseEntity<ResponseBean>(new ResponseBean(HttpStatus.NO_CONTENT.value()), HttpStatus.OK);
	}
}
