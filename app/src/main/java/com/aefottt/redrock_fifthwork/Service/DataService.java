package com.aefottt.redrock_fifthwork.Service;

import android.content.Context;
import android.content.SharedPreferences;

public class DataService implements DataInterface{
    public DataService() {
    }

    @Override
    public void saveData(Context context, String account, String password) {
        SharedPreferences sp = context.getSharedPreferences(file_userInfo_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(file_account_name,account);
        editor.putString(file_password_name,password);
        editor.apply();
    }

    @Override
    public String[] getData(Context context) {
        String[] userInfo = new String[2];
        SharedPreferences sp = context.getSharedPreferences(file_userInfo_name,Context.MODE_PRIVATE);
        userInfo[0] = sp.getString(file_account_name,null);
        userInfo[1] = sp.getString(file_password_name,null);
        return userInfo;
    }
}
