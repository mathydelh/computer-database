package com.formation.jee.dao;

import java.util.List;

import com.formation.jee.domain.Company;

public interface CompanyDao {
	public List<Company> getCompanies();
	public Company getCompany(long id);
//	public void addUsers(User user);
}