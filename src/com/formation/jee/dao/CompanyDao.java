package com.formation.jee.dao;

import java.util.List;

import com.formation.jee.domain.Company;

public interface CompanyDao {
	//Ces fonctions sont implémentées dans le dossier com.formation.jee.dao.impl
	public List<Company> getCompanies();
	public Company getCompany(long id);
}