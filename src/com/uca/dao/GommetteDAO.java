package com.uca.dao;

import com.uca.entity.*;
import com.uca.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class GommetteDAO {

    public Connection connect = _Connector.getInstance();

    public ArrayList<Gommette> getAllGommettes() {
        ArrayList<Gommette> entities = new ArrayList<>();
        try {
            
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM gommette ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id  = resultSet.getInt("id");
                String couleur = resultSet.getString("couleur");
                String description = resultSet.getString("description");
                Gommette gommette = new Gommette(id, couleur, description);

                entities.add(gommette);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public void update(String id, String couleur, String description){
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("UPDATE gommette SET couleur = ? WHERE id = ?;");
            statement.setString(1, couleur);
            statement.setString(2, id);
            statement.executeUpdate();

            statement = this.connect.prepareStatement("UPDATE gommette SET description = ? WHERE id = ?;");
            statement.setString(1, description);
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not modified eleve !");
        }
    }

    public Gommette get(String id) {
        try {
            Gommette result = new Gommette();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM gommette WHERE id = ?;");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                result.setId(rs.getInt("id"));
                result.setCouleur(rs.getString("couleur"));
                result.setDescription(rs.getString("description"));
            }
            else{
                return null;
            }
            return result;
            
        } catch (Exception e){
            return null;
        }   
    }

    public void create(String couleur, String description) {
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("INSERT INTO gommette(couleur, description) VALUES(?, ?);");
            statement.setString(1, couleur    );
            statement.setString(2, description);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("could not insert gommette !\n" + e.toString());
            throw new RuntimeException("could not insert gommette !");
        }
    }

    public void delete(String id) {
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("DELETE FROM eleveGommette WHERE idGommette = ?;");
            statement.setString(1, id);
            statement.executeUpdate();

            statement = this.connect.prepareStatement("DELETE FROM gommette WHERE id = ?;");
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not delete gommette !");
        }
    } 
}
