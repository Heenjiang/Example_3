package com.example.zoey.example_3.data.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class SharedHelper {

    public static final String MYSP = "mysp";
    private Context mContext;

    public SharedHelper() {
    }

    public SharedHelper(Context mContext) {
        this.mContext = mContext;
    }


    //定义一个保存数据的方法
    public void save(String key, String value) {
        SharedPreferences sp = mContext.getSharedPreferences(MYSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
        Log.d(TAG, "save: ");
    }

    //定义一个读取SP文件的方法
    public String read(String key) {
        SharedPreferences sp = mContext.getSharedPreferences(MYSP, Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }
}
