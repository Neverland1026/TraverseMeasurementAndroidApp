package com.example.neverland_ly.biyesheji;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VibrateActivity extends Activity {

    private EditText et_text;
    private Button btn_submit;
    /**
     * 手机振动器
     */
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        et_text = (EditText) this.findViewById(R.id.et_text);
        btn_submit = (Button) this.findViewById(R.id.btn_submit);
        // 震动效果的系统服务
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btn_submit.setOnClickListener(new OnClickListener() {
//            String text = et_text.getText().toString().trim();

            public void onClick(View v) {
//                if (TextUtils.isEmpty(text)) {
                if("".equals(et_text.getText().toString().trim())){
                    Toast.makeText(VibrateActivity.this, "内容为空", Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(
                            VibrateActivity.this, R.anim.shake);
                    et_text.startAnimation(shake);

                    /*
                     * 震动的方式
                     */
                    // vibrator.vibrate(2000);//振动两秒

                    // 下边是可以使震动有规律的震动   -1：表示不重复 0：循环的震动
//                    long[] pattern = { 200, 2000, 2000, 200, 200, 200 };
//                    vibrator.vibrate(pattern, -1);
                    vibrator.vibrate(200);
                }
            }
        });
    }
}