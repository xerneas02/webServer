package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;

public class Professeur extends Entity{
    private String mdp;
    public Professeur(){
        super();
        this.table = "professeur";
    }

    public Professeur(int id, String firstName, String lastName, String mdp){
        super(id, firstName, lastName);
        this.table = "professeur";
        setMdp(mdp);
    }


    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }
}
