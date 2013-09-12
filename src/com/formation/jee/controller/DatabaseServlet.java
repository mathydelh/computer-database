package com.formation.jee.controller;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jee.dao.manager.DaoManager;
import com.formation.jee.domain.Company;
import com.formation.jee.domain.Computer;
import com.formation.jee.service.CompanyService;
import com.formation.jee.service.ComputerService;
import com.formation.jee.service.manager.ServiceManager;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CompanyService companyService;
    private ComputerService computerService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServlet() {
        super();
        companyService = ServiceManager.INSTANCE.getCompanyService();
        computerService = ServiceManager.INSTANCE.getComputerService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("kikou");
		//Envoyer un objet dans la requete (ici la liste d'utilisateurs)
		request.setAttribute("computers", computerService.getComputers());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/dashboard.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("companies", companyService.getCompanies());
		System.out.println("coucocu");
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
		long company_id = Long.parseLong(id_c);
		
		Company company = new Company();
		company = companyService.getCompany(company_id);
		//if(password!=null&&!password.isEmpty()&&login!=null)
		Computer computer= new Computer.Builder().name(name).introduced(introduced).discontinued(discontinued).company_id(company).build();
		System.out.println("hey"+computer.getName());
		computerService.addComputers(computer);
		doGet(request, response);
		//users.add
	}

}
