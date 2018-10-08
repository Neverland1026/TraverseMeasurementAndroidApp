package com.example.neverland_ly.biyesheji.Methods;

/**
 * Created by Neverland_LY on 2016/3/12.
 */
public class jiaodujiajian {
    public double du3;
    public double fen3;
    public double miao3;
    double s[];


    /**
     * 角度间的  加  法
     *
     * @param du1
     * @param fen1
     * @param miao1
     * @param du2
     * @param fen2
     * @param miao2
     */


    public void jiaodujia(double du1, double fen1, double miao1, double du2, double fen2, double miao2) {
        du3 = du1 + du2;
        fen3 = fen1 + fen2;
        miao3 = miao1 + miao2;
        if (miao3 >= 60) {
            miao3 = miao3 - 60;
            fen3 = fen3 + 1;
        }
        if (fen3 >= 60) {
            fen3 = fen3 - 60;
            du3 = du3 + 1;
        }
        if (du3 >= 360) {
            du3 = du3 - 360;
        }
        s = new double[3];
        s[0] = du3;
        s[1] = fen3;
        s[2] = miao3;



    }
    public double getDujia() {
        return s[0];
    }

    public double getFenjia() {
        return s[1];
    }

    public double getMiaojia() {
        return s[2];
    }



    public double du33;
    public double fen33;
    public double miao33;
    double t[];

    /**
     * 角度间的  减  法
     *
     * @param du1
     * @param fen1
     * @param miao1
     * @param du2
     * @param fen2
     * @param miao2
     */
    public void jiaodujian(double du1, double fen1, double miao1, double du2, double fen2, double miao2) {
//        if (miao1 > miao2) {
//            miao33 = miao1 - miao2;
//        } else {
//            if (miao1 == miao2) {
//                miao33 = 0;
//            } else {
//                if (fen1 >= 1) {
//                    fen1 = fen1 - 1;
//                    miao33 = miao1 + 60 - miao2;
//                } else {
//                    if (du1 >= 1) {
//                        du1 = du1 - 1;
//                        fen1 = fen1 + 59;
//                        miao33 = miao1 + 60 - miao2;
//                    } else {
//                        du1 = 359;
//                        fen1 = fen1 + 59;
//                        miao33 = miao1 + 60 - miao2;
//                    }
//                }
//
//            }
//        }
//        if (fen1 >= fen2) {
//            fen33 = fen1 - fen2;
//        } else {
//            if (du1 >= 1) {
//                du1 = du1 - 1;
//                fen33 = fen1 + 59 - fen2;
//            } else {
//                du1 = 359;
//                fen33 = fen1 + 59 - fen2;
//            }
//        }
//        if (du1 >= du2) {
//            du33 = du1 - du2;
//        } else {
//            du1 = 359;
//            du33 = du1 + 360 - du2;
//        }
        if(miao1>=miao2){
            miao33=miao1-miao2;
            if(fen1>fen2){
                fen33=fen1-fen2;
                if(du1>du2){
                    du33=du1-du2;
                }else if(du1==du2){
                    du33=0;
                }else{
                    du33=du1+360-du2;
                }
            }else if(fen1==fen2){
                fen33=0;
                if(du1>du2){
                    du33=du1-du2;
                }else if(du1==du2){
                    du33=0;
                }else{
                    du33=du1+360-du2;
                }
            }else{
                fen33=fen1+60-fen2;
                du1=du1-1;
                if(du1>=du2){
                    du33=du1-du2;
                }else{
                    du33=du1+360-du2;
                }
            }
        }else if(miao1<miao2){
            fen1=fen1-1;
            miao33=miao1+60-miao2;
            if(fen1>=fen2){
                fen33=fen1-fen2;
                if(du1>=du2){
                    du33=du1-du2;
                }else{
                    du33=du1+360-du2;
                }
            }else{
                du1=du1-1;
                fen33=fen1+360-fen2;
                if(du1>=du2){
                    du33=du1-du2;
                }else{
                    du33=du1+360-du2;
                }
            }
        }




        t = new double[3];
        t[0] = du33;
        t[1] = fen33;
        t[2] = miao33;
    }


    public double getDujian() {
        return t[0];
    }

    public double getFenjian() {
        return t[1];
    }

    public double getMiaojian() {
        return t[2];
    }

}

