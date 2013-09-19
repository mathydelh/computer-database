package com.formation.jee.dao;

import java.util.List;

import com.formation.jee.domain.Computer;

public interface ComputerDao {
	public List<Computer> getComputers();
	public List<Computer> getComputersSortedByName();
	public List<Computer> getComputersSortedByIntroduced();
	public List<Computer> getComputersSortedByCompany();
	public List<Computer> getComputersSortedByDiscontinued();
	public List<Computer> getComputersSortedBySearch(String search);
	public void addComputers(Computer computer);
	public int getLength();
}
