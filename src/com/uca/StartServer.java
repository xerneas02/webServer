package com.uca;

import com.uca.core.UserCore;
import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.entity.*;
import java.util.ArrayList;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);


        _Initializer.Init();

        //Defining our routes
        
        post("/login", (req, res) -> {
            String name = req.queryParams("name");
            String password = req.queryParams("password");
            if (UserCore.checkLogin(name, password))
            {
                req.session(true);
                req.session().attribute("name", name);
                res.redirect("/");
            }
            else{
                res.redirect("/login");
            }
            return null;
        });


        post("/eleves", (req, res) -> {
            String id = req.queryParams("delet");
            String gommette = req.queryParams("gommettes");
            String add = req.queryParams("add");
            if(id != null){
                id = removeSpaces(id);
                UserCore.deleteEleve(id);
            }
            else if(gommette != null){
                res.redirect("/eleveGommette/"+gommette);
            }
            else if(add != null){
                String firstName = req.queryParams("firstname");
                String lastName = req.queryParams("lastname");
                if(firstName != null && lastName != null)
                {
                    UserCore.addEleve(firstName, lastName);
                }
            }
            else{
                res.redirect("/elevesModif");
            }
            res.redirect("/eleves");
            return null;
        });


        post("/elevesModif", (req, res) -> {
            String id = req.queryParams("modif");
            if(id != null){
                System.out.println(id);
                String firstName = req.queryParams("firstname-"+id);
                String lastName = req.queryParams("lastname-"+id);     
                id = removeSpaces(id);
                if(firstName != null && lastName != null)
                {
                    UserCore.updateEleve(id, firstName, lastName);
                }
            } else{
                res.redirect("/eleves");
            }
            res.redirect("/elevesModif");
            return null;
        });

        get("/login", (req, res) -> {
            return ConexionGui.login();
        });

        get("/eleves", (req, res) -> {
            if(req.session().attribute("name")== null)
            {
                res.redirect("/login");
                return null;
            }else{
                return UserGUI.getAllEleves();
            }
        });

        get("/profs", (req, res) -> {
            return ProfGUI.getAllProfesseurs();
        });

        get("/", (req, res) -> {
            if(req.session().attribute("name")== null)
            {
                res.redirect("/login");
            }else{
                res.redirect("/eleves");
            }
            return null;
        });

        get("/elevesModif", (req, res) -> {
            if(req.session().attribute("name")== null)
            {
                res.redirect("/login");
                return null;
            }else{
                return ModifyUserGUI.getAllEleves();
            }
        });

        ArrayList<Eleve> eleves = UserCore.getAllEleves();
        for(Eleve eleve : eleves){
            get("/eleveGommette/" + eleve.getFirstName() + "-" + eleve.getLastName(), (req, res) -> {
                System.out.println("/eleveGommette/" + eleve.getFirstName() + "-" + eleve.getLastName());
                if(req.session().attribute("name")== null)
                {
                    res.redirect("/login");
                    return null;
                }else{
                    return GommetteGUI.getAllEleveGommettes(eleve);
                }
            });
        }

    }

    private static String removeSpaces(String str){
        char[] strArray = str.toCharArray();
        String numbers = "0123456789";
        for  (int i = 0; i < strArray.length ;i++) {
            if(!numbers.contains(strArray[i] + "")){
                strArray[i] = ' ';
            }
        }
        str = new String(strArray);
        str = str.replaceAll(" ", "");
        return str;
    }
}