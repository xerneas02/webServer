package com.uca.dao;

import com.uca.Eleve.*;
import com.uca.entity.Eleve;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends _Generic<Eleve> {
    
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

    public void updateFirstName(Eleve obj, String firstName){
        obj.setFirstName(firstName);
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("UPDATE eleve SET firstname = " + firstName + " WHERE id == " + obj.getId() + ";");
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not modified eleve !");
        }
    }

    public void updateLastName(Eleve obj, String lastName){
        obj.setFirstName(lastName);
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("UPDATE eleve SET lastName = " + lastName + " WHERE id == " + obj.getId() + ";");
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not modified eleve !");
        }
    }

    @Override
    public Eleve create(Eleve obj) {
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO eleve(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("could not insert eleve !\n" + e.toString());
            throw new RuntimeException("could not insert eleve !");
        }
        
        return obj;
    }

    @Override
    public void delete(Eleve obj) {
        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM eleve WHERE id == " + obj.getId() + ";");
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not delete eleve !");
        }
    }
}
