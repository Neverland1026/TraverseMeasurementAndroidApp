package com.example.neverland_ly.biyesheji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class KeyInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_key_input);
        setContentView(R.layout.activity_key_input);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.v("onKeyDown", "按下：中键");
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                Log.v("onKeyDown", "按下：上方向键");
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Log.v("onKeyDown", "按下：下方向键");
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Log.v("onKeyDown", "按下：左方向键");
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Log.v("onKeyDown", "按下：右方向键");
                break;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.v("onKeyDown", "释放：中键");
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                Log.v("onKeyDown", "释放：上方向键");
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Log.v("onKeyDown", "释放：下方向键");
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Log.v("onKeyDown", "释放：左方向键");
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Log.v("onKeyDown", "释放：右方向键");
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}



