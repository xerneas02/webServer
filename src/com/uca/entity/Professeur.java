package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;

public class Professeur{
    private String mdp;
    private String firstName;
    private String lastName;
    private int id;

    public Professeur(){}

    public Professeur(int id, String firstName, String lastName, String mdp){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setMdp(mdp);
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
