package com.statetransport.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statetransport.dao.DistrictsDAO;
import com.statetransport.entity.Districts;
import com.statetransport.exception.DistrictException;
import com.statetransport.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictsDAO districtsDAO;
	
	@Override
	public Districts createNewDistrict(Districts district) throws DistrictException {
		districtsDAO.checkDistrictByName(district.getName());
		return districtsDAO.createNewDistrict(district);
	}

	@Override
	public List<Districts> getAllDistricts() throws DistrictException {
		return districtsDAO.getAllDistricts();
	}

}
