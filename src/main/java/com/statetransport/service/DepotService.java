package com.statetransport.service;

import java.util.List;

import com.statetransport.entity.Depot;
import com.statetransport.exception.DepotException;
import com.statetransport.exception.DistrictException;
import com.statetransport.request.Depots;

public interface DepotService {

	
	public Depot createNewDepot(Depots depot) throws DepotException, DistrictException;
	
	public List<Depot> getall() throws DepotException;
	
	public Depot updateDepot(Depots depot) throws DepotException, DistrictException;
	
	public Depot getDepotById(int depotId) throws DepotException;
	
	public void deleteDepotById(int depotId) throws DepotException;
}
