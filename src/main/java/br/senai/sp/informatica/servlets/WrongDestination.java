package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/WrongDestination")
public class WrongDestination extends HttpServlet {
  private Logger logger = Logger.getLogger("WrongDestination");
	
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userAgent = request.getHeader("User-Agent");
    
    logger.log(Level.SEVERE, "User-Agent: " + userAgent);

    if((userAgent != null) && userAgent.contains("OPR")) {
      response.sendRedirect("http://www.microsoft.com");
    } else {
      response.setContentType("text/html");
      response.sendRedirect("http://www.mozilla.org");
    }
  }
}
