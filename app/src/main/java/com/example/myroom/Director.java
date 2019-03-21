package com.example.myroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.security.PrivateKey;

@Entity(tableName = "Director_table")
public class Director {
    @PrimaryKey
    private int id;
    private String firstName;
    private String LastName;

    public Director(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
