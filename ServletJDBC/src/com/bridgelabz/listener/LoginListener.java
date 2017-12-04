package com.bridgelabz.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	ServletContext sContext = null;
	private static int count=0;
	public static int getActiveSessions() {
		return count;
	}
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	count++;
    	System.out.println("session created");
         // TODO Auto-generated method stubcount++;
		sContext = se.getSession().getServletContext();
		sContext.setAttribute("count", new Integer(count));
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
