package br.com.bresan.servlet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Task {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		String receivedUser = req.getParameter("user");
		String receivedPassword = req.getParameter("password");
		
		// here we must check if the received credentials are valid or not
		// of course we would like something like a DAO to access a DB and fetch
		// the valid credentials, but as purpose of learning we are going to do this way :P
		String validUser = "bresan";
		String validPassword = "senha123";
		
		// valid credentials
		if (validUser.equals(receivedUser) && validPassword.equals(receivedPassword)) {
			
			// create a new user with the valid credentials
			User currentUser = new User();
			currentUser.email = receivedUser;
			
			// create the new session with the created user
			HttpSession session = req.getSession();
			session.setAttribute(Constants.SESSION_TAG, currentUser);

			return "/WEB-INF/paginas/valid_credentials.jsp";
		} else {
			
			// invalid credentials
			return "/WEB-INF/paginas/invalid_credentials.jsp";
		}
	}
	
}
