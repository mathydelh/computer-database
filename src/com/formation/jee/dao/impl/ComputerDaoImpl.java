package com.formation.jee.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.formation.jee.dao.ComputerDao;
import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Computer;

public class ComputerDaoImpl implements ComputerDao {
	
	public ComputerDaoImpl() {
	}

	//Cette fonction renvoie la liste des ordinateurs de la base de données, triés par identifiants
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputers() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c";//Récupérer tous les ordinateurs de la base
			computers = em.createQuery(query).getResultList(); 
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	//Cette fonction renvoie une partie des ordinateurs de la base de données
	//Length: le nombre d'ordinateurs renvoyés
	//Start: le premier ordinateur renvoyé, les suivants étant ceux qui le suivent dans la liste trié par identifiants
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getPaginatedComputers(int length, int start) {
		EntityManager em = null;

		List<Computer> paginatedcomputers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();
			
			String query = "SELECT c FROM Computer c";// Récupère tous les ordinateurs
			paginatedcomputers = em.createQuery(query).setFirstResult(start).setMaxResults(length).getResultList();
			//Prends dans cette liste la partie que l'on souhaite renvoyer
		} finally {
			em.close();
		}
		return paginatedcomputers;
	}
	
	//Cette fonction renvoie tous les ordinateurs de la base de données, triés par nom
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByName() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();
			String query = "SELECT c FROM Computer c ORDER BY c.name ASC";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	//Cette fonction renvoie tous les ordinateurs de la base de données, triés par date d'introduction
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByIntroduced() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c ORDER BY c.introduced ASC";
			computers = em.createQuery(query).getResultList();
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	//Cette fonction renvoie tous les ordinateurs de la base de données, triés par date d'interruption
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByDiscontinued() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c ORDER BY c.discontinued ASC";
			computers = em.createQuery(query).getResultList();
			//System.out.println(computers.size()+" "+computers.get(0)+computers.get(1)+computers.get(2));
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	//Cette fonction renvoie tous les ordinateurs de la base de données, triés par marque
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedByCompany() {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c ORDER BY c.company.name ASC";
			computers = em.createQuery(query).getResultList();
		} finally {
			em.close();
		}

		System.out.println("Returning result...");
		return computers;
	}
	
	//Cette fonction renvoie tous les ordinateurs dont une partie du nom correspond à une recherche de l'utilisateur.
	//search: la recherche de l'utilisateur
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersSortedBySearch(String search) {
		EntityManager em = null;

		List<Computer> computers = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c WHERE c.name LIKE :search";//Quand la recherche est comprise dans le nom
			computers = em.createQuery(query).setParameter("search","%"+search+"%").getResultList();
		} finally {
			em.close();
		}
		return computers;
	}
	
	// Cette fonction permet de récupérer un ordinateur via son identifiant
	// id: l'identifiant recherché
	@Override
	public Computer getComputerSortedById(long id) {
		EntityManager em = null;

		Computer computer = null;
		//
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c WHERE c.id=:id";// Quand l'identifiant correspond à l'entier rentré.
			computer = (Computer) em.createQuery(query).setParameter("id", id).getSingleResult();
		} finally {
			em.close();
		}
		return computer;
	}
	
	//Cette fonction permet de renvoyer le nombre d'ordinateurs inscrits dans la base de donnée
	@SuppressWarnings("unchecked")
	@Override
	public int getLength(){
		EntityManager em = null;
		List<Computer> computers = null;
		try {
			em = DaoManager.INSTANCE.getEntityManager();

			String query = "SELECT c FROM Computer c";
			computers = em.createQuery(query).getResultList();
		} finally {
			em.close();
		}
		return computers.size();// Retourne la taille de la liste des ordinateurs
	}
	
	//Cette fonction permet d'ajouter un ordinateur à la base de données
	@Override
	public void addComputers(Computer computer) {
		EntityManager em = null;
		em = DaoManager.INSTANCE.getEntityManager();
		
		em.getTransaction().begin();
	    em.persist(computer); //ajoute l'ordinateur à la base de données
	    em.getTransaction().commit();
	    em.close(); 
	}
	
	//Cette fonction permet de modifier un ordinateur inscrit dans la base de données
	@Override
	public void updateComputers(Computer computer) {
		EntityManager em = null;
		em = DaoManager.INSTANCE.getEntityManager();
		
		em.getTransaction().begin();
	    em.merge(computer); //Modifie les données de l'ordinateur
	    em.getTransaction().commit();
	    em.close();
	}
	
	//Cette fonction permet de supprimer un ordinateur de la base de données
	@Override
	public void clearComputers(long id) {
		EntityManager em = null;
		em=DaoManager.INSTANCE.getEntityManager();
		try{
		    em.getTransaction().begin();
		    Computer computer = em.find(Computer.class, id);
		    em.remove(computer); //Supprime l'ordinateur
		    em.getTransaction().commit();
		} finally {
		    em.close();
		}
	}
}
