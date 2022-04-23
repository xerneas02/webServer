package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;

public class Eleve extends Entity {
    public Eleve(){
        super();
    }

    public Eleve(int id, String firstName, String lastName){
        super(id, firstName, lastName);
    }
}