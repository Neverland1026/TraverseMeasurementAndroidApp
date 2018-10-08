package com.example.neverland_ly.biyesheji;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DownloadActivity.this, SelectActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void download1(View view) {
//        Intent it = new Intent();
//        it.setAction(Intent.ACTION_VIEW);
//        it.setData(Uri.parse("http://pan.baidu.com/s/1i5EVnId"));
//        startActivity(it);
        Toast.makeText(this, "已是最新版本，无需下载", Toast.LENGTH_SHORT).show();
    }
    public void download2(View view) {
        Intent it = new Intent();
        it.setAction(Intent.ACTION_VIEW);
        it.setData(Uri.parse("http://pan.baidu.com/s/1hs10elI"));
        startActivity(it);

    }
    public void download3(View view) {
        Intent it = new Intent();
        it.setAction(Intent.ACTION_VIEW);
        it.setData(Uri.parse("http://pan.baidu.com/s/1nu6ztaT"));
        startActivity(it);

    }
}




