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
 * Servlet implementation class EditPCServlet
 */
@WebServlet("/EditPCServlet")
public class EditPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyService companyService;
    private ComputerService computerService;
    /**
     * Classe EditPC relié à editComputer.jsp
     * @see HttpServlet#HttpServlet()
     */
    public EditPCServlet() {
        super();
        // TODO Auto-generated constructor stub
        companyService = ServiceManager.INSTANCE.getCompanyService();
        computerService = ServiceManager.INSTANCE.getComputerService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String theid="";
		theid = request.getParameter("id");// On récupère l'identifiant de l'ordinateur a modifier
		long id= 0;
		id= Long.parseLong(theid);// on transforme la chaine de caractère en entier
		request.setAttribute("computer", computerService.getComputerSortedById(id));// Liste des ordinateurs
		request.setAttribute("companies", companyService.getCompanies());// Liste des companies
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/editComputer.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String edited_id= null;
		String isCleared= null;
		String isUpdated= null;
		
		edited_id = request.getParameter("insertID");// Récupérer l'identifiant en paramètre caché dans la jsp
		long edit_id= 0;
		edit_id= Long.parseLong(edited_id);
		
		// Que souhaite faire l'utilisateur:
		isCleared =request.getParameter("isClear");// Supprimer?
		isUpdated =request.getParameter("isUpdate");// Modifier?
		
		if(isUpdated!=null){// Si l'on veut modifier		
			request.setAttribute("companies", companyService.getCompanies()); 
			
			// On récupère les nouvelles caractéristiques
			String name = request.getParameter("name");
			
			String intro = request.getParameter("introducedDate");
			Date introduced=null;
			try {
				introduced = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(intro);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String disc = request.getParameter("discontinuedDate");
			Date discontinued=null;
			try {
				discontinued = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(disc);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String id_c = request.getParameter("company");
			long company_id = Long.parseLong(id_c.trim());
			
			Company company = new Company();
			company = companyService.getCompany(company_id);
			
			Computer computer= new Computer.Builder().name(name).introduced(introduced).discontinued(discontinued).company_id(company).build();
			computer.setId(edit_id);
			
			computerService.updateComputers(computer); // On modifie les valeurs de l'ordinateur
		}
		else if(isCleared!=null){// Si l'on veut supprimer
			computerService.clearComputers(edit_id); // On supprime l'ordinateur
		}
		
		response.sendRedirect("DatabaseServlet");// Retour à la page d'accueil
	}
}
