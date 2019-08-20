package br.senai.sp.informatica.servlets.libs;

import javax.servlet.ServletContext;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class Template {
    private static TemplateEngine engine;

    private Template() {}

    public static TemplateEngine getEngine(ServletContext context) {
        if(engine == null) {
            ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);
            resolver.setTemplateMode(TemplateMode.XML);
            resolver.setSuffix(".xhtml");
            resolver.setCharacterEncoding("UTF-8");
            resolver.setCacheable(false);

            engine = new TemplateEngine();
            engine.setTemplateResolver(resolver);
        }
        return engine;
    }
}
