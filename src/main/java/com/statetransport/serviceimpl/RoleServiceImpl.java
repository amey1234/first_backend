package com.statetransport.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statetransport.dao.RoleDAO;
import com.statetransport.entity.Roles;
import com.statetransport.exception.RolesException;
import com.statetransport.service.RolesService;


@Service
public class RoleServiceImpl implements RolesService {

	@Autowired
	public RoleDAO roleDao;
	
	@Override
	public Roles createNewRole(Roles role) throws RolesException {
		Roles roleCheck=roleDao.checkIfRoleExist(role.getName());
		
		return roleDao.createRole(role);
	}

	@Override
	public List<Roles> getAllRoles() throws RolesException {
		return roleDao.getAllRoles();
	}

	@Override
	public Roles updateRole(Roles role) throws RolesException {
		Roles ifRolePresent=roleDao.getRoleById(role.getId());
		return roleDao.updateRole(role);
	}

}
