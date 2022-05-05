package com.uca.dao;

import com.uca.entity.*;
import com.uca.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class EleveGommetteDAO {

    public Connection connect = _Connector.getInstance();
    
    public ArrayList<EleveGommette> getAllEleveGommettes(Eleve eleve) {
        ArrayList<EleveGommette> entities = new ArrayList<>();
        try {
            
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT eg.id id, eg.motif motif, eg.date date, g.id idGommette, eg.idProf idProf FROM gommette g INNER JOIN eleveGommette eg WHERE eg.idGommette = g.id AND eg.idEleve = ? ORDER BY id ASC;");
            preparedStatement.setInt(1, eleve.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id                = resultSet.getInt("id");

                int idGommette        = resultSet.getInt("idGommette");
                Gommette gommette     = GommetteCore.getGommette(idGommette + "");

                int idProf            = resultSet.getInt("idProf");
                Professeur professeur = ProfesseurCore.getProfesseur(idProf + "");

                String motif          = resultSet.getString("motif");
                String date           = resultSet.getString("date");

                EleveGommette eleveGommette = new EleveGommette(id, eleve, professeur, gommette, motif, date);

                entities.add(eleveGommette);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public void create(String idEleve, String idProf, String idGommette, String motif, String date) {
        try {
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO eleveGommette(idEleve, idProf, idGommette, motif, date) VALUES(?, ?, ?, ?, ?);");
            statement.setString(1, idEleve);
            statement.setString(2, idProf);
            statement.setString(3, idGommette);
            statement.setString(4, motif);
            statement.setString(5, date);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("could not insert gommette link !\n" + e.toString());
            throw new RuntimeException("could not insert gommette link !");
        }
    }

    public void delete(String id) {
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("DELETE FROM eleveGommette WHERE id = ?;");
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not delete gommette !");
        }
    } 
    
    public void update(String id, String motif, String date){
        try {
            PreparedStatement statement;
            statement = this.connect.prepareStatement("UPDATE eleveGommette SET motif = ? WHERE id = ?;");
            statement.setString(1, motif);
            statement.setString(2, id);
            statement.executeUpdate();

            statement = this.connect.prepareStatement("UPDATE eleveGommette SET date = ? WHERE id = ?;");
            statement.setString(1, date);
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not modified eleveGommette !");
        }
    }
}
