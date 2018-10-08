package com.example.neverland_ly.biyesheji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;

public class SelectActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        toolbar = (Toolbar) this.findViewById(R.id.toolbar_select);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setTitle("My title");
//        toolbar.setTitle("12333333");
//        toolbar.setSubtitle("副标题");
//        toolbar.setLogo(R.mipmap.icon_white);
//        toolbar.setNavigationIcon(android.R.drawable.ic_input_delete);


    }

    public void test1(View view) {

        Intent intent = new Intent(SelectActivity.this, ZhengfansuanActivity.class);
        startActivityForResult(intent, 1);
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
        finish();
//        Intent intent = new Intent(SelectActivity.this, ZhengfansuanActivity.class);
//        startActivity(intent);
//        finish();

    }

    public void test2(View view) {

        Intent intent = new Intent(SelectActivity.this, TypeActivity.class);
        startActivityForResult(intent, 1);
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
        finish();
        Toast.makeText(SelectActivity.this, "注意：当前只提供左角版本", Toast.LENGTH_LONG).show();


    }

    public void test3(View view) {

        Intent intent = new Intent(SelectActivity.this, AuthorActivity.class);
        startActivity(intent);
        finish();

    }

    public void test4(View view) {

        Intent intent = new Intent(SelectActivity.this, DownloadActivity.class);
        startActivity(intent);
        finish();
    }

    public void test5(View view) {
        Intent intent = new Intent(SelectActivity.this, ConnectActivity.class);
        startActivity(intent);
        finish();
//        Toast.makeText(this, "正在开发...", Toast.LENGTH_SHORT).show();
    }


    private static Boolean isQuit = false;
    private long mExitTime = 0;
    Timer timer = new Timer();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
//            if ((System.currentTimeMillis() - mExitTime) > 2000) {//
//                // 如果两次按键时间间隔大于2000毫秒，则不退出
//                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                mExitTime = System.currentTimeMillis();// 更新mExitTime
//            } else {
////                System.exit(0);// 否则退出程序
//                Intent it = new Intent();
//                it.setAction(Intent.ACTION_MAIN);
//                it.addCategory(Intent.CATEGORY_HOME);
//                startActivity(it);
//                android.os.Process.killProcess(android.os.Process.myPid());//获取PID
//                System.exit(0);
//            }
//            return true;
//        }
        Intent it = new Intent();
        it.setAction(Intent.ACTION_MAIN);
        it.addCategory(Intent.CATEGORY_HOME);
        startActivity(it);


        return true;
    }
}
