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

import com.formation.jee.dao.CompanyDao;
import com.formation.jee.dao.ComputerDao;
import com.formation.jee.dao.impl.CompanyDaoImpl;
import com.formation.jee.dao.impl.ComputerDaoImpl;

public enum DaoManager {

	INSTANCE;

	private CompanyDao companyDao;
	private ComputerDao computerDao;
	private EntityManagerFactory emf;
	
	private DaoManager() {
		emf = Persistence.createEntityManagerFactory("computer-databasePU"); // Qu'est ce que c'est epfPU?
		companyDao = new CompanyDaoImpl();
		computerDao = new ComputerDaoImpl();
	}

	public CompanyDao getCompanyDao() {
		return companyDao;
	}
	
	public ComputerDao getComputerDao() {
		return computerDao;
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
