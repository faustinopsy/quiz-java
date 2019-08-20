package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.informatica.servlets.libs.Mensagem;
import br.senai.sp.informatica.servlets.libs.Template;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

@SuppressWarnings("serial")
@WebServlet("/RedirecionaObj")
public class RedirecionaObj extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		response.setCharacterEncoding("UTF-8");

		Date agora = new Date();
	
		Object param = request.getParameter("data");

		if (param != null) {
			// Salva a referência do objeto na sessão
			Calendar data = Calendar.getInstance();
			data.set(1999, Calendar.NOVEMBER, 20);
			Calendar data2 = Calendar.getInstance();
			data2.set(2002, Calendar.DECEMBER, 15);
			
			ses.setAttribute("objeto", agora);
			ses.setAttribute("objeto2", data.getTime());
			ses.setAttribute("objeto3", data2.getTime());

			// Desvia a requisição Web para outra página (Servlet/Jsp)
			RequestDispatcher rd = request.getRequestDispatcher("ListaObjeto.jsp");
			rd.forward(request, response);
		} else {
			// Cria objeto para armazenar informações
			// que serão utilizadas na montagem da
			// página de resposta ao usuário
			Mensagem msg = new Mensagem();
			msg.setTitulo("Não encontrei parâmetro válido!");
			msg.setTexto("Não foi informado o parâmetro necessário: data");
			msg.setUrl("bean.html");

			ServletContext ctx = request.getServletContext();

			TemplateEngine engine = Template.getEngine(ctx);

			Logger log = Logger.getLogger("RedirecionaObj");

			if(engine != null) {
				log.info("Com Thymeleaf");

				WebContext webContext = new WebContext(request, response, ctx,
						new Locale("pt","BR"));
				webContext.setVariable("msg", msg);

				engine.process("ResultThymeleaf", webContext, response.getWriter());
			} else {
				log.info("Com TagLib");

				// Salva o objeto na sessão
				request.getSession().setAttribute("msg", msg);

				// Solicita ao navegador Web o redirecionamento
				// para outra página no servidor de aplicação
				response.sendRedirect("ResultTagLib.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}