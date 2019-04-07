package com.statetransport.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.statetransport.entity.Users;
import com.statetransport.exception.UserException;

@Repository
public interface UserDAO {
	
	public Users createUser(Users user) throws UserException;
	
	public List<Users> getAllUsers() throws UserException;
	
	public Users updateUser(Users user) throws UserException;
	
	public Users getUserById(Long userId) throws UserException;
	
	public void deleteUserById(Long userId) throws UserException;

}
