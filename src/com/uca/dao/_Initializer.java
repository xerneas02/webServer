package com.uca.dao;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Set;

import com.uca.entity.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table
            /*
            statement = connection.prepareStatement("DROP TABLE eleveGommette ;");
            statement.executeUpdate();

            statement = connection.prepareStatement("DROP TABLE eleve ;");
            statement.executeUpdate();

            statement = connection.prepareStatement("DROP TABLE gommette ;");
            statement.executeUpdate();

            statement = connection.prepareStatement("DROP TABLE professeur ;");
            statement.executeUpdate();*/

            //Eleve
            

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleve (id int primary key auto_increment, firstname varchar(100), lastname varchar(100));");
            statement.executeUpdate();

            //Gommette
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS gommette (id int primary key auto_increment, couleur varchar(100), description varchar(100));");
            statement.executeUpdate();

            //Professeur
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeur (id int primary key auto_increment, firstname varchar(100), lastname varchar(100), mdp varchar(100));");
            statement.executeUpdate();

            //EleveGommette
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleveGommette (id int auto_increment,"+
                                                                                            "idEleve int,"+
                                                                                            "idProf int,"+
                                                                                            "idGommette int,"+
                                                                                            "PRIMARY KEY (id),"+
                                                                                            "FOREIGN KEY (idEleve) REFERENCES eleve (id),"+
                                                                                            "FOREIGN KEY (idProf) REFERENCES professeur (id),"+
                                                                                            "FOREIGN KEY (idGommette) REFERENCES gommette (id),"+
                                                                                            "motif varchar(100),"+
                                                                                            "date date);");
            statement.executeUpdate();

            //Todo Remove me !
<<<<<<< HEAD
            /*statement = connection.prepareStatement("INSERT INTO professeur(firstname, lastname, mdp) VALUES(?, ?, ?);");
            statement.setString(1, "Thomas");
            statement.setString(2, "Dupois");
=======
            /*Professeur prof = new Professeur(1, "Professeur", "Random", "Mdp");
            prof.addEleve("Thomas", "Dupois");*/
            //*
            statement = connection.prepareStatement("INSERT INTO professeur(firstname, lastname, mdp) VALUES(?, ?, ?);");
            statement.setString(1, "Mamadou");
            statement.setString(2, "Kante");
>>>>>>> da267f68aeecd013287ec684980a39ac79a82127
            statement.setString(3, "1234");
            statement.executeUpdate();
            //*/

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
