package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;

public class UserCore {
    public static ArrayList<Eleve> getAllEleves() {
        return new UserDAO().getAllEleves();
    }

    public static ArrayList<Gommette> getAllEleveGommettes(Eleve eleve) {
        return new UserDAO().getAllEleveGommettes(eleve);
    }

    public static ArrayList<Professeur> getAllProfesseurs() {
        return new UserDAO().getAllProfesseurs();
    }

    public static boolean checkLogin(String name, String password) {
        Professeur test = new UserDAO().getProfesseur(name);
        return test != null && test.getMdp().equals(password);
    }

    public static void deleteEleve(String id){
        new UserDAO().delete(id);
    }

    public static void addEleve(String firstName, String lastName){
        new UserDAO().create(firstName, lastName);
    }

    public static void updateEleve(String id, String firstName, String lastName){
        new UserDAO().update(id, firstName, lastName);
    }

}
