package com.bridgelabz.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;





public class ListenerForServlet implements ServletContextListener {

    /**
     * Default constructor. 
     */



private ServletContext sContext;
    public ListenerForServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
String name="this is aashish servlet";
    	sContext=arg0.getServletContext();
    	sContext.setAttribute("name", name);
         // TODO Auto-generated method stub
    }
	
}
