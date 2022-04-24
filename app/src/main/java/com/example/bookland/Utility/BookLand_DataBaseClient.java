package com.example.bookland.Utility;
import android.content.Context;
import androidx.room.Room;
public class BookLand_DataBaseClient
{
    private Context context;
    private static BookLand_DataBaseClient BInstance;

    private AppDataBase appDataBase;

    public BookLand_DataBaseClient(Context context)
    {
        this.context=context;
        appDataBase= Room.databaseBuilder(context,AppDataBase.class,"MyDB").allowMainThreadQueries().build();
    }
    public static synchronized BookLand_DataBaseClient getBInstance(Context context)
    {
        if (BInstance==null)
        {
            BInstance=new BookLand_DataBaseClient(context);
        }
        return BInstance;
    }
    public AppDataBase getAppDataBase()
    {
        return appDataBase;
    }
}
