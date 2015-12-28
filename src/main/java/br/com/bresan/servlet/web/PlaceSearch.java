package br.com.bresan.servlet.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaceSearch implements Task {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		String message = req.getParameter("message");
		
		Place place = new Place();
		place.name = message;
		
		req.setAttribute("message", place);
		
		return "WEB-INF/paginas/search.jsp";
	}

}
