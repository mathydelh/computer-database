package com.formation.jee.service;

import java.util.List;

import com.formation.jee.domain.Computer;

public interface ComputerService {
 	public abstract List<Computer> getComputers();
 	public abstract List<Computer> getPaginatedComputers(int length, int start);
 	public abstract List<Computer> getComputersSortedByName();
 	public abstract List<Computer> getComputersSortedByIntroduced();
 	public abstract List<Computer> getComputersSortedByDiscontinued();
 	public abstract List<Computer> getComputersSortedByCompany();
 	public abstract List<Computer> getComputersSortedBySearch(String search);
 	public abstract Computer getComputerSortedById(long id);
 	public abstract int getLengthComputers();
 	public abstract void addComputers(Computer computer);
 	public abstract void updateComputers(Computer computer);
 	public abstract void clearComputers(long id);
}
