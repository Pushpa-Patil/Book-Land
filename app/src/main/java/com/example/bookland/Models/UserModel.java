package com.example.bookland.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserModel implements Serializable
{


    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Username")
    private String username;

    @ColumnInfo(name = "Mobileno")
    private String mobileno;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Password")
    private String password;

    @Ignore
    public UserModel(int ID, String username, String mobileno, String email, String password) {
        this.ID = ID;
        this.username = username;
        this.mobileno = mobileno;
        this.email = email;
        this.password = password;
    }

    public UserModel()
    {

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

