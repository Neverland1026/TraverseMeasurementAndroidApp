package com.example.neverland_ly.biyesheji;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class ConnectActivity extends AppCompatActivity {
    public static int i = 1;
    public TextView tv;
    public ImageView show;
    Toolbar toolbar;

    private Context mContext;
    private ViewFlipper vflp_help;
    private int[] resId = {R.drawable.erweima_wechat, R.drawable.erweima_qq,
            R.drawable.erweima_sina};

    private final static int MIN_MOVE = 100;   //最小距离
    private MyGestureListener mgListener;
    private GestureDetector mDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        toolbar = (Toolbar) this.findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tv = (TextView) this.findViewById(R.id.tv);
        show = (ImageView) this.findViewById(R.id.show);

        mContext = ConnectActivity.this;
        //实例化SimpleOnGestureListener与GestureDetector对象
        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);
        vflp_help = (ViewFlipper) findViewById(R.id.vflp_help);
        //动态导入添加子View
        for (int i = 0; i < resId.length; i++) {
            vflp_help.addView(getImageView(resId[i]));
        }


        vflp_help.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ConnectActivity.this);
                builder.setItems(new String[]{getResources().getString(R.string.save_picture)}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        vflp_help.setDrawingCacheEnabled(true);
                        Bitmap imageBitmap = vflp_help.getDrawingCache();
                        if (imageBitmap != null) {
                            new SaveImageTask().execute(imageBitmap);
                        }
                    }
                });
                builder.show();

                return true;
            }
        });


    }


    private class SaveImageTask extends AsyncTask<Bitmap, Void, String> {
        @Override
        protected String doInBackground(Bitmap... params) {
            String result = getResources().getString(R.string.save_picture_failed);
            try {
                String sdcard = Environment.getExternalStorageDirectory().toString();

                File file = new File(sdcard + "/Download");
                if (!file.exists()) {
                    file.mkdirs();
                }

                File imageFile = new File(file.getAbsolutePath(), new Date().getTime() + ".jpg");
                FileOutputStream outStream = null;
                outStream = new FileOutputStream(imageFile);
                Bitmap image = params[0];
                image.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                outStream.flush();
                outStream.close();
                result = getResources().getString(R.string.save_picture_success, file.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            vflp_help.setDrawingCacheEnabled(false);
        }
    }


    //重写onTouchEvent触发MyGestureListener里的方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }


    //自定义一个GestureListener,这个是View类下的，别写错哦！！！
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            if (e1.getX() - e2.getX() > MIN_MOVE) {
                vflp_help.setInAnimation(mContext, R.anim.right_in);
                vflp_help.setOutAnimation(mContext, R.anim.right_out);
                vflp_help.showNext();

                i = i + 1;
                if (i == 4) {
                    i = 1;
                }
                Log.i("Now:", "i=" + i);
                switch (i) {
                    case 1:
//                        tv.setText("Wechat");
                        show.setImageResource(R.drawable.logo_wechat);
                        Log.i("Now:", "i=" + i);
                        break;
                    case 2:
//                        tv.setText("QQ");
                        show.setImageResource(R.drawable.logo_qq);
                        Log.i("Now:", "i=" + i);
                        break;
                    case 3:
//                        tv.setText("Sina");
                        show.setImageResource(R.drawable.logo_sina);
                        Log.i("Now:", "i=" + i);
                        break;
                    default:
                        break;
                }

            } else if (e2.getX() - e1.getX() > MIN_MOVE) {
                vflp_help.setInAnimation(mContext, R.anim.left_in);
                vflp_help.setOutAnimation(mContext, R.anim.left_out);
                vflp_help.showPrevious();

                i = i - 1;
                if (i == 0) {
                    i = 3;
                }
                Log.i("Now:", "i=" + i);
                switch (i) {
                    case 1:
//                        tv.setText("Wechat");
                        show.setImageResource(R.drawable.logo_wechat);
                        Log.i("Now:", "i=" + i);
                        break;
                    case 2:
//                        tv.setText("QQ");
                        show.setImageResource(R.drawable.logo_qq);
                        Log.i("Now:", "i=" + i);
                        break;
                    case 3:
//                        tv.setText("Sina");
                        show.setImageResource(R.drawable.logo_sina);
                        Log.i("Now:", "i=" + i);
                        break;
                    default:
                        break;
                }
            }
            return true;
        }

    }

    private ImageView getImageView(int resId) {
        ImageView img = new ImageView(this);
        img.setBackgroundResource(resId);
        return img;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ConnectActivity.this, SelectActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}
