package com.formation.jee.service.impl;

import java.util.List;

import com.formation.jee.dao.ComputerDao;
import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Computer;
import com.formation.jee.service.ComputerService;

public class ComputerServiceImpl implements ComputerService {

	ComputerDao computerDao;
	
	public ComputerServiceImpl() {
		computerDao = DaoManager.INSTANCE.getComputerDao();
	}
	/* (non-Javadoc)
	 * Appel des méthodes décrites
	 * @see com.formation.jee.service.impl.ComputerService#getComputers()
	 */
	@Override
	public List<Computer> getComputers() {
		return computerDao.getComputers();
	}
	
	@Override
	public List<Computer> getPaginatedComputers(int length, int start){
		return computerDao.getPaginatedComputers(length, start);
	}
	
	@Override
	public List<Computer> getComputersSortedByName() {
		return computerDao.getComputersSortedByName();
	}
	
	@Override
	public List<Computer> getComputersSortedByIntroduced() {
		return computerDao.getComputersSortedByIntroduced();
	}
	
	@Override
	public List<Computer> getComputersSortedByDiscontinued() {
		return computerDao.getComputersSortedByDiscontinued();
	}
	
	@Override
	public List<Computer> getComputersSortedByCompany() {
		return computerDao.getComputersSortedByCompany();
	}
	
	@Override
	public List<Computer> getComputersSortedBySearch(String search) {
		return computerDao.getComputersSortedBySearch(search);
	}
	
	@Override
	public Computer getComputerSortedById(long id){
		return computerDao.getComputerSortedById(id);
	}
	
	@Override
	public int getLengthComputers(){
		return computerDao.getLength();
	}
	
	@Override
	public void addComputers(Computer computer) {
		computerDao.addComputers(computer);
	}
	
	@Override
	public void updateComputers(Computer computer){
		computerDao.updateComputers(computer);
	}
	
	@Override
	public void clearComputers(long id){
		computerDao.clearComputers(id);
	}
}