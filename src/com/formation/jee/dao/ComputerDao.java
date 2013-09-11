package com.formation.jee.dao;

import java.util.List;

import com.formation.jee.domain.Computer;

public interface ComputerDao {
	public List<Computer> getComputers();
	public void addComputers(Computer computer);
}
