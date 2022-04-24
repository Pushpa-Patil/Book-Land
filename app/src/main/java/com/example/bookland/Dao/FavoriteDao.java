package com.example.bookland.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bookland.Models.FavoriteModel;

import java.util.List;
@Dao
public interface FavoriteDao
{

    @Query("SELECT * FROM FavoriteModel")
    List<FavoriteModel> getAllFavorites();

    @Insert
    long insertFavoriteModel(FavoriteModel addFav);

    @Update
    void  updateFavoriteModel(FavoriteModel addFav);

    @Delete
    void  deleteFavoriteModel(FavoriteModel addFav);

    @Query("Select * from FavoriteModel WHERE ID=:ID")

    FavoriteModel addFav(long ID);

}
