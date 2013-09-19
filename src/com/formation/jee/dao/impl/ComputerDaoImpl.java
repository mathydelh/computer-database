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
import javax.persistence.NamedQuery;

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

			String query = "SELECT c FROM Computer c";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByName() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();
			String query = "SELECT c FROM Computer c ORDER BY c.name ASC";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByIntroduced() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c ORDER BY c.introduced ASC";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByDiscontinued() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c ORDER BY c.discontinued ASC";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByCompany() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c ORDER BY c.company.name ASC";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedBySearch(String search) {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c WHERE c.name LIKE :search";
			computers = em.createQuery(query).setParameter("search","%"+search+"%").getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int getLength(){
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning length...");
		return computers.size();
	}
	
	@Override
	public void addComputers(Computer computer) {
		EntityManager em = null;
		em = DaoManager.INSTANCE.getEntityManager();
		
		em.getTransaction().begin();
	    em.persist(computer); //em.merge(u); for updates
	    em.getTransaction().commit();
	    em.close(); 
	}
}
