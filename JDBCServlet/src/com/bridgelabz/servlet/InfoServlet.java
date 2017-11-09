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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubfinal 
		UserData udata=new UserData();
		
		String err = "/error.jsp";
        final String succ = "/success.jsp";

        String to = request.getParameter("altemail");
      
   HttpSession session1=request.getSession(false);
   String email=(String) session1.getAttribute("email");
   String password1=udata.selectpassword(email);
       
        String password = request.getParameter("psw");
        String login="aashishogale9@gmail.com";

        try {
            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            Authenticator auth = new SMTPAuthenticator(login, password);
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(password1);
         
            msg.setFrom(new InternetAddress(login));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            Transport.send(msg);
        } 
            catch (AuthenticationFailedException ex) {
            request.setAttribute("ErrorMessage", "Authentication failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);
            System.out.print("auth");
        } 
            catch (AddressException ex) {
            request.setAttribute("ErrorMessage", "Wrong email address");
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);
            System.out.print("wrong email");
            
        } 
            catch (MessagingException ex) {
            request.setAttribute("ErrorMessage", ex.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            System.out.print("msg exception");
            dispatcher.forward(request, response);
        }
            RequestDispatcher dispatcher = request.getRequestDispatcher(succ);
            dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
