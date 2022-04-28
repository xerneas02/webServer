package com.uca;

import com.uca.core.UserCore;
import com.uca.dao._Initializer;
import com.uca.gui.*;

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
            if(id != null){
                char[] idArray = id.toCharArray();
                String numbers = "0123456789";
                for  (int i = 0; i < idArray.length ;i++) {
                   if(!numbers.contains(idArray[i] + "")){
                       idArray[i] = ' ';
                   }
                }
                id = new String(idArray);
                id = id.replaceAll(" ", "");
                System.out.println(id);
                UserCore.deleteEleve(id);
            }
            else{
                String firstName = req.queryParams("firstname");
                String lastname = req.queryParams("lastname");
                UserCore.addEleve(firstName, lastname);
            }
            res.redirect("/eleves");
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
            System.out.println(req.session());
            if(req.session().attribute("name")== null)
            {
                res.redirect("/login");
            }else{
                res.redirect("/eleves");
            }
            return null;
        });
        /*
        get("/login", (req, res) ->{
            return ;
        });*/
    }
}