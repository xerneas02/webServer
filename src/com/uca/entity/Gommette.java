package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;


public class Gommette {
    private String couleur;
    private String description;
    private int id;

    //---- Appartient à eleveGommette mais est ici pour l'affichage ----//
    private String motif;
    private String date;
    private String lastNameProf;
    private int idEleveGommette;

    public Gommette(){}

    public Gommette(int id, String couleur, String description){
        setCouleur(couleur);
        setDescription(description);
        setId(id);
    }


    public Gommette(int id, int idEleveGommette, String couleur, String description, String motif, String date, String lastNameProf){
        setCouleur(couleur);
        setDescription(description);
        setId(id);
        setMotif(motif);
        setDate(date);
        setIdEleveGommette(idEleveGommette);
        setLastNameProf(lastNameProf);
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

    public void setIdEleveGommette(int idEleveGommette)
    {
        this.idEleveGommette = idEleveGommette;
    }

    public void setLastNameProf(String lastNameProf)
    {
        this.lastNameProf = lastNameProf;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public String getDescription(){
        return this.description;
    }

    public int getId() {
        return this.id;
    }

    public int getIdEleveGommette(){
        return this.idEleveGommette;
    }

    public String getMotif(){
        return this.motif;
    }

    public String getDate(){
        return this.date;
    }

    public String getLastNameProf(){
        return this.lastNameProf;
    }

}
