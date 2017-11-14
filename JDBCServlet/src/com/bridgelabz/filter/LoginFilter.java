package com.bridgelabz.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.UserDao;

/**
 * Servlet Filter implementation class LoginFilter
 */

public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		UserDao userdata = new UserDao();

		response.setContentType("text/html");
		

		String email = request.getParameter("email");

		// PrintWriter pWriter = response.getWriter();
		System.out.println(userdata.selectid(email));
		if (userdata.selectid(email) != 0) {
			chain.doFilter(request, response);
			// pass the request along the filter chain

		} else {
			RequestDispatcher rdDispatcher = request.getRequestDispatcher("error.jsp");
			rdDispatcher.forward(request, response);

		

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
