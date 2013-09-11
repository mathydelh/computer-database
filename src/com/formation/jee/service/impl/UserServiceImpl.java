package com.formation.jee.service.impl;

import java.util.List;

import com.formation.jee.dao.UserDao;
import com.formation.jee.dao.impl.UserDaoImpl;
import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Company;
import com.formation.jee.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	public UserServiceImpl() {
		userDao = DaoManager.INSTANCE.getUserDao();
	}
	/* (non-Javadoc)
	 * @see com.formation.jee.service.impl.UserService#getUsers()
	 */
//	@Override
//	public List<Company> getUsers() {
//		return userDao.getUsers();
//	}
//	
//	@Override
//	public void addUsers(Company user) {
//		userDao.addUsers(user);
//	}
}
