package com.uca.gui;

import com.uca.core.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class EleveGUI {
    
    public static String getAllEleves(boolean connexion) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("eleves", EleveCore.getAllEleves());
        input.put("connexion", connexion ? 1 : 0);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("eleves/eleves.ftl");

        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
