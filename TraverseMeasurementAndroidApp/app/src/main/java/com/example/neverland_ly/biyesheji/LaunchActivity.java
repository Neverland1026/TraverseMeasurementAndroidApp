package com.example.neverland_ly.biyesheji;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import android.os.Handler;
import android.widget.Toast;

import java.util.Timer;

public class LaunchActivity extends Activity {

//    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** 全屏设置，隐藏所有装饰*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /** 去掉标题*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_launch);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
//                Intent intent = new Intent();
//                intent.setClass(LaunchActivity.this, GoogleActivity.class);
//                startActivity(intent);
//                finish();
                Intent intent = new Intent(LaunchActivity.this, GoogleActivity.class);
                startActivityForResult(intent, 1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, 2000);
    }



    private static Boolean isQuit = false;
    private long mExitTime = 0;
    Timer timer = new Timer();
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {//
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();// 更新mExitTime
            } else {
//                System.exit(0);// 否则退出程序
                Intent it = new Intent();
                it.setAction(Intent.ACTION_MAIN);
                it.addCategory(Intent.CATEGORY_HOME);
                startActivity(it);
                android.os.Process.killProcess(android.os.Process.myPid());//获取PID
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
