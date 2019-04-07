package com.statetransport.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.statetransport.dao.RoleDAO;
import com.statetransport.entity.Roles;
import com.statetransport.exception.RolesException;
import com.statetransport.exception.RolesException.RoleException;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	public SessionFactory hibernateSession;

	@Override
	public Roles getRoleById(int roleId) throws RolesException {
		Roles role = hibernateSession.getCurrentSession().get(Roles.class, roleId);
		if (role == null) {
			throw new RolesException(RoleException.ROLE_NOT_FOUND);
		}
		return role;
	}

	@Override
	public Roles createRole(Roles role) {
		hibernateSession.getCurrentSession().save(role);
		return role;
	}

	@Override
	public List<Roles> getAllRoles() throws RolesException {
		Criteria criteria = hibernateSession.getCurrentSession().createCriteria(Roles.class);
		criteria.add(Restrictions.eq("status", true));
		List<Roles> rolesList = criteria.list();
		if (rolesList.isEmpty()) {
			throw new RolesException(RoleException.ROLE_NOT_FOUND);
		}
		return rolesList;
	}

	@Override
	public Roles updateRole(Roles role) throws RolesException {
		hibernateSession.getCurrentSession().update(role);
		return role;
	}

	@Override
	public Roles checkIfRoleExist(String roleName) throws RolesException {
		Criteria criteria = hibernateSession.getCurrentSession().createCriteria(Roles.class);
		criteria.add(Restrictions.eq("name", roleName));
		if (criteria.list().size() > 0) {
			throw new RolesException(RoleException.ROLE_ALREADY_EXIST);
		}
		return null;
	}

}
