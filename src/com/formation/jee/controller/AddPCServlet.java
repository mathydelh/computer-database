package com.formation.jee.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jee.domain.Company;
import com.formation.jee.domain.Computer;
import com.formation.jee.service.CompanyService;
import com.formation.jee.service.ComputerService;
import com.formation.jee.service.manager.ServiceManager;

/**
 * Classe Servlet en lien avec addComputer.jsp
 * Servlet implementation class AddPCServlet
 */
@WebServlet("/AddPCServlet")
public class AddPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //le numéro de version
    private CompanyService companyService;
    private ComputerService computerService;
    /**
     * Constructeur : initialisation des attributs
     * @see HttpServlet#HttpServlet()
     */
    public AddPCServlet() {
        super();
        // TODO Auto-generated constructor stub
        companyService = ServiceManager.INSTANCE.getCompanyService();
        computerService = ServiceManager.INSTANCE.getComputerService();
    }

	/**
	 * méthode Get avec, en paramètres la requête et la réponse
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		//Récupérer toutes les companies
		request.setAttribute("companies", companyService.getCompanies());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/addComputer.jsp"));
		rd.forward(request, response);
	}

	/**
	 * méthode Post avec, en paramètres la requête et la réponse
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupérer ce que l’utilisateur a entré dans chaques champs
		request.setAttribute("companies", companyService.getCompanies()); 
		String name = request.getParameter("name");
		
		String intro = request.getParameter("introducedDate");
		Date introduced=null;
		try {// Transforme la chaine de caractères récupérée en date
			introduced = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(intro);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String disc = request.getParameter("discontinuedDate");
		Date discontinued=null;
		try {// Transforme la chaine de caractères récupérée en date
			discontinued = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(disc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id_c = request.getParameter("company");// Récupère l'identifiant de l'entreprise
		long company_id = Long.parseLong(id_c);//Transforme la chaine de caractère en long
		
		Computer computer;
		
		// Si les valeurs récupérées ne sont pas nulles
		if((name.trim()!=""&&name!=null)&&(introduced!=null)&&(discontinued!=null)){
		if(company_id!=-1){ // Si l'utilisateur a choisi une entreprise lié à l'ordinateur
		Company company = new Company();
		company = companyService.getCompany(company_id);//On retrouve l'entreprise à partir de son identifiant
		
		// On crée l'ordinateur en utilisant le builder
		computer= new Computer.Builder().name(name).introduced(introduced).discontinued(discontinued).company_id(company).build();
		
		// On ajoute l'ordinateur à la base de données
		computerService.addComputers(computer);
		}
		else{// Si l'utilisateur à préféré ne pas sélectionner de companie
			// On crée l'ordinateur en utilisant le builder
			computer= new Computer.Builder().name(name).introduced(introduced).discontinued(discontinued).build();
			
			// On ajoute l'ordinateur à la base de données
			computerService.addComputers(computer);
		}
		}
		else{
			
		}
		
		response.sendRedirect("DatabaseServlet");// Retour à la page d’accueil
	}

}
