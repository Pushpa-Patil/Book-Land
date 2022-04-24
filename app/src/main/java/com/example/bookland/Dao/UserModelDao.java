package com.example.bookland.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bookland.Models.FavoriteModel;
import com.example.bookland.Models.UserModel;

import java.util.List;

@Dao
public interface UserModelDao
{
    @Query("SELECT * FROM UserModel")
    List<UserModel> getAllUsers();

    @Insert
    long insertUserModel(UserModel U);

    @Update
    void   updateUserModel(UserModel U);

    @Delete

     void deleteUserModel(UserModel U);

    @Query("Select * from UserModel WHERE ID=:ID")
    UserModel userLogin(long ID);



}
