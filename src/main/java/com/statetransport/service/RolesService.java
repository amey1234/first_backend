package com.statetransport.service;

import java.util.List;

import com.statetransport.entity.Roles;
import com.statetransport.exception.RolesException;

public interface RolesService {

	public Roles createNewRole(Roles role) throws RolesException;
	
	public List<Roles> getAllRoles() throws RolesException;
	
	public Roles updateRole(Roles role) throws RolesException;
}
