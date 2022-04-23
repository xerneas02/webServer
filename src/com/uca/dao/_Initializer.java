package com.uca.dao;

import java.sql.*;

import com.uca.entity.Eleve;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table

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
                                                                                            "PRIMARY KEY (idEleve, idProf, idGommette),"+
                                                                                            "FOREIGN KEY (idEleve) REFERENCES eleve (id),"+
                                                                                            "FOREIGN KEY (idProf) REFERENCES professeur (id),"+
                                                                                            "FOREIGN KEY (idGommette) REFERENCES gommette (id),"+
                                                                                            "motif varchar(100),"+
                                                                                            "date date);");
            statement.executeUpdate();



            statement = connection.prepareStatement("SELECT MAX(id) maxId FROM eleve;");
            ResultSet result = statement.executeQuery();
            if (result.next()){
                int idMax = result.getInt("maxId");
                Eleve thomas = new Eleve(idMax+1, "Thomas", "Dupois");
                thomas.add();
            }
            else{
                Eleve thomas = new Eleve(0, "Thomas", "Dupois");
                thomas.add();
            }
            //Todo Remove me !
            /*
            statement = connection.prepareStatement("INSERT INTO users(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, "Theodore");
            statement.setString(2, "Muillerez");
            statement.executeUpdate();
            */

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
