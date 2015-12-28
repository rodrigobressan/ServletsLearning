package br.com.bresan.servlet.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/places")
public class PlaceSearch implements Tarefa {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		String message = req.getParameter("message");
		
		Place place = new Place();
		place.name = message;
		
		req.setAttribute("message", place);
		
		return "WEB-INF/paginas/search.jsp";
	}

}
