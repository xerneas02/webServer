package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;


public class Gommette {
    private String couleur;
    private String description;
    private String motif;
    private String date;
    private int id;

    public Gommette(){}

    public Gommette(int id, String couleur, String description, String motif, String date){
        setCouleur(couleur);
        setDescription(description);
        setId(id);
        setMotif(motif);
        setDate(date);
    }

    public void setCouleur(String couleur){
        this.couleur = couleur;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMotif(String motif){
        this.motif = motif;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public String getDescription(){
        return this.description;
    }

    public int getId() {
        return id;
    }

    public String getMotif(){
        return motif;
    }

    public String getDate(){
        return date;
    }

    public void add(){
        /*
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
        }*/
    }

}
