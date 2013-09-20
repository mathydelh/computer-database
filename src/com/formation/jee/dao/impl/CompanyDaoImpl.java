package com.formation.jee.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.formation.jee.dao.CompanyDao;
import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Company;

public class CompanyDaoImpl implements CompanyDao {
	
	public CompanyDaoImpl() {
	}

	//Cette fonction renvoie la liste des entreprises de la base de donn�es, tri�s par identifiants
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getCompanies() {
		EntityManager em = null;

		List<Company> companies = null;

		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Company c";//R�cup�rer tous les entreprises compris dans la base de donn�es
			companies = em.createQuery(query).getResultList(); 
		} finally {
			em.close();
		}
		return companies;
	}
	
	//Cette fonction renvoie une entreprise en fonction de son identifiant
	//id: l'identifiant recherch�
	@Override
	public Company getCompany(long id) {
		EntityManager em = null;

		Company company = new Company();
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query="SELECT c FROM Company c WHERE c.id = :id";//Chercher l'ordinateur selon son identifiant
			company = (Company) em.createQuery(query).setParameter("id", id).getSingleResult();
		} finally {
			em.close();
		}
		return company;
	}
}
