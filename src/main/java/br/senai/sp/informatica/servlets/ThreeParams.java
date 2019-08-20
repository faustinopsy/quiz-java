package br.senai.sp.informatica.servlets;

import br.senai.sp.informatica.servlets.libs.WebUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
@WebServlet("/ThreeParams")
public class ThreeParams  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {

    	String header = WebUtilities.loadFile(this, "/resources/header.html")
                .replaceFirst("TITULO", "Argumentos");
        String footer = WebUtilities.loadFile(this, "/resources/footer.html");

        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        out.println(header +
                " <p><b>Argumento 1</b>: " + req.getParameter("param1") + "</p>" +
                " <p><b>Argumento 2</b>: " + req.getParameter("param2") + "</p>" +
                " <p><b>Argumento 3</b>: " + req.getParameter("param3") + "</p>" +
                footer
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        doGet(req, resp);
    }
}
