package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlets.libs.WebUtilities;

@WebServlet("/RegistrationForm")
@SuppressWarnings("serial")
public class RegistrationForm extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

	String header = WebUtilities.loadFile(this, "/resources/header.html").replace("TITULO", "Formulário de Registro");
	String footer = WebUtilities.loadFile(this, "/resources/footer.html");
    
    PrintWriter out = response.getWriter();
    
    String actionURL = "RegistrationServlet";
    
    String nome = WebUtilities.getCookieValue(request, "nome", "");
    String sobrenome = WebUtilities.getCookieValue(request, "sobrenome", "");
    String email = WebUtilities.getCookieValue(request, "email","");   
    
    out.println(header +
       			"<form id='form1' action='" + actionURL + "' method='post'><fieldset>" +
       				"<div>" +
       					"<label for='nome'>Nome</label>" +
       					"<input id='nome' type='text' name='nome' placeholder='" + nome + "' " +
       							"required aria-required='true'>" +
       				"</div>" +
       				"<div>" +
       					"<label for='sobrenome'>Sobrenome</label>" +
       					"<input id='sobrenome' type='text' name='sobrenome' placeholder='" + sobrenome + "' " +
       							"required aria-required='true'>" +
       				"</div>" +
       				"<div>" +
       					"<label for='email'>E-mail</label>" +
       					"<input id='email' type='text' name='email' placeholder='" + email + "' " +
       							"required aria-required='true'>" +
       				"</div>" +
       				"<div>" +
       					"<input type='submit' id='submit' value='Registrar'>" +
       				"</div>" +
       			"</fieldset></form>" +
       			footer);
  }
}
