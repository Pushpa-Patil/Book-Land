package com.example.bookland.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class FavoriteModel implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo( name ="BookName")
    private  String BookName;

    @ColumnInfo( name ="Auther")
    private String Auther;

    @ColumnInfo( name ="Image")
    private byte[] Image;


    @ColumnInfo(name = "Rate")
    private float Rate;



    @Ignore
    public FavoriteModel(int ID,String BookName, String Auther ,byte[] Image,float Rate)
    {
        this.ID=ID;
        this.BookName = BookName;
        this.Image = Image;
        this.Auther = Auther;
        this.Rate=Rate;


    }
    public FavoriteModel()
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


    public void setImage(byte[] image) {
        Image = image;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public float getRate() {
        return Rate;
    }
}
