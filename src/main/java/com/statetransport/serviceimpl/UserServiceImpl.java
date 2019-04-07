package com.statetransport.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statetransport.dao.RoleDAO;
import com.statetransport.dao.UserDAO;
import com.statetransport.entity.Users;
import com.statetransport.exception.DepotException;
import com.statetransport.exception.RolesException;
import com.statetransport.exception.UserException;
import com.statetransport.request.UserRequest;
import com.statetransport.service.DepotService;
import com.statetransport.service.RolesService;
import com.statetransport.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private DepotService depotService;
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public Users createNewUser(UserRequest userRequest) throws UserException, DepotException, RolesException {
		Users user=new Users();
		user.setDepot(depotService.getDepotById(userRequest.getDepot_id()));
		user.setRole(roleDao.getRoleById(userRequest.getRole_id()));
		user.setFirstName(userRequest.getFirstName());
		user.setMiddleName(userRequest.getMiddleName());
		user.setSurName(userRequest.getSurName());
		user.setStatus(true);
		return userDao.createUser(user);
	}

	@Override
	public List<Users> getAllUsers() throws UserException {
		return userDao.getAllUsers();
	}

	@Override
	public Users updateUser(UserRequest userRequest) throws UserException, DepotException, RolesException {
		Users user=userDao.getUserById(userRequest.getId());

		user.setDepot(depotService.getDepotById(userRequest.getDepot_id()));
		user.setRole(roleDao.getRoleById(userRequest.getRole_id()));
		user.setFirstName(userRequest.getFirstName());
		user.setMiddleName(userRequest.getMiddleName());
		user.setSurName(userRequest.getSurName());
		user.setStatus(true);
		return userDao.updateUser(user);
	}

	@Override
	public void deletUser(Long userId) throws UserException {
		userDao.getUserById(userId);
		userDao.deleteUserById(userId);
	}

	@Override
	public Users getUserById(Long userId) throws UserException {
		return userDao.getUserById(userId);
	}
}
