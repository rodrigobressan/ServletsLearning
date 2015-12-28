package br.com.bresan.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		
		// of course we would like to check our DB or something like this
		String validUser = "bresan";
		String validPassword = "senha123";
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		if (user.equals(validUser) && password.equals(validPassword)) {
			writer.print("Usuário válido");
			
			Cookie cookie = new Cookie("usuario.logado", user);
			cookie.setMaxAge(10 * 60);
			resp.addCookie(cookie);
		} else {
			writer.print("Usuário inválido");
		}
		writer.println("</body></html>");
	}
	
}
