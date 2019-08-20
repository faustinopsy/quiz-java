package br.senai.sp.informatica.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlets.libs.MessageImage;
import br.senai.sp.informatica.servlets.libs.WebUtilities;

@SuppressWarnings("serial")
@WebServlet("/ShadowedText")
public class ShadowedText extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String wantsList = request.getParameter("showList");
		
		if (wantsList != null) {
			showFontList(response);
		} else {
			String message = request.getParameter("message");
			
			if ((message == null) || (message.length() == 0)) {
				message = "Falta o parâmetro mensagem";
			}
			
			String fontName = request.getParameter("fontName");
			
			if ((fontName == null) || (fontName.length() == 0)) {
				fontName = "Serif";
			}
			
			String fontSizeString = request.getParameter("fontSize");
			
			int fontSize;
			
			try {
				fontSize = Integer.parseInt(fontSizeString);
			} catch (NumberFormatException nfe) {
				fontSize = 90;
			}
			
			response.setContentType("image/jpeg");
			response.setCharacterEncoding("UTF-8");

			MessageImage.writeJPEG(
					MessageImage.makeMessageImage(message, fontName, fontSize),
					response.getOutputStream());
		}
	}

	private void showFontList(HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		String header = WebUtilities.loadFile(this, "/resources/header.html").replaceFirst("TITULO", "Fonts");
		String footer = WebUtilities.loadFile(this, "/resources/footer.html");
		
		out.println(header);
		
		//tODO implementar a apresentação das Fontes na página
		
		String[] fontNames = MessageImage.getFontNames();
		for (int i = 0; i < fontNames.length; i++) {
			out.println("  <p>" + fontNames[i] + "</p>");
		}
		out.println(footer);
	}
}
