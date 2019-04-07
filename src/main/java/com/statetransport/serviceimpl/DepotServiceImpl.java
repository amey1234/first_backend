package com.statetransport.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statetransport.dao.DepotDao;
import com.statetransport.dao.DistrictsDAO;
import com.statetransport.entity.Depot;
import com.statetransport.exception.DepotException;
import com.statetransport.exception.DistrictException;
import com.statetransport.request.Depots;
import com.statetransport.service.DepotService;

@Service
public class DepotServiceImpl implements DepotService {

	@Autowired
	private DepotDao depotDao;
	
	@Autowired
	private DistrictsDAO districtsDAO;

	@Override
	public Depot createNewDepot(Depots depot) throws DepotException, DistrictException {
		Depot depots=new Depot();
		depots.setDepotName(depot.getName());
		depotDao.checkDepotNameIfPresent(depots);
		depots.setAddress(depot.getAddress());
		depots.setPincode(depot.getPincode());
		depots.setStatus(true);
		depots.setDepotName(depot.getName());
		depots.setDistrict(districtsDAO.getDistrictById(depot.getDistrict_id()));
		return depotDao.createNewDepot(depots);
	}

	@Override
	public List<Depot> getall() throws DepotException {
		return depotDao.getall();
	}

	@Override
	public Depot updateDepot(Depots depot) throws DepotException, DistrictException {
		Depot checkForDepot = depotDao.getDepotById(depot.getId());
		checkForDepot.setAddress(depot.getAddress());
		checkForDepot.setDistrict(districtsDAO.getDistrictById(depot.getDistrict_id()));
		checkForDepot.setPincode(depot.getPincode());
		checkForDepot.setDepotName(depot.getName());
		checkForDepot.setStatus(depot.isStatus());
		return depotDao.updateDepot(checkForDepot);
	}

	@Override
	public Depot getDepotById(int depotId) throws DepotException {
		return depotDao.getDepotById(depotId);
	}

	@Override
	public void deleteDepotById(int depotId) throws DepotException {
		depotDao.deleteDepot(depotId);
	}

}
