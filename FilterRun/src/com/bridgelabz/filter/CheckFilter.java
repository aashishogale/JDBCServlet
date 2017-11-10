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
import javax.servlet.annotation.WebFilter;

import com.bridgelabz.dao.EmpData1;

/**
 * Servlet Filter implementation class CheckFilter
 */

public class CheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		EmpData1 empdata=new EmpData1();
		
		response.setContentType("text/html");
			String name=request.getParameter("Name");
			String passw=request.getParameter("psw");
			PrintWriter pWriter=response.getWriter();
			
		
			if(empdata.selectid(name,passw))
			{
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
			else{
			
				pWriter.println("<h1>error pls enter correct message</h1>");
			
				
			}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
