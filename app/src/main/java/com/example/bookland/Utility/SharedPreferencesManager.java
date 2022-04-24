package com.example.bookland.Utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

public class SharedPreferencesManager
{
    public static boolean setUser_ID(Context context,int UserID)
    {
        return MyApplication.getInstance().getSharedpreferences(context).edit().
                putInt(SharedPreferencesKeyConstant.User_ID,UserID).commit();
    }
    public  static int getUser_ID(Context context)
    {
        return MyApplication.getInstance().getSharedpreferences(context)
                .getInt(SharedPreferencesKeyConstant.User_ID,0);
    }
    public static boolean setUser_Name(Context context, String UserName)
    {
        return MyApplication.getInstance().getSharedpreferences(context)
                .edit().putString(SharedPreferencesKeyConstant.User_Name,UserName).commit();
    }
    public  static String getUser_Name(Context context)
    {
        return MyApplication.getInstance().getSharedpreferences(context)
                .getString(SharedPreferencesKeyConstant.User_Name,"");
    }
    public  static String getUser_MobileNo(Context context)
    {
        return MyApplication.getInstance().getSharedpreferences(context)
                .getString(SharedPreferencesKeyConstant.User_MobileNo,"");
    }
    public static boolean setUser_MobileNo(Context context, String UserMobileNo)
    {
        return MyApplication.getInstance().getSharedpreferences(context)
                .edit().putString(SharedPreferencesKeyConstant.User_MobileNo,UserMobileNo).commit();
    }
    public  static String getUser_Email(Context context)
    {
        return MyApplication.getInstance().getSharedpreferences(context)
                .getString(SharedPreferencesKeyConstant.User_Email,"");
    }
    public static boolean setUser_Email(Context context, String UserEmail)
    {
        return MyApplication.getInstance().getSharedpreferences(context)
                .edit().putString(SharedPreferencesKeyConstant.User_Email,UserEmail).commit();

    }


}
