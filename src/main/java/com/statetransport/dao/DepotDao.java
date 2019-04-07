package com.statetransport.dao;

import java.util.List;

import com.statetransport.entity.Depot;
import com.statetransport.exception.DepotException;

public interface DepotDao {
	
	public void checkDepotNameIfPresent(Depot depot) throws DepotException;
	
	public Depot createNewDepot(Depot depot) throws DepotException;
	
	public List<Depot> getall() throws DepotException;
	
	public Depot updateDepot(Depot depot) throws DepotException;
	
	public Depot getDepotById(int depotId) throws DepotException;
	
	public void deleteDepot(int depotId) throws DepotException;
}
