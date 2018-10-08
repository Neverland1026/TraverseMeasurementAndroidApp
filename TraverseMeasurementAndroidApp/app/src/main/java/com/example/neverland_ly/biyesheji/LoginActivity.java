package com.example.neverland_ly.biyesheji;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.neverland_ly.biyesheji.biyesheji.service.denglu.service;
import com.example.neverland_ly.biyesheji.biyesheji.service.denglu.spservice;

import java.util.Map;
import java.util.Timer;


public class LoginActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private Vibrator vibrator;
    Toolbar toolbar;
    GestureDetector mGestureDetector;
    public static int a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

//        toolbar = (Toolbar) this.findViewById(R.id.toolbar_login);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        et_username = (EditText) this.findViewById(R.id.et_username);
        et_password = (EditText) this.findViewById(R.id.et_password);
        ImageView rotate = (ImageView) findViewById(R.id.rotate);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        rotate.startAnimation(operatingAnim);
    }


    public void theft(View view) {
        if (a == 1) {
            et_username.setText("1205");
            a = a + 1;
        } else if (a == 2) {
            et_password.setText("10010110101");
            a = a + 1;
        } else {
            et_username.setText("1026");
            a = 1;
        }

    }

    public void sign_up(View view) {
        ImageView rotate = (ImageView) findViewById(R.id.rotate);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        rotate.startAnimation(operatingAnim);
        Toast.makeText(LoginActivity.this, "暂不提供注册新账户...", Toast.LENGTH_LONG).show();
    }

    public void login(View view) {
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        // 震动效果的系统服务
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        Animation shake = AnimationUtils.loadAnimation(
                LoginActivity.this, R.anim.shake);
        if ("1026".equals(username)) {
            if ("10010110101".equals(password)) {
                Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
                startActivityForResult(intent, 1);
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                finish();
                Toast.makeText(this, "Welcome to 宇哥测绘", Toast.LENGTH_SHORT).show();
                spservice.saveinfo(this, username, password);
            } else {
                et_password.startAnimation(shake);
                vibrator.vibrate(50);
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            }
        } else {
            et_username.startAnimation(shake);
            et_password.startAnimation(shake);
            vibrator.vibrate(50);
            Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
        }

    }

    //    private static Boolean isQuit = false;
    private long mExitTime = 0;

    //    Timer timer = new Timer();
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
