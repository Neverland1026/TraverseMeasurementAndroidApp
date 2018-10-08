package com.example.neverland_ly.biyesheji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class VirtualActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual);
        toolbar = (Toolbar) this.findViewById(R.id.toolbar_select);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    public void test1(View view) {
        Intent intent = new Intent(VirtualActivity.this, ZhengfansuanActivity.class);
        startActivityForResult(intent, 1);
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
        finish();
    }
    public void test3(View view) {
        Intent intent = new Intent(VirtualActivity.this, AuthorActivity.class);
        startActivity(intent);
        finish();
    }

    public void test5(View view) {
        Intent intent = new Intent(VirtualActivity.this, ConnectActivity.class);
        startActivity(intent);
        finish();
    }


    private long mExitTime = 0;
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

