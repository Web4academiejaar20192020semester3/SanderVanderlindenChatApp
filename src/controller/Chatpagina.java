package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Chatpagina extends RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		String destination = "chatpagina.jsp";

		HttpSession session = request.getSession();
		Person person = (Person)session.getAttribute("user");

		return destination;
	}

}
