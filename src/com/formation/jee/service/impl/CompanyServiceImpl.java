package com.formation.jee.service.impl;

import java.util.List;

import com.formation.jee.dao.CompanyDao;
import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Company;
import com.formation.jee.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

	CompanyDao companyDao;
	
	public CompanyServiceImpl() {
		companyDao = DaoManager.INSTANCE.getCompanyDao();
	}
	
	/* (non-Javadoc)
	 * Appel des m�thodes d�crites dans le DAO 
	 * @see com.formation.jee.service.impl.UserService#getUsers()
	 */
	@Override
	public List<Company> getCompanies() {
		return companyDao.getCompanies();
	}
	
	@Override
	public Company getCompany(long id) {
		return companyDao.getCompany(id);
	}
}
