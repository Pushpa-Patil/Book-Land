package com.example.bookland.Utility;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MyApplication extends Application
{
    private static MyApplication myApplicationInstance;
    private SharedPreferences sharedpreferences;
    public static synchronized MyApplication getInstance()
    {
        if (myApplicationInstance==null)
        {
           myApplicationInstance=new MyApplication();

        }
        return myApplicationInstance;
    }

    public SharedPreferences getSharedpreferences(Context context)
    {
        if (sharedpreferences == null)
        {
           sharedpreferences=context.getSharedPreferences(SharedPreferencesKeyConstant.Pre_Name,0);
        }
        return sharedpreferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
