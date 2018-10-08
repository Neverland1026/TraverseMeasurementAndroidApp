package com.example.neverland_ly.biyesheji.Methods;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neverland_ly.biyesheji.R;

/**
 * Created by Neverland_LY on 2016/4/1.
 */
public class toast {
//    private static Toast toast;
//    private static CountDownTimer cdt;
//
//    public static void showToast(Context context, String content) {
//        if (toast == null) {
//            toast = new Toast(context);
//        }
//        View view = View.inflate(context, R.layout.a_toast, null);
//        toast.setView(view);
//        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
//        tv_content.setText(content);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.show();
//    }
//
//    public static void showShortToast(Context context, String content) {
//        if (toast == null) {
//            toast = new Toast(context);
//        }
//
//        View view = View.inflate(context, R.layout.a_toast, null);
//        toast.setView(view);
//        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
//        tv_content.setText(content);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.show();
//        if (cdt == null) {
//            cdt = new CountDownTimer(1000, 1000) {
//
//                @Override
//                public void onTick(long arg0) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onFinish() {
//                    toast.cancel();
//                }
//            };
//        }else{
//            cdt.cancel();
//            cdt = new CountDownTimer(1000, 1000) {
//
//                @Override
//                public void onTick(long arg0) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onFinish() {
//                    toast.cancel();
//                }
//            };
//        }
//        cdt.start();
//    }
}