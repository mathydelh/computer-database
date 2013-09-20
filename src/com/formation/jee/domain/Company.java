package com.formation.jee.domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Le modèle de base de données de la table company est décrit ici
@Entity 
@Table(name = "company")
public class Company {
	@Id 
	@GeneratedValue
	private long id;//Identifiant, généré automatiquement par la BD
	
	@Column(name="name")
	private String name;//Nom de l'entreprise
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER) //Ordinateurs crées par l'entreprise
	public Computer getComputers(){
		return this.getComputers(); 
	}
	
	// Getters and setters
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
	
	//Builder d'une entreprise
	public static class Builder {
		private Company company;
		
		public Builder() {
			company = new Company();
		}
		
		public Builder id(long id) {
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

	//Tous les composants d'une entreprise décrits
	@Override
	public String toString() {
		return "Company [id_Company=" + id + ", name=" + name + "]";
	}
	
	
}
