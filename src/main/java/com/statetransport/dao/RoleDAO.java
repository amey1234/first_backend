package com.statetransport.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.statetransport.entity.Roles;
import com.statetransport.exception.RolesException;

@Repository
public interface RoleDAO {

	public Roles getRoleById(int roleId) throws RolesException;
	
	public Roles createRole(Roles role);
	
	public List<Roles> getAllRoles() throws RolesException;
	
	public Roles updateRole(Roles role) throws RolesException;
	
	public Roles checkIfRoleExist(String roleName) throws RolesException;
}
