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
	private static final long serialVersionUID = 1L; //le num�ro de version
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
	 * m�thode Get avec, en param�tres la requ�te et la r�ponse
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		//R�cup�rer toutes les companies
		request.setAttribute("companies", companyService.getCompanies());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/addComputer.jsp"));
		rd.forward(request, response);
	}

	/**
	 * m�thode Post avec, en param�tres la requ�te et la r�ponse
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//R�cup�rer ce que l�utilisateur a entr� dans chaques champs
		request.setAttribute("companies", companyService.getCompanies()); 
		String name = request.getParameter("name");
		
		String intro = request.getParameter("introducedDate");
		Date introduced=null;
		try {// Transforme la chaine de caract�res r�cup�r�e en date
			introduced = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(intro);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String disc = request.getParameter("discontinuedDate");
		Date discontinued=null;
		try {// Transforme la chaine de caract�res r�cup�r�e en date
			discontinued = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(disc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id_c = request.getParameter("company");// R�cup�re l'identifiant de l'entreprise
		long company_id = Long.parseLong(id_c);//Transforme la chaine de caract�re en long
		
		Computer computer;
		
		// Si les valeurs r�cup�r�es ne sont pas nulles
		if((name.trim()!=""&&name!=null)&&(introduced!=null)&&(discontinued!=null)){
		if(company_id!=-1){ // Si l'utilisateur a choisi une entreprise li� � l'ordinateur
		Company company = new Company();
		company = companyService.getCompany(company_id);//On retrouve l'entreprise � partir de son identifiant
		
		// On cr�e l'ordinateur en utilisant le builder
		computer= new Computer.Builder().name(name).introduced(introduced).discontinued(discontinued).company_id(company).build();
		
		// On ajoute l'ordinateur � la base de donn�es
		computerService.addComputers(computer);
		}
		else{// Si l'utilisateur � pr�f�r� ne pas s�lectionner de companie
			// On cr�e l'ordinateur en utilisant le builder
			computer= new Computer.Builder().name(name).introduced(introduced).discontinued(discontinued).build();
			
			// On ajoute l'ordinateur � la base de donn�es
			computerService.addComputers(computer);
		}
		}
		else{
			
		}
		
		response.sendRedirect("DatabaseServlet");// Retour � la page d�accueil
	}

}
