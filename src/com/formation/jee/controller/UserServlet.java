package com.formation.jee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jee.domain.Company;
import com.formation.jee.service.UserService;
import com.formation.jee.service.impl.UserServiceImpl;
import com.formation.jee.service.manager.ServiceManager;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        userService = ServiceManager.INSTANCE.getUserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Envoyer un objet dans la requete (ici la liste d'utilisateurs)
//		request.setAttribute("users", userService.getUsers());
//		
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/display.jsp"));
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String password = request.getParameter("password");
//		String login = request.getParameter("login");
//		//if(password!=null&&!password.isEmpty()&&login!=null)
//		User user= new User.Builder().login(login).password(password).build();
//		userService.addUsers(user);
//		doGet(request, response);
//		//users.add
	}

}
