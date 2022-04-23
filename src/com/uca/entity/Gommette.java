package com.uca.entity;

import com.uca.type.Couleur;
import java.sql.*;
import com.uca.dao.*;


public class Gommette {
    private Couleur couleur;
    private String description;
    private int id;

    public Gommette(){}

    public Gommette(Couleur couleur, String description, int id){
        setCouleur(couleur);
        setDescription(description);
        setId(id);
    }

    public void setCouleur(Couleur couleur){
        this.couleur = couleur;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Couleur getCouleur(){
        return this.couleur;
    }

    public String getDescription(){
        return this.description;
    }

    public int getId() {
        return id;
    }

    public void add(){
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO gommette(id, couleur, description) VALUES(?, ?, ?);");
            statement.setInt(1, this.id);
            statement.setString(2, this.couleur == Couleur.BLANC ? "Blanc" : "Rouge");
            statement.setString(3, this.description);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not insert gommette !");
        }
    }

}
