package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;


public class EleveGommette {
    private int id;
    private Professeur professeur;
    private Gommette gommette;
    private Eleve eleve;
    private String motif;
    private String date;

    public EleveGommette(){}


    public EleveGommette(int id, Eleve eleve, Professeur professeur, Gommette gommette, String motif, String date){
        setId(id);
        setEleve(eleve);
        setGommette(gommette);
        setProfesseur(professeur);
        setMotif(motif);
        setDate(date);
    }

    public void setGommette(Gommette gommette){
        this.gommette = gommette;
    }

    public void setMotif(String motif){
        this.motif = motif;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    

    public Gommette getGommette(){
        return this.gommette;
    }

    public String getMotif(){
        return this.motif;
    }

    public String getDate(){
        return this.date;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public int getId() {
        return id;
    }
    

}
