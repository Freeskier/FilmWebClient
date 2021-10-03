package com.client.LocalStorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.User;
import com.google.gson.Gson;


public class Storage {
    static final String STORAGE_USER= "user";


    public static void setUser(StorageUser user, Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(STORAGE_USER, new Gson().toJson(user));
        editor.apply();
    }

    public static StorageUser getUser(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if(prefs.getString(STORAGE_USER, "").equals(""))
            return null;
        return new Gson().fromJson(prefs.getString(STORAGE_USER, ""), StorageUser.class);
    }

    public static void removeUser(Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
    }

}
