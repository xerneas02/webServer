package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;


public class Core {
    public static ArrayList<Eleve> getAllEleves() {
        return new DAO().getAllEleves();
    }

    public static ArrayList<Gommette> getAllEleveGommettes(Eleve eleve) {
        return new DAO().getAllEleveGommettes(eleve);
    }

    public static ArrayList<Gommette> getAllGommettes() {
        return new DAO().getAllGommettes();
    }

    public static ArrayList<Professeur> getAllProfesseurs() {
        return new DAO().getAllProfesseurs();
    }

    public static int checkLogin(String lastname, String firstname, String password) {
        Professeur test = new DAO().getProfesseur(lastname, firstname);
        if(test != null && test.getMdp().equals(password)){
            return test.getId();
        }
        return -1;
    }

    public static void addEleveGommette(String idEleve, String idProf, String idGommette, String motif) {
        new DAO().addEleveGommette(idEleve, idProf, idGommette, motif);
    }

    public static void addGommette(String couleur, String description){
        new DAO().addGommette(couleur, description);
    }

    public static void deleteGommette(String id){
        new DAO().deleteGommette(id);
    }

    public static void deleteEleveGommette(String id){
        new DAO().deleteEleveGommette(id);
    }

    public static void deleteEleve(String id){
        new DAO().delete(id);
    }

    public static void updateEleve(String id, String firstName, String lastName){
        new DAO().update(id, firstName, lastName);
    }

    public static Eleve getEleve(String id){
        return new DAO().getEleve(id);
    }

    public static void addEleve(String firstName, String lastName){
        new DAO().create(firstName, lastName);
    }

}
