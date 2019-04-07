package com.statetransport.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.statetransport.dao.UserDAO;
import com.statetransport.entity.Users;
import com.statetransport.exception.UserException;
import com.statetransport.exception.UserException.UserExceptionMessage;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory hibernateSessionFactory;

	@Override
	public Users createUser(Users user) throws UserException{
		hibernateSessionFactory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public List<Users> getAllUsers() throws UserException {
		Criteria criteria=hibernateSessionFactory.getCurrentSession().createCriteria(Users.class);
		criteria.add(Restrictions.eq("status", true));
		
		List<Users> usersList=criteria.list();
		
		if(usersList.isEmpty()) {
			throw new UserException(UserExceptionMessage.USERS_NOT_FOUND);
		}
		return usersList;
	}

	@Override
	public Users updateUser(Users user) throws UserException {
		hibernateSessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public Users getUserById(Long userId) throws UserException {
		String query="From Users where id="+userId;
		Users user=(Users) hibernateSessionFactory.getCurrentSession().createQuery(query).uniqueResult();
		if(user==null) {
			throw new UserException(UserExceptionMessage.USER_NOT_FOUND);
		}
		return user;
	}

	@Override
	public void deleteUserById(Long userId) throws UserException {
		String query="update Users set status=false where id="+userId;
		hibernateSessionFactory.getCurrentSession().createQuery(query).executeUpdate();
	}

}
