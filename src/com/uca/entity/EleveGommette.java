package com.uca.entity;

import java.util.Date;
import java.sql.*;
import com.uca.dao.*;

public class EleveGommette {
    private int id;
    private int idGommette;
    private int idEleve;
    private int idProf;
    private String motif;
    private Date date;

    public EleveGommette(){}

    public EleveGommette(int id, int idEleve, int idProf, int idGommette, String motif, Date date){
        setId(id);
        setIdEleve(idEleve);
        setIdGommette(idGommette);
        setIdProf(idProf); 
        setMotif(motif);
        setDate(date);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public void setIdGommette(int idGommette) {
        this.idGommette = idGommette;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getIdEleve() {
        return idEleve;
    }
    public int getIdGommette() {
        return idGommette;
    }
    
    public int getIdProf() {
        return idProf;
    }
    
    public String getmotif() {
        return motif;
    }

    public Date getDate() {
        return date;
    }

    public void add(){
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO eleveGommette (id, idEleve, idProf, idGommette, motif, date) VALUES(?, ?, ?);");
            statement.setInt(1, this.id);
            statement.setInt(2, this.idEleve);
            statement.setInt(3, this.idProf);
            statement.setInt(4, this.idGommette);
            statement.setString(5, this.motif);
            statement.setString(6, this.date.toString());
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not insert eleveGommette !");
        }
    }
}
