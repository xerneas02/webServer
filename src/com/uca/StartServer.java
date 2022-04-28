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

        get("/login", (req, res) -> {
            return ConexionGui.login();
        });

        get("/users", (req, res) -> {
            return UserGUI.getAllEleves();
        });

        get("/", (req, res) -> {
            return UserGUI.getAllEleves();
        });
        /*
        get("/login", (req, res) ->{
            return ;
        });*/
    }
}