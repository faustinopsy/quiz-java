package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlets.libs.WebUtilities;

@WebServlet("/ValidaDados")
public class ValidaDados extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");

		String header = WebUtilities.loadFile(this, "/resources/header.html");
		String footer = WebUtilities.loadFile(this, "/resources/footer.html");

		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");

		if (nome.isEmpty() || idade.isEmpty()) {
			header = header.replaceFirst("TITULO", "Erro");
			out.print(header + "<p>Alguns dados n&atilde;o foram informados</p>" + footer);
		} else {
			header = header.replaceFirst("TITULO", "Dados Digitados");
			out.print(header + "<p><b>Nome</b>: " + nome + "</p>\n" + "<p><b>Idade</b>: " + idade + "</p>\n" + footer);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}