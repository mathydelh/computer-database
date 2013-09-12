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

import com.formation.jee.dao.ComputerDao;
import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Computer;

public class ComputerDaoImpl implements ComputerDao {
	
	public ComputerDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputers() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			computers = em.createNamedQuery("findAllComputers").getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	public void addComputers(Computer computer) {
		EntityManager em = null;
		em = DaoManager.INSTANCE.getEntityManager();
		
		em.getTransaction().begin();
	    em.persist(computer); //em.merge(u); for updates
	    em.getTransaction().commit();
	    em.close(); 
	}
}
