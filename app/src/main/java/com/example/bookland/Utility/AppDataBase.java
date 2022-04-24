package com.example.bookland.Utility;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.bookland.Dao.BookHomeDao;
import com.example.bookland.Dao.DownloadDao;
import com.example.bookland.Dao.FavoriteDao;
import com.example.bookland.Dao.UserModelDao;
import com.example.bookland.Dao.book_details_Dao;
import com.example.bookland.Models.BookHome;
import com.example.bookland.Models.DownloadModel;
import com.example.bookland.Models.FavoriteModel;
import com.example.bookland.Models.UserModel;
import com.example.bookland.Models.book_details;

@Database(entities = {UserModel.class, BookHome.class, book_details.class, FavoriteModel.class, DownloadModel.class}
,version = 3,exportSchema = false)

public abstract class AppDataBase extends RoomDatabase
{
    public abstract UserModelDao userModelDao();

    public abstract BookHomeDao bookHomeDao();

    public abstract book_details_Dao bookDetails();

    public abstract FavoriteDao favoriteDao();

    public abstract DownloadDao downloadDao();

}
