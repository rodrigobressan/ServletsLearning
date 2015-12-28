package br.com.bresan.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

	/*
	 * This method is used to receive any kind of request (POST, GET, UPDATE, DELETE etc) from the client.
	 * 
	 * We will receive here which task we want to be executed, and then choose the correct class to do it.
	 * */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// get the task from the request
			String task = req.getParameter("task");

			// check if its not null, otherwise we throw an IllegalArgumentException
			if (task == null) {
				throw new IllegalArgumentException("Invalid task!");
			}
			
			// our class name e.g.: br.com.bresan.servlet.web.PlaceSearch
			String className = "br.com.bresan.servlet.web." + task;
			
			// create a new instance of this class
			Class tarefaClass = Class.forName(className);
			Task tarefa = (Task) tarefaClass.newInstance();
			
			// and then get the next page we should load (the method .process(Request, Response) returns it to us)
			String nextPage = tarefa.process(req, resp);
			
			// and forward the page to the next address
			req.getRequestDispatcher(nextPage).forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
