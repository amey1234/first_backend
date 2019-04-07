package com.statetransport.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.statetransport.entity.Districts;
import com.statetransport.exception.DistrictException;

@Repository
public interface DistrictsDAO {

	public Districts createNewDistrict(Districts districts) throws DistrictException;
	
	public void checkDistrictByName(String name) throws DistrictException;
	
	public List<Districts> getAllDistricts() throws DistrictException;
	
	public Districts getDistrictById(Integer id) throws DistrictException;
	
}
