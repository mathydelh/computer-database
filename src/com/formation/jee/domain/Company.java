package com.formation.jee.domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity 
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "findAllCompanies", query = "SELECT c FROM Company c"),
    @NamedQuery(name="findCompanybyId", query="SELECT c FROM Company c WHERE c.id = :id"),
})
public class Company {
	@Id 
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER) // Tres tres incertain...
	public Computer getComputers(){
		return this.getComputers(); //Peutetre ZARBI
	}
	
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
	
	public static class Builder {
		private Company company;
		
		public Builder() {
			company = new Company();
		}
		
		public Builder id(int id) {
			company.setId(id);
			return this;
		}
		
		public Builder name(String name) {
			company.setName(name);
			return this;
		}
		
		public Company build() {
			return company;
		}
	}

	@Override
	public String toString() {
		return "Company [id_Company=" + id + ", name=" + name + "]";
	}
	
	
}
