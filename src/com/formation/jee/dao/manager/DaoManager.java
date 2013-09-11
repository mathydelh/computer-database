package com.formation.jee.dao.manager;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import com.formation.jee.dao.UserDao;
import com.formation.jee.dao.impl.UserDaoImpl;

public enum DaoManager {

	INSTANCE;

	private UserDao userDao;
	private EntityManagerFactory emf;
	
	private DaoManager() {
		emf = Persistence.createEntityManagerFactory("epfPU"); // Qu'est ce que c'est epfPU?
		userDao = new UserDaoImpl();
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
