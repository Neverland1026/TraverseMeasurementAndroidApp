package com.example.neverland_ly.biyesheji;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class STouchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stouch);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float mPosX = event.getX();//触摸点X坐标
        float mPosY = event.getY();//触摸点y坐标

        switch (action) {
            // 触摸按下的事件
            case MotionEvent.ACTION_DOWN:
                Log.v("ACTION_DOWN",mPosX+"---"+mPosY);
                break;
            // 触摸移动的事件
            case MotionEvent.ACTION_MOVE:
                Log.v("ACTION_MOVE",mPosX+"---"+mPosY);
                break;
            // 触摸抬起的事件
            case MotionEvent.ACTION_UP:
                Log.v( "ACTION_UP",mPosX+"---"+mPosY);
                break;
        }
        return true;
    }
}
