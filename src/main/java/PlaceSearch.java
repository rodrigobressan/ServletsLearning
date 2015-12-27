import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/places")
public class PlaceSearch extends HttpServlet {
	
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String message = req.getParameter("message");
		
		writer.println("<html><body>");
		writer.println("Message received: " + message);
		writer.println("</body></html>");
		
	}*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String message = req.getParameter("message");
		
		writer.println("<html><body>");
		writer.println("Message received: " + message);
		writer.println("</body></html>");
		
	}

}
