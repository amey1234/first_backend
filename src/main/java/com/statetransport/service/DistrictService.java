package com.statetransport.service;

import java.util.List;

import com.statetransport.entity.Districts;
import com.statetransport.exception.DistrictException;

public interface DistrictService {

	public Districts createNewDistrict(Districts district) throws DistrictException;
	
	public List<Districts> getAllDistricts() throws DistrictException;
}
