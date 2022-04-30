package com.uca.gui;

import com.uca.core.UserCore;
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
    
    public static String getAllEleveGommettes(Eleve eleve) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("gommettes", UserCore.getAllEleveGommettes(eleve));
        input.put("firstname", eleve.getFirstName());
        input.put("lastname", eleve.getLastName());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("users/userGommette.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
