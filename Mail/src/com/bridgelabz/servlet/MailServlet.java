package com.bridgelabz.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class MailServlet
 */

public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	    protected void processRequest(HttpServletRequest request, 
	                                  HttpServletResponse response)
	                   throws IOException, ServletException {
	        final String err = "/error.jsp";
	        final String succ = "/success.jsp";
	        String from = request.getParameter("emailFrom");
	        String to = request.getParameter("emailTo");
	      
	        String message = request.getParameter("frommessage");
	        String login = request.getParameter("emailFrom");
	        String password = request.getParameter("password");

	        try {
	            Properties props = new Properties();
	            props.setProperty("mail.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.auth", "true");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            Authenticator auth = new SMTPAuthenticator(login, password);
	            Session session = Session.getInstance(props, auth);
	            MimeMessage msg = new MimeMessage(session);
	            msg.setText(message);
	         
	            msg.setFrom(new InternetAddress(from));
	            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            Transport.send(msg);
	        } 
	            catch (AuthenticationFailedException ex) {
	            request.setAttribute("ErrorMessage", "Authentication failed");
	            System.out.print("auth");
	            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
	            dispatcher.forward(request, response);
	        } 
	            catch (AddressException ex) {
	            request.setAttribute("ErrorMessage", "Wrong email address");
	      
	            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
	            dispatcher.forward(request, response);
	        } 
	            catch (MessagingException ex) {
	            request.setAttribute("ErrorMessage", ex.getMessage());
	        
	            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
	            dispatcher.forward(request, response);
	        }
	            RequestDispatcher dispatcher = request.getRequestDispatcher(succ);
	            dispatcher.forward(request, response);
	    }
	    private class SMTPAuthenticator extends Authenticator {
	        private PasswordAuthentication authentication;
	        public SMTPAuthenticator(String login, String password) {
	            authentication = new PasswordAuthentication(login, password);
	        }
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return authentication;
	        }
	    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		processRequest(request,response);
	   }


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	}

