package com.uca.gui;

import com.uca.core.*;
import com.uca.entity.Eleve;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


public class GommetteGUI {
    
    public static String getAllGommettes(boolean connexion) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("gommettes", GommetteCore.getAllGommettes());
        input.put("connexion", connexion ? 1 : 0);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettes/gommettes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }


    public static String getAllEleveGommettes(Eleve eleve, boolean connexion) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        input.put("gommettesEleve", EleveGommetteCore.getAllEleveGommettes(eleve));
        input.put("gommettes", GommetteCore.getAllGommettes());
        input.put("firstname", eleve.getFirstName());
        input.put("lastname", eleve.getLastName());
        input.put("connexion", connexion ? 1 : 0);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/eleveGommette.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        return output.toString();
    }
}
