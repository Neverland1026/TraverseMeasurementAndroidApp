package com.example.neverland_ly.biyesheji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.neverland_ly.biyesheji.R;

import android.app.Activity;
import android.app.Service;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ThrillActivity extends Activity {
    private Button btn;
    private Vibrator mVibrator01;  //声明一个振动器对象

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置为无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置为全屏模式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 设置为横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_thrill);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mVibrator01 = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
//                mVibrator01.vibrate(new long[]{100, 100, 100, 1000}, -1);
                mVibrator01.vibrate(200);
            }
        });

    }
}