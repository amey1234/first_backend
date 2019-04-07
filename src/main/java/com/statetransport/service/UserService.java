package com.statetransport.service;

import java.util.List;

import com.statetransport.entity.Users;
import com.statetransport.exception.DepotException;
import com.statetransport.exception.RolesException;
import com.statetransport.exception.UserException;
import com.statetransport.request.UserRequest;

public interface UserService {

	public Users createNewUser(UserRequest userRequest) throws UserException, DepotException, RolesException;
	
	public List<Users> getAllUsers() throws UserException;
	
	public Users updateUser(UserRequest userRequest) throws UserException, DepotException, RolesException;
	
	public void deletUser(Long userId) throws UserException;
	
	public Users getUserById(Long userId) throws UserException;
}
