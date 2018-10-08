package com.example.neverland_ly.biyesheji;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.security.PrivateKey;

public class TypeActivity extends AppCompatActivity {


    private Button tra1, tra2, tra3, tra4, tra5, tra6, tra7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        tra1 = (Button) findViewById(R.id.traverse_1);
        tra2 = (Button) findViewById(R.id.traverse_2);
        tra3 = (Button) findViewById(R.id.traverse_3);
        tra4 = (Button) findViewById(R.id.traverse_4);
        tra5 = (Button) findViewById(R.id.traverse_5);
        tra6 = (Button) findViewById(R.id.traverse_6);
        tra7 = (Button) findViewById(R.id.traverse_7);


        tra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeActivity.this, TraverseSingleActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(TypeActivity.this, "仅有一个连接角的附合导线", Toast.LENGTH_LONG).show();

            }
        });
        tra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeActivity.this, TraverseDoubleActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(TypeActivity.this, "具有两个连接角的附合导线", Toast.LENGTH_LONG).show();
            }
        });
        tra3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeActivity.this, TraverseActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(TypeActivity.this, "单一闭合导线", Toast.LENGTH_LONG).show();
            }
        });
        tra4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeActivity.this,TraverseNothingActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(TypeActivity.this, "无定向导线", Toast.LENGTH_LONG).show();
            }
        });
        tra5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TypeActivity.this, "开发中...", Toast.LENGTH_SHORT).show();
            }
        });
        tra6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TypeActivity.this, "开发中...", Toast.LENGTH_SHORT).show();
            }
        });
        tra7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    PackageManager packageManager = getPackageManager();
//                    Intent intent = new Intent();
//                    intent = packageManager.getLaunchIntentForPackage("com.tencent.mm");
//                    startActivity(intent);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com/"));
//                    startActivity(viewIntent);
//                    Toast.makeText(TypeActivity.this, "您尚未安装此应用，请前往下载...", Toast.LENGTH_SHORT).show();
//                }
                LinearLayout traverse_define = (LinearLayout)findViewById(R.id.traverse_define);
                    if(traverse_define.getVisibility()==View.INVISIBLE){
                        traverse_define.setVisibility(View.VISIBLE);
                    }else{
                        traverse_define.setVisibility(View.INVISIBLE);
                    }
                Toast.makeText(TypeActivity.this, "开发中...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            LinearLayout traverse_define = (LinearLayout)findViewById(R.id.traverse_define);
            if(traverse_define.getVisibility()==View.VISIBLE){
                traverse_define.setVisibility(View.INVISIBLE);
            }else{
                Intent intent = new Intent(TypeActivity.this, SelectActivity.class);
                startActivity(intent);
                finish();
            }
        }
        return true;
    }

}



