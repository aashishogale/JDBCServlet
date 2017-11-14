package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserDao userdata = new UserDao();
		HttpSession session = request.getSession(false);
		String email=(String)session.getAttribute("email");
		String password=(String)session.getAttribute("password");
		response.setContentType("text/html");
		if (userdata.returnmail(email, password)) {
			PrintWriter printWriter=response.getWriter();
			response.sendRedirect("https://www.google.co.in/");
		
			//RequestDispatcher rDispatcher1 = request.getRequestDispatcher("/success.jsp");
			//rDispatcher1.forward(request, response);

		

		} 
		else {

			
			RequestDispatcher rDispatcher1 = request.getRequestDispatcher("/error.jsp");
			rDispatcher1.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}