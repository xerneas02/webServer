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

    public void addEleve(String firstname, String lastname){
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO eleve(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not insert eleve !");
        }
    }
}
