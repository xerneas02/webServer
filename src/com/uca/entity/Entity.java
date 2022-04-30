package com.uca.entity;

import java.sql.*;
import com.uca.dao.*;

public class Entity {
    protected String firstName;
    protected String lastName;
    protected int id;

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
    }
}
