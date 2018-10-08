package com.example.neverland_ly.biyesheji.Methods;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Neverland_LY on 2016/3/12.
 */
public class jiaoduzhuanhuan {

    public double dus;
    public double fens;
    public double miaos;
    public double sum;

    /**
     * 角度换算成小数
     *
     * @param du
     * @param fen
     * @param miao
     * @return
     */

    public double jiaoduzhuanmiao(double du, double fen, double miao) {

        dus = du;
        fens = chufa(fen,60);
        miaos = chufa(miao,3600);
        sum = dus + fens + miaos;
        return sum;
    }

    public double getSin(double sum) {
        return Math.sin(sum);
    }

    public double getCos(double sum) {
        return Math.cos(sum);
    }

    public int du;
    public int fen;
    public int miao;
    int s[];

    /**
     * 小数转 度、分、秒
     *
     * @param xiaoshu
     */

    public void miaozhuanjiaodu(double xiaoshu) {
        if(xiaoshu<0){
            xiaoshu+=360;
        }


//        try {
//
//            return true;
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }


        du = (int) xiaoshu;
        fen = (int) ((xiaoshu - (int) xiaoshu) * 60);
        miao = (int) (((xiaoshu - (int) xiaoshu) * 60 - (int) ((xiaoshu - (int) xiaoshu) * 60)) * 60);
//        miao = Format ("00",((xiaoshu - (int) xiaoshu) * 60 - (int) ((xiaoshu - (int) xiaoshu) * 60)) * 60);

        s = new int[3];
        s[0] = du;
        s[1] = fen;
        s[2] = miao;
//        return s[3];
    }

    /**
     * 获取转换的度、分、秒
     *
     * @return
     */
    public int getDu() {
        return s[0];
    }

    public int getFen() {
        return s[1];
    }

    public int getMiao() {
        return s[2];
    }

    // return x/y
    public static double chufa(double x, double y) {
        double c = x/ y;
        return c;
    }


}
