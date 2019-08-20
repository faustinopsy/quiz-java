package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlets.libs.LongLivedCookie;
import br.senai.sp.informatica.servlets.libs.WebUtilities;

@WebServlet("/ClientAccessCounts")
@SuppressWarnings("serial")
public class ClientAccessCounts extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String countString = WebUtilities.getCookieValue(request, "accessCount", "1");
		
		int count = 1;
		try {
			count = Integer.parseInt(countString);
		} catch (NumberFormatException nfe) {
		}
		
		LongLivedCookie c = new LongLivedCookie("accessCount",String.valueOf(count + 1));
		response.addCookie(c);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String header = WebUtilities.loadFile(this, "/resources/header.html").replace("TITULO", "Contador de Acessos");
		String footer = WebUtilities.loadFile(this, "/resources/footer.html");

		PrintWriter out = response.getWriter();

		out.println(header + "<h2>Você acessou " + count + " vezes esta Página.</h3>" + footer);
	}
}
