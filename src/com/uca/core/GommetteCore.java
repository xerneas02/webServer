package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;


public class GommetteCore {
    public static ArrayList<Gommette> getAllGommettes() {
        return new GommetteDAO().getAllGommettes();
    }

    public static Gommette getGommette(String id){
        return new GommetteDAO().get(id);
    }

    public static void updateGommette(String id, String couleur, String description){
        new GommetteDAO().update(id, couleur, description);
    }

    public static void addGommette(String couleur, String description){
        new GommetteDAO().create(couleur, description);
    }

    public static void deleteGommette(String id){
        new GommetteDAO().delete(id);
    }
}
