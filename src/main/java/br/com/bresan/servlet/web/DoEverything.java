package br.com.bresan.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/doEverything")
public class DoEverything extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String task = req.getParameter("task");

			if (task == null) {
				throw new IllegalArgumentException("Invalid task!");
			}
			String className = "br.com.bresan.servlet.web." + task;
			Class tarefaClass = Class.forName(className);
			Tarefa tarefa = (Tarefa) tarefaClass.newInstance();
			
			String nextPage = tarefa.process(req, resp);
			
			req.getRequestDispatcher(nextPage).forward(req, resp);
		} catch (Exception e) {

		}
	}
}
