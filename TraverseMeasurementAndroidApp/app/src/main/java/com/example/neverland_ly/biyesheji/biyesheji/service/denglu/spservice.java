package com.example.neverland_ly.biyesheji.biyesheji.service.denglu;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Neverland_LY on 2016/4/4.
 */
public class spservice {
    public static void saveinfo(Context context,String username,String password){

        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        //得到一个 sp 的编辑器
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        //类似于数据库的事务，保证数据同时提交
        editor.commit();
    }
}
