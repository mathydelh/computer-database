package com.formation.jee.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Le modèle de base de données de la table computer est décrit ici
@Entity 
@Table(name = "computer")
public class Computer {
	@Id 
	@GeneratedValue
	private long id; //Identifiant, généré automatiquement par la BD
	
	@Column(name="name")
	private String name; //Nom de l'ordinateur
	
	@Column(name="introduced")
	@Temporal(TemporalType.TIMESTAMP)
	private Date introduced; // Date de lancement
	
	@Column(name="discontinued")
	@Temporal(TemporalType.TIMESTAMP)
	private Date discontinued; //Date d'interruption
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company; //Entreprise créatrice de l'ordinateur
	
	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getIntroduced() {
		return introduced;
	}
	
	public String getIntroducedAsString() {
		if(introduced==null)
			return "";
		SimpleDateFormat leformat= new SimpleDateFormat("yyyy-MM-dd");
		String intro = (String) leformat.format(introduced); 
		return intro;
	}

	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}

	public Date getDiscontinued() {
		return discontinued;
	}
	
	public String getDiscontinuedAsString() {
		if(discontinued==null)
			return "";
		SimpleDateFormat leformat= new SimpleDateFormat("yyyy-MM-dd");
		String disc = (String) leformat.format(discontinued); 
		return disc;
	}

	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	// Builder d'un ordinateur
	public static class Builder {
		public Computer getComputer() {
			return computer;
		}

		public void setComputer(Computer computer) {
			this.computer = computer;
		}

		private Computer computer;
		
		public Builder() {
			computer = new Computer();
		}
		
		public Builder id(long id) {
			computer.setId(id);
			return this;
		}
		
		public Builder name(String name) {
			computer.setName(name);
			return this;
		}
		
		public Builder introduced(Date introduced) {
			computer.setIntroduced(introduced);
			return this;
		}
		
		public Builder discontinued(Date discontinued) {
			computer.setDiscontinued(discontinued);
			return this;
		}
		
		public Builder company_id(Company company) {
			computer.setCompany(company);
			return this;
		}
		
		public Computer build() {
			return computer;
		}
	}

	//Tous les composants d'un ordinateur décrit
	@Override
	public String toString() {
		return "Computer [id_Computer=" + id + ", name=" + name + ", introduced="+introduced+", discontinued="+discontinued+", company_id=+company.getId()+]";
	}	
}

