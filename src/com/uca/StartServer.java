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
            String firstname = req.queryParams("firstname");
            String lastname  = req.queryParams("lastname");
            String password  = req.queryParams("password");
            int id = UserCore.checkLogin(lastname, firstname, password);
            System.out.println(id);
            if (id > -1)
            {
                req.session(true);
                req.session().attribute("firstname", firstname);
                req.session().attribute("lastname" , lastname );
                req.session().attribute("id"       , id       );
                res.redirect("/");
            }
            else{
                res.redirect("/login");
            }
            return null;
        });


        post("/eleves", (req, res) -> {
            String id = req.queryParams("delete");
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
                if(firstName != "" && lastName != "")
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
            if(req.session().attribute("lastname")== null)
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
            if(req.session().attribute("lastname")== null)
            {
                res.redirect("/login");
            }else{
                res.redirect("/eleves");
            }
            return null;
        });

        get("/elevesModif", (req, res) -> {
            if(req.session().attribute("lastname")== null)
            {
                res.redirect("/login");
                return null;
            }else{
                return ModifyUserGUI.getAllEleves();
            }
        });

        ArrayList<Eleve> eleves = UserCore.getAllEleves();
        for(Eleve eleve : eleves){
            String page = "/eleveGommette/" + eleve.getFirstName() + "-" + eleve.getLastName();
            get(page, (req, res) -> {
                if(req.session().attribute("lastname") == null)
                {
                    res.redirect("/login");
                    return null;
                }else{
                    return GommetteGUI.getAllEleveGommettes(eleve);
                }
            });

            post(page, (req, res) -> {
                String add = req.queryParams("add");
                String idGommette  = req.queryParams("delete");
                System.out.println(add);
                if(add != null){
                    String couleur     = req.queryParams("couleur");
                    String description = req.queryParams("description");
                    String motif       = req.queryParams("motif");
                    System.out.println(couleur + " " + description + " " + motif);
                    if(couleur != "" && description != "" && motif != "")
                    {
                        int id = req.session().attribute("id");
                        System.out.println(id);
                        UserCore.addGommette(eleve, couleur, description, motif, id);
                    }
                }
                else if(idGommette != null){
                    UserCore.deleteGommette(idGommette);
                }
                else{
                    res.redirect("/eleves");
                }
                res.redirect(page);
                return null;
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