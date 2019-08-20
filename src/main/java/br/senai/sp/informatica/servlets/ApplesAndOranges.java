package br.senai.sp.informatica.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/ApplesAndOranges.xls")
public class ApplesAndOranges extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("application/vnd.ms-excel");
    response.setCharacterEncoding("UTF-8");

    PrintWriter out = response.getWriter();
    
    out.println("\tQ1\tQ2\tQ3\tQ4\tTotal");
    out.println("Apples\t78\t87\t92\t29\t=SOMA(B2:E2)");
    out.println("Oranges\t77\t86\t93\t30\t=SOMA(B3:E3)");
  }
}
