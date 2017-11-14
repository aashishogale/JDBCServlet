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

public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
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
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
			rDispatcher.forward(request, response);

		} else {
			printWriter.println("Plz enter correct information");
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/register.html");
			rDispatcher.include(request, response);

		}
		int id = userdata.selectid(name);

		printWriter.println("your name" + name + " is registered at id" + id);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
