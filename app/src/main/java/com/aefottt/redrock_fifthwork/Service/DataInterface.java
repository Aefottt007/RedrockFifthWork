package com.aefottt.redrock_fifthwork.Service;

import android.content.Context;

public interface DataInterface {
    String file_account_name = "account";
    String file_password_name = "password";
    String file_userInfo_name = "userInfo";
    void saveData(Context context,String account,String password);
    String[] getData(Context context);
}
