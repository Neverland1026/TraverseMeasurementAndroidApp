package com.example.neverland_ly.biyesheji.biyesheji.service.denglu;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Neverland_LY on 2016/2/14.
 */
public class service {
    public static boolean saveUserInfo(Context context,String username,String password){
        try {
            //File file = new File("data/data/com.example.neverland_ly.biyesheji/Info.txt");
            //context.getFilesDir();//返回一个目录/data/data/包名/files/
            //We do chicken right.
            File file= new File(context.getFilesDir(),"info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            //zhangsan##123
            fos.write((username+"##"+password).getBytes());
            fos.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static Map<String,String> getsaveUserInfo(Context context){
        File file= new File(context.getFilesDir(),"info.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = br.readLine();
            String[] infos = str.split("##");
            Map<String,String > map = new HashMap<String,String>();
            map.put("username",infos[0]);
            map.put("password",infos[1]);
            return map;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
