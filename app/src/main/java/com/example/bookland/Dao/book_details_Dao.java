package com.example.bookland.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bookland.Models.book_details;
import com.example.bookland.Models.book_details;

import java.util.List;

@Dao
public interface book_details_Dao
{
    @Query("SELECT * FROM book_details")
    List<book_details> getAllUsers();

    @Insert
    long insertbook_details(book_details b);

    @Update
    void  updatebook_details(book_details b);

    @Delete
    void  deletebook_details(book_details b);

    @Query("Select * from book_details WHERE ID=:ID")

    book_details b(long ID);

}
