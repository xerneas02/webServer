package com.uca.core;

import com.uca.dao.UserDAO;
import com.uca.entity.Eleve;

import java.util.ArrayList;

public class UserCore {
    public static ArrayList<Eleve> getAllEleves() {
        return new UserDAO().getAllEleves();
    }

}
