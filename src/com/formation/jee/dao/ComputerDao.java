package com.formation.jee.dao;

import java.util.List;

import com.formation.jee.domain.Computer;

public interface ComputerDao {
	//Ces fonctions sont implémentées dans le dossier com.formation.jee.dao.impl
	public List<Computer> getComputers();
	public List<Computer> getPaginatedComputers(int length, int start);
	public List<Computer> getComputersSortedByName();
	public List<Computer> getComputersSortedByIntroduced();
	public List<Computer> getComputersSortedByCompany();
	public List<Computer> getComputersSortedByDiscontinued();
	public List<Computer> getComputersSortedBySearch(String search);
	public Computer getComputerSortedById(long id);
	public void addComputers(Computer computer);
	public void updateComputers(Computer computer);
	public void clearComputers(long id);
	public int getLength();
}
