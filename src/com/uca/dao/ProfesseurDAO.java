package com.uca.dao;

import com.uca.entity.*;
import com.uca.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class ProfesseurDAO {

    public Connection connect = _Connector.getInstance();
    
    
    public ArrayList<Professeur> getAllProfesseurs() {
        ArrayList<Professeur> entities = new ArrayList<>();
        try {
            
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM professeur ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id  = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String mdp = resultSet.getString("mdp");
                Professeur Prof = new Professeur(id, firstName, lastName, mdp);

                entities.add(Prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public Professeur get(String lastname, String firstname) {
        try {
            Professeur result = new Professeur();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM professeur WHERE lastname = ? AND firstname = ? ;");
            statement.setString(1, lastname);
            statement.setString(2, firstname);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                result.setId(rs.getInt("id"));
                result.setFirstName(rs.getString("firstname"));
                result.setLastName(rs.getString("lastname"));
                result.setMdp(rs.getString("mdp"));
            }
            else{
                return null;
            }
            return result;
            
        } catch (Exception e){
            return null;
        }      
    }

    public Professeur get(String id) {
        try {
            Professeur result = new Professeur();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM professeur WHERE id = ? ;");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                result.setId(rs.getInt("id"));
                result.setFirstName(rs.getString("firstname"));
                result.setLastName(rs.getString("lastname"));
                result.setMdp(rs.getString("mdp"));
            }
            else{
                return null;
            }
            return result;
            
        } catch (Exception e){
            return null;
        }      
    }
}
