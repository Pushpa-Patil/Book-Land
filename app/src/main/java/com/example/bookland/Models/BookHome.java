package com.example.bookland.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class BookHome implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo( name ="BookName")
    private  String BookName;

    @ColumnInfo( name ="Auther")
    private String Auther;

    @ColumnInfo( name ="Image")
    private int Image;

    public BookHome(int id, String bookName, String auther, int image) {
        ID = id;
        BookName = bookName;
        Auther = auther;
        Image = image;
    }

    public BookHome()
    {

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setAuther(String auther) {
        Auther = auther;
    }

    public String getAuther() {
        return Auther;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}

