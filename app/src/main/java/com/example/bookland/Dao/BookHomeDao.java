package com.example.bookland.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bookland.Models.BookHome;
import com.example.bookland.Models.book_details;

import java.util.List;

@Dao
public interface BookHomeDao {


    @Query("SELECT * FROM BookHome")
    List<BookHome> getAllUsers();

    @Insert
    long insertBookHome(BookHome bh);

    @Update
    void  updateBookHome(BookHome bh);

    @Delete
    void  deleteBookHome(BookHome bh);

    @Query("Select * from BookHome WHERE ID=:ID")

    BookHome bh(long ID);
}
