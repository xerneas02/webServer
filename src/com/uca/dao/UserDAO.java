package com.uca.dao;

import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

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

    public ArrayList<Gommette> getAllEleveGommettes(Eleve eleve) {
        ArrayList<Gommette> entities = new ArrayList<>();
        try {
            
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT g.id id, g.couleur couleur, g.description description, eg.motif motif, eg.date date FROM gommette g INNER JOIN eleveGommette eg WHERE eg.idGommette = g.id AND eg.idEleve = ? ORDER BY id ASC;");
            preparedStatement.setInt(1, eleve.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id  = resultSet.getInt("id");
                String couleur = resultSet.getString("couleur");
                String description = resultSet.getString("description");
                String motif  = resultSet.getString("motif");
                String date  = resultSet.getString("date");
                Gommette gommette = new Gommette(id, couleur, description, motif, date);

                entities.add(gommette);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

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

    public void updateFirstName(Eleve obj, String firstName){
        obj.setFirstName(firstName);
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("UPDATE eleve SET firstname = " + firstName + " WHERE id = " + obj.getId() + ";");
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not modified eleve !");
        }
    }

    public void updateLastName(Eleve obj, String lastName){
        obj.setFirstName(lastName);
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("UPDATE eleve SET lastName = " + lastName + " WHERE id = " + obj.getId() + ";");
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not modified eleve !");
        }
    }

    public Professeur getProfesseur(String lastname, String firstname) {
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

    public void addGommette(Eleve eleve, String couleur, String description, String motif, int id) {
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("INSERT INTO gommette(couleur, description) VALUES(?, ?);");
            statement.setString(1, couleur    );
            statement.setString(2, description);
            statement.executeUpdate();

            statement = this.connect.prepareStatement("SELECT MAX(id) id FROM gommette WHERE couleur = ? AND description = ?;");
            statement.setString(1, couleur    );
            statement.setString(2, description);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int idGommette = resultSet.getInt("id");
            LocalDate date = LocalDate.now();

            statement = this.connect.prepareStatement("INSERT INTO eleveGommette(idEleve, idProf, idGommette, motif, date) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, eleve.getId());
            statement.setInt(2, id);
            statement.setInt(3, idGommette);
            statement.setString(4, motif);
            statement.setString(5, date.toString());
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("could not insert gommette !\n" + e.toString());
            throw new RuntimeException("could not insert gommette !");
        }
    }

    public void deleteGommette(String id) {
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



    @Override
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

    @Override
    public void delete(Eleve obj) {
        try {
            PreparedStatement statement;
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
            PreparedStatement statement;
            statement = this.connect.prepareStatement("DELETE FROM eleve WHERE id = ?;");
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not delete eleve !");
        }
    }
}
