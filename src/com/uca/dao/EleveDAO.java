package com.uca.dao;

import com.uca.entity.*;
import com.uca.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class EleveDAO {

    public Connection connect = _Connector.getInstance();
    
    public ArrayList<Eleve> getAllEleves() {
        ArrayList<Eleve> entities = new ArrayList<>();
        try {
            
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleve ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id  = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                Eleve Eleve = new Eleve(id, firstName, lastName);

                entities.add(Eleve);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public void update(String id, String firstName, String lastName){
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("UPDATE eleve SET firstname = ? WHERE id = ?;");
            statement.setString(1, firstName);
            statement.setString(2, id);
            statement.executeUpdate();

            statement = this.connect.prepareStatement("UPDATE eleve SET lastname = ? WHERE id = ?;");
            statement.setString(1, lastName);
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not modified eleve !");
        }
    }

    public Eleve get(String lastname, String firstname) {
        try {
            Eleve result = new Eleve();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM eleve WHERE lastname = ? AND firstname = ? ;");
            statement.setString(1, lastname);
            statement.setString(2, firstname);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                result.setId(rs.getInt("id"));
                result.setFirstName(rs.getString("firstname"));
                result.setLastName(rs.getString("lastname"));
            }
            else{
                return null;
            }
            return result;
            
        } catch (Exception e){
            return null;
        }      
    }

    public Eleve get(String id) {
        try {
            Eleve result = new Eleve();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM eleve WHERE id = ?;");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                result.setId(rs.getInt("id"));
                result.setFirstName(rs.getString("firstname"));
                result.setLastName(rs.getString("lastname"));
            }
            else{
                return null;
            }
            return result;
            
        } catch (Exception e){
            return null;
        }   
    }

    public Eleve create(Eleve obj) {
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("INSERT INTO eleve(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("could not insert eleve !\n" + e.toString());
            throw new RuntimeException("could not insert eleve !");
        }
        
        return obj;
    }

    

    public void create(String firstname, String lastname) {
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("INSERT INTO eleve(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("could not insert eleve !\n" + e.toString());
            throw new RuntimeException("could not insert eleve !");
        }
    }

    public void delete(Eleve obj) {
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("DELETE FROM eleveGommette WHERE idEleve = ?;");
            statement.setInt(1, obj.getId());
            statement.executeUpdate();  

            statement = this.connect.prepareStatement("DELETE FROM eleve WHERE id = ?;");
            statement.setInt(1, obj.getId());
            statement.executeUpdate();           
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not delete eleve !");
        }
    }

    public void delete(String id) {
        try {
            Eleve eleve = get(id);
            delete(eleve);
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not delete eleve !");
        }
    }
}
