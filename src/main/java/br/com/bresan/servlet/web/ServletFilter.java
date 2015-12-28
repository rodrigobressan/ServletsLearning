package br.com.bresan.servlet.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.Cookies;

@WebFilter(urlPatterns = "/*")
public class ServletFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String requestURI = req.getRequestURI();
		
		String usuario = getUsuario(req);
		
		System.out.println("Página acessada: " + requestURI + " pelo usuário " + usuario);
		
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		String usuario = "<deslogado>";
		
		if (cookies == null) {
			return usuario;
		}
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				usuario = cookie.getValue();
			}
		}
		return usuario;
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
