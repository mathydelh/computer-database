package com.formation.jee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jee.service.CompanyService;
import com.formation.jee.service.ComputerService;
import com.formation.jee.service.manager.ServiceManager;

/**
 * Servlet implementation class AddPCServlet
 */
@WebServlet("/AddPCServlet")
public class AddPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CompanyService companyService;
    private ComputerService computerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPCServlet() {
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
		System.out.println("PCServletget");
		//Envoyer un objet dans la requete (ici la liste d'utilisateurs)
		request.setAttribute("companies", companyService.getCompanies());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/addComputer.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
