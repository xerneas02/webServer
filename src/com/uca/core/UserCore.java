package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;

public class UserCore {
    public static ArrayList<Eleve> getAllEleves() {
        return new UserDAO().getAllEleves();
    }

    public static boolean checkLogin(String name, String password) {
        Professeur test = new UserDAO().getProfesseur(name);
        return test != null && test.getMdp().equals(password);
    }

}
