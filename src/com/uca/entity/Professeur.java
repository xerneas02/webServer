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

    public void add(){
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO " + table + "(id, firstname, lastname, mdp) VALUES(?, ?, ?, ?);");
            statement.setInt(1, this.id);
            statement.setString(2, this.firstName);
            statement.setString(3, this.lastName);
            statement.setString(4, this.mdp);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not insert " + table + " !");
        }
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public void addEleve(String firstname, String lastname){
        statement = connection.prepareStatement("SELECT MAX(id) maxId FROM eleve;");
        ResultSet result = statement.executeQuery();
        if (result.next()){
            int idMax = result.getInt("maxId");
            Eleve eleve = new Eleve(idMax+1, firstname, lastname);
            eleve.add();
        }
        else{
            Eleve eleve = new Eleve(0, firstname, lastname);
            eleve.add();
        }
    }
}
