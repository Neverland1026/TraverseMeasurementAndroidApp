package com.example.neverland_ly.biyesheji.Methods;

import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Neverland_LY on 2016/3/12.
 */
public class zuobiaozhengfansuan {
    public double x2;
    public double y2;

    /**
     * 坐标正算待求点坐标值
     *
     * @param x1
     * @param y1
     * @param s
     * @param sum
     */
    public void zbzs(double x1, double y1, double s, double sum) {
        jiaoduzhuanhuan jdzh = new jiaoduzhuanhuan();
        x2 = x1 + s * jdzh.getSin(sum);
        y2 = y1 + s * jdzh.getCos(sum);
    }

    public double s;
    public double zfwj;
    public double ffwj;
    public double sum;

    /**
     * 坐标反算距离
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */

    public double zbfs_S(double x1, double y1, double x2, double y2) {
        s = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return s;
    }

    /**
     * 坐标反算方位角
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */

    public double zbfs_fwj(double x1, double y1, double x2, double y2) {

        sum = Math.toDegrees(Math.atan((y2 - y1) / (x2 - x1)));
        Log.i("检查：", "" + sum);
        if (x1 == x2 && y1 == y2) {
            sum = 0;
        } else {

            if (y2 > y1) {
                if (x2 > x1) {
                    sum = sum;
                } else if (x2 == x1) {
                    sum = 90;
                } else {
                    sum = 180 + sum;
                }

            } else if (y1 == y2) {
                if (x2 > x1) {
                    sum = 0;
                } else {
                    sum = 180;
                }
            } else {
                if (x2 > x1) {
                    sum = sum + 360;
                } else if (x1 == x2) {
                    sum = 270;
                } else {
                    sum = 180 + sum;
                }
            }


        }
        return sum;
    }
}





