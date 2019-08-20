package br.senai.sp.informatica.servlets.libs;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebUtilities {
    public static String loadFile(HttpServlet ref, String url) throws IOException {
        BufferedReader fin = new BufferedReader(
                new InputStreamReader(ref.getServletContext().getResourceAsStream(url)));
        StringBuilder buff = new StringBuilder();
        for (String linha = fin.readLine(); linha != null; linha = fin.readLine()) {
            buff.append(linha);
        }
        return buff.toString();
    }

    public static String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    return (cookie.getValue());
                }
            }
        }
        return (defaultValue);
    }
}
