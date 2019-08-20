package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlets.libs.WebUtilities;

@WebServlet("/RepeatVisitor")
@SuppressWarnings("serial")
public class RepeatVisitor extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean newbie = true;
		Cookie[ ] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if ((c.getName().equals("repeatVisitor")) && (c.getValue().equals("yes"))) {
					newbie = false;
					break;
				}
			}
		}
		
		String title;
		if (newbie) {
			Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
			returnVisitorCookie.setMaxAge(60 * 60 * 24 * 365); // 1 ano
			
			response.addCookie(returnVisitorCookie);
			title = "Bem Vindo a bordo";
		} else {
			title = "Obrigado por retornar";
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String header = WebUtilities.loadFile(this, "/resources/header.html").replace("TITULO", "Visitar um Site");
		String footer = WebUtilities.loadFile(this, "/resources/footer.html");
		
		PrintWriter out = response.getWriter();
		
		out.println(header + "<h2>" + title + "</h2>" + footer);
	}
}
