package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.User;

/**
 * Servlet implementation class register
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String mobile = request.getParameter("mobile");
		String location = request.getParameter("location");
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setLocation(location);

		UserDao userdata = new UserDao(user);
		int i = userdata.insertStatement();
		PrintWriter printWriter = response.getWriter();
		if (i == 1) {
			response.sendRedirect("login");

		} else {
			printWriter.println("Plz enter correct information");
			response.sendRedirect("password");

		}
		

		
	}

	

}
