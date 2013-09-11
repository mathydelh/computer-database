package com.formation.jee.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity 
@Table(name = "computer")
@NamedQuery(name = "findAllComputers", query = "Select cr From Computer cr")
public class Computer {
	@Id 
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="introduced")
	private Timestamp introduced;
	
	@Column(name="discontinued")
	private Timestamp discontinued;
	
	@Column(name="company_id")
	private int company_id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getIntroduced() {
		return introduced;
	}

	public void setIntroduced(Timestamp introduced) {
		this.introduced = introduced;
	}

	public Timestamp getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Timestamp discontinued) {
		this.discontinued = discontinued;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public static class Builder {
		private Computer computer;
		
		public Builder() {
			computer = new Computer();
		}
		
		public Builder id(int id) {
			computer.setId(id);
			return this;
		}
		
		public Builder name(String name) {
			computer.setName(name);
			return this;
		}
		
		public Builder introduced(Timestamp introduced) {
			computer.setIntroduced(introduced);
			return this;
		}
		
		public Builder discontinued(Timestamp discontinued) {
			computer.setDiscontinued(discontinued);
			return this;
		}
		
		public Builder company_id(int company_id) {
			computer.setCompany_id(company_id);
			return this;
		}
		
		public Computer build() {
			return computer;
		}
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introduced="+introduced+", discontinued="+discontinued+", company_id="+company_id+"]";
	}	
}

