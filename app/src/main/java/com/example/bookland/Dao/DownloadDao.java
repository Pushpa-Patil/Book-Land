package com.example.bookland.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bookland.Models.DownloadModel;
import com.example.bookland.Models.FavoriteModel;

import java.util.List;

@Dao
public interface DownloadDao
{
    @Query("SELECT * FROM DownloadModel")
    List<DownloadModel> getAllDownload();

    @Insert
    long insertDownloadMdel(DownloadModel dn);

    @Update
    void  updateDownloadModel(DownloadModel dn);

    @Delete
    void  deleteDownloadModel(DownloadModel dn);

    @Query("Select * from DownloadModel WHERE ID=:ID")

    DownloadModel dn(long ID);
}
