package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;

public class Entity {
    protected String firstName;
    protected String lastName;
    protected int id;
    protected String table;

    public Entity() {}

    public Entity(int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.id        = id;
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
        /*Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("UPDATE " + table + "SET lastName = " + this.lastName + " WHERE id == " + this.id + ";");
            statement.executeUpdate();
        } catch (Exception e){
            System.out.println("could not insert " + table + " !\n" + e.toString());
            //throw new RuntimeException("could modified " + table + " !");
        }*/
    }
}
