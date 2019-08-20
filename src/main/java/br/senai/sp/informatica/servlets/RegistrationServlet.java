package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlets.libs.LongLivedCookie;
import br.senai.sp.informatica.servlets.libs.WebUtilities;

@WebServlet("/RegistrationServlet")
@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		boolean isMissingValue = false;
		
		String nome = request.getParameter("nome");
		if (isMissing(nome)) {
			nome = "Falta o primeiro nome";
			isMissingValue = true;
		}
		
		String sobrenome = request.getParameter("sobrenome");
		if (isMissing(sobrenome)) {
			sobrenome = "Falta o sobrenome";
			isMissingValue = true;
		}
		
		String email = request.getParameter("email");
		if (isMissing(email)) {
			email = "Falta o e-mail";
			isMissingValue = true;
		}

		Cookie c1 = new LongLivedCookie("nome", nome);
		response.addCookie(c1);
		Cookie c2 = new LongLivedCookie("sobrenome", sobrenome);
		response.addCookie(c2);
		Cookie c3 = new LongLivedCookie("email", email);
		response.addCookie(c3);

		String formAddress = "RegistrationForm";
		if (isMissingValue) {
			response.sendRedirect(formAddress);
		} else {
			String header = WebUtilities.loadFile(this, "/resources/header.html").replace("TITULO", "Formulário de Registro");
			String footer = WebUtilities.loadFile(this, "/resources/footer.html");

			PrintWriter out = response.getWriter();

			out.println(header +
				    "<h2>Obrigado por efetuar seu registro</h2>" + 
					"<p><b>Nome</b>: " + nome + "</p>" +
					"<p><b>Sobrenome</b>: " + sobrenome + "</p>" +
					"<p><b>E-mail</b>: " + email + "</p>" +
					footer);
		}
	}

	private boolean isMissing(String param) {
		return ((param == null) || (param.trim().equals("")));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
