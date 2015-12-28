package br.com.bresan.servlet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
	String process(HttpServletRequest req, HttpServletResponse resp);
}
