package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;


public class ProfesseurCore {
    public static ArrayList<Professeur> getAllProfesseurs() {
        return new ProfesseurDAO().getAllProfesseurs();
    }

    public static int checkLogin(String lastname, String firstname, String password) {
        Professeur test = new ProfesseurDAO().get(lastname, firstname);
        if(test != null && test.getMdp().equals(password)){
            return test.getId();
        }
        return -1;
    }

    public static Professeur getProfesseur(String id){
        return new ProfesseurDAO().get(id);
    }
}
