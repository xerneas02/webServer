package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;


public class EleveGommetteCore {
    public static ArrayList<EleveGommette> getAllEleveGommettes(Eleve eleve) {
        return new EleveGommetteDAO().getAllEleveGommettes(eleve);
    }

    public static void addEleveGommette(String idEleve, String idProf, String idGommette, String motif, String date) {
        new EleveGommetteDAO().create(idEleve, idProf, idGommette, motif, date);
    }

    public static void deleteEleveGommette(String id){
        new EleveGommetteDAO().delete(id);
    }

    public static void updateEleveGommette(String id, String motif, String date){
        new EleveGommetteDAO().update(id, motif, date);
    }
}
