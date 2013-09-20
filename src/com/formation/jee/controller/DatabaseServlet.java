package com.formation.jee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jee.service.ComputerService;
import com.formation.jee.service.manager.ServiceManager;

/**
 * Classe Servlet relié à dashboard.jsp
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //le numéro de version
    private ComputerService computerService;
    /**
     * Constructeur : initialisation des attributs
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServlet() {
        super();
        computerService = ServiceManager.INSTANCE.getComputerService();
    }

	/**
	 * méthode Get avec, en paramètres la requête et la réponse
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1; // Par défaut, nous sommes sur la page 1 de la liste d'ordinateurs
        int recordsPerPage = 30; //Il y a 30 ordinateurs par page
		
        if(request.getParameter("page") != null) //Si le numéro de la page est inscrit
            page = Integer.parseInt(request.getParameter("page")); // On récupère le numéro
		
		String search_input = request.getParameter("search");//On récupère la valeur dans le champs de recherche
		
		//Si le champs de recherche n'est pas vide, afficher les ordinateurs correspondants à la recherche
		if(search_input!=null&&!(search_input.trim().isEmpty())){
			request.setAttribute("computers", computerService.getComputersSortedBySearch(search_input));
		}
		//Sinon si le champs de recherche est vide, on affiche la liste complète des ordinateurs
		else{
		String sort = request.getParameter("sort");//Savoir si l'utilisateur souhaite trier la liste
		
		if(sort==null){ //si il n'y a pas de demande de tri, afficher tous les ordinateurs
			int debutpagination=30*(page-1);
			request.setAttribute("computers", computerService.getPaginatedComputers(recordsPerPage, debutpagination));
		}
		else if(sort.equals("name")){// On trie par nom
			request.setAttribute("computers", computerService.getComputersSortedByName());
		}
		else if(sort.equals("introduced")){// On trie par date de lancement
			request.setAttribute("computers", computerService.getComputersSortedByIntroduced());
		}
		else if(sort.equals("discontinued")){// On trie par date d'interruption
			request.setAttribute("computers", computerService.getComputersSortedByDiscontinued());
		}
		else if(sort.equals("company")){// On trie par nom d'entreprise
			request.setAttribute("computers", computerService.getComputersSortedByCompany());
		}
		}
		int n_PC=new Integer(computerService.getLengthComputers());// On affiche le nombre d'ordinateurs inscrit dans la BD
		request.setAttribute("number_PC", n_PC );
		
		// On affiche les pages de pagination
		long noOfPages = (long) Math.ceil(n_PC * 1.0 / recordsPerPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("noOfPages", noOfPages);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/dashboard.jsp"));
		rd.forward(request, response);
	}

	/**
	 * méthode Post avec, en paramètres la requête et la réponse
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
