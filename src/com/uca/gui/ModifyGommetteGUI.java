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


public class ModifyGommetteGUI {
    public static String getAllGommettes() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("gommettes", GommetteCore.getAllGommettes());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("gommettes/gommettesModif.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
