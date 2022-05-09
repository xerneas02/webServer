package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;


public class EleveCore {
    public static ArrayList<Eleve> getAllEleves() {
        return new EleveDAO().getAllEleves();
    }

    public static void deleteEleve(String id){
        new EleveDAO().delete(id);
    }

    public static void updateEleve(String id, String firstName, String lastName){
        new EleveDAO().update(id, firstName, lastName);
    }

    public static Eleve getEleve(String id){
        return new EleveDAO().get(id);
    }

    public static void addEleve(String firstName, String lastName){
        new EleveDAO().create(firstName, lastName);
    }

}
