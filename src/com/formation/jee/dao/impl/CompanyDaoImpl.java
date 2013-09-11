package com.formation.jee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.formation.jee.dao.CompanyDao;
import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Company;

public class CompanyDaoImpl implements CompanyDao {
	
	public CompanyDaoImpl() {
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<User> getUsers() {
//		EntityManager em = null;
//
//		List<User> users = null;
//
//		try {
//			em = DaoManager.INSTANCE.getEntityManager();
//
//			users = em.createNamedQuery("findAllUsers").getResultList();
//		} finally {
//			em.close();
//		}
//
//		System.out.println("Returning result...");
//		return users;
//	}
	
//	public void addUsers(User user) {
//		EntityManager em = null;
//		em = DaoManager.INSTANCE.getEntityManager();
//		
//		em.getTransaction().begin();
//	    em.persist(user); //em.merge(u); for updates
//	    em.getTransaction().commit();
//	    em.close(); 
//	}
}
