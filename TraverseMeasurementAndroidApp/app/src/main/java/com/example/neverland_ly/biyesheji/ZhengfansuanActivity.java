package com.example.neverland_ly.biyesheji;

import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.neverland_ly.biyesheji.Methods.jiaoduzhuanhuan;
import com.example.neverland_ly.biyesheji.Methods.zuobiaozhengfansuan;
import org.xmlpull.v1.XmlSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ZhengfansuanActivity extends AppCompatActivity {
    public String st1, st2, st3;
    public double x1, y1, x2, y2, tt, zz, s, du, fen, miao, sum;
    public TextView resultText;
    public EditText x1Edit, y1Edit, x2Edit, y2Edit, duEdit, fenEdit, miaoEdit, sEdit;
    public RadioButton zsButton, fsButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioGroup radioGroup;
    public Button resultbutton;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //bar栏文字居中
//        TextView view = (TextView) findViewById(android.R.id.title);
//        view.setGravity(Gravity.CENTER);

        setContentView(R.layout.activity_zhengfansuan);


        toolbar = (Toolbar) this.findViewById(R.id.toolbar_zfs);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setTitle("My title");
//        toolbar.setTitle("12333333");
//        toolbar.setSubtitle("副标题");
//        toolbar.setLogo(R.mipmap.icon_white);
//        toolbar.setNavigationIcon(android.R.drawable.ic_input_delete);

//        ActionBar ab = getSupportActionBar();
//        ab.setLogo(R.drawable.radar);


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear1);
        linearLayout.getBackground().setAlpha(50);//0~255透明度值 0：全透明；255不透明


//        Window window = this.getWindow();
//
//        // Followed by google doc.
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
//
//        // For not opaque(transparent) color.
//        window.getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        x1Edit = (EditText) this.findViewById(R.id.et_x1);
        y1Edit = (EditText) this.findViewById(R.id.et_y1);
        x2Edit = (EditText) this.findViewById(R.id.et_x2);
        y2Edit = (EditText) this.findViewById(R.id.et_y2);
        duEdit = (EditText) this.findViewById(R.id.et_du);
        fenEdit = (EditText) this.findViewById(R.id.et_fen);
        miaoEdit = (EditText) this.findViewById(R.id.et_miao);
        sEdit = (EditText) this.findViewById(R.id.et_s);
//        resultText = (TextView) this.findViewById(R.id.tv_zfs);
        resultbutton = (Button) this.findViewById(R.id.btn_zfs);
        zsButton = (RadioButton) this.findViewById(R.id.radio_zs);
        fsButton = (RadioButton) this.findViewById(R.id.radio_fs);
//        x1Edit.setText("1");
//        y1Edit.setText("2");
//        x2Edit.setText("5");
//        y2Edit.setText("16");
        radioButton1 = (RadioButton) findViewById(R.id.radio_zs);
        radioButton2 = (RadioButton) findViewById(R.id.radio_fs);
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        //实例化单选按钮组监听器
        RadioGroupListener listener = new RadioGroupListener();
        //实例化单选按钮监听器
        OnCheckChangeListener radioListener = new OnCheckChangeListener();
        //为控件设置监听器
        radioGroup.setOnCheckedChangeListener(listener);
        radioButton1.setOnCheckedChangeListener(radioListener);
        radioButton2.setOnCheckedChangeListener(radioListener);

    }

//    private static Boolean isQuit = false;
//    private long mExitTime = 0;
//    Timer timer = new Timer();
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
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
//        return super.onKeyDown(keyCode, event);


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
//            Intent intent = new Intent(ZhengfansuanActivity.this, SelectActivity.class);
//            startActivity(intent);
//            finish();
            Intent intent = new Intent(ZhengfansuanActivity.this, SelectActivity.class);
            startActivityForResult(intent, 1);
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    //为单选按钮定义一个监听器
    //android.widget.CompoundButton
    class OnCheckChangeListener implements android.widget.CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton boxButton, boolean isChecked) {
//            if(isChecked){
//                System.out.println("checked:"+boxButton.getId());
//            }
//            else
//            {
//                System.out.println("unchecked:"+boxButton.getId());
//            }
        }
    }

    //RadioGroup的监听器，两个参数，一个是哪个对象组被选中了，后面是对象里面的哪个对象被选中了。
    //android.widget.RadioGroup.OnCheckedChangeListener;
    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

            if (checkedId == radioButton1.getId()) {
                Toast.makeText(getApplicationContext(), "您选择的是坐标正算", Toast.LENGTH_SHORT).show();
                System.out.println("选中了坐标正算~~~");
                x1Edit.setText("");
                y1Edit.setText("");
                sEdit.setEnabled(true);
                duEdit.setEnabled(true);
                fenEdit.setEnabled(true);
                miaoEdit.setEnabled(true);
                x2Edit.setText("------------");
                y2Edit.setText("------------");
                sEdit.setText("");
                duEdit.setText("");
                fenEdit.setText("");
                miaoEdit.setText("");
                x2Edit.setEnabled(false);
                y2Edit.setEnabled(false);
                resultbutton.setText("坐标正算计算结果");
                radioButton1.setTextColor(Color.WHITE);
                radioButton2.setTextColor(Color.BLACK);

            } else if (checkedId == radioButton2.getId()) {
                Toast.makeText(getApplicationContext(), "您选择的是坐标反算", Toast.LENGTH_SHORT).show();
                System.out.println("选中了坐标反算~~~");
                x1Edit.setText("");
                y1Edit.setText("");
                sEdit.setEnabled(false);
                duEdit.setEnabled(false);
                fenEdit.setEnabled(false);
                miaoEdit.setEnabled(false);
                sEdit.setText("------------");
                duEdit.setText("--");
                fenEdit.setText("--");
                miaoEdit.setText("--");
                x2Edit.setText("");
                y2Edit.setText("");
                x2Edit.setEnabled(true);
                y2Edit.setEnabled(true);
                resultbutton.setText("坐标反算计算结果");
                radioButton1.setTextColor(Color.BLACK);
                radioButton2.setTextColor(Color.WHITE);

            }
        }

    }


    public void click_cal(View view) {
        if (fsButton.isChecked()) {
            if (x1Edit.getText().toString().equals("") || y1Edit.getText().toString().equals("") || x2Edit.getText().toString().equals("") || y2Edit.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "请完整的输入X1，Y1，X2，Y2", Toast.LENGTH_SHORT).show();


            } else {

                zuobiaozhengfansuan zbfs = new zuobiaozhengfansuan();

                x1 = Double.parseDouble(x1Edit.getText().toString());
                y1 = Double.parseDouble(y1Edit.getText().toString());
                x2 = Double.parseDouble(x2Edit.getText().toString());
                y2 = Double.parseDouble(y2Edit.getText().toString());

                //计算方位角
                Log.i("执行", "开始坐标反算");
                zuobiaozhengfansuan test1 = new zuobiaozhengfansuan();
                zz = test1.zbfs_fwj(x1, y1, x2, y2);
                Log.i("" + zz, "" + zz);
                jiaoduzhuanhuan test2 = new jiaoduzhuanhuan();
                test2.miaozhuanjiaodu(zz);
                duEdit.setText("" + test2.getDu());
                fenEdit.setText("" + test2.getFen());
                miaoEdit.setText("" + test2.getMiao());
                Log.i("执行", "坐标反算的正方位角已经计算完毕");
                tt = zbfs.zbfs_S(x1, y1, x2, y2);
                st1 = String.format("%.4f", tt);
                sEdit.setText("" + st1);
//                Log.i("执行", "坐标反算的距离已经计算完毕");
//                Log.i("执行", "坐标反算已经计算完毕，并且已经显示成功");

//                //z自定义 toast 位置
//                Toast toast = Toast.makeText(getApplicationContext(), "自定义位置Toast", Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();


//                final Snackbar snackbar = Snackbar.make(sEdit, "测试弹出提示", Snackbar.LENGTH_LONG);
//                snackbar.show();
//                snackbar.setAction("取消", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        snackbar.dismiss();
//                    }
//                });


            }
        } else {

            if (x1Edit.getText().toString().equals("") || y1Edit.getText().toString().equals("") || sEdit.getText().toString().equals("") || fenEdit.getText().toString().equals("") || miaoEdit.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "请完整的输入X1，Y1，S以及度分秒", Toast.LENGTH_SHORT).show();
            } else {
                zuobiaozhengfansuan zbfs = new zuobiaozhengfansuan();
                x1 = Double.parseDouble(x1Edit.getText().toString());
                y1 = Double.parseDouble(y1Edit.getText().toString());
                du = Double.parseDouble(duEdit.getText().toString());
                fen = Double.parseDouble(fenEdit.getText().toString());
                miao = Double.parseDouble(miaoEdit.getText().toString());
                s = Double.parseDouble(sEdit.getText().toString());
                //度分秒转化角度
                jiaoduzhuanhuan zdzh = new jiaoduzhuanhuan();
                sum = zdzh.jiaoduzhuanmiao(du, fen, miao);
                System.out.println("角度是：" + du + "°" + fen + "′" + miao + "″");
                System.out.println("角度换小数是：" + sum);
                System.out.println("角度余弦是：" + Math.cos(sum * 3.1415926 / 180));
                System.out.println("角度正弦是：" + Math.sin(sum * 3.1415926 / 180));
                x2 = s * Math.cos(sum * 3.1415926 / 180) + x1;
                y2 = s * Math.sin(sum * 3.1415926 / 180) + y1;
                st2 = String.format("%.4f", x2);
                st3 = String.format("%.4f", y2);
                x2Edit.setText("" + st2);
                y2Edit.setText("" + st3);
            }
        }
    }


//    public void xml(View view) {
//        //if something has been store
//        StringBuilder sb = new StringBuilder();
//        sb.append("< ? xml version =\"1.0\" encoding = \"utf-8\" ?>");
//        sb.append("<smss>");
//
//        for (domain main : smsInfos) {
//            sb.append("<sms>");
//
//            sb.append("<date>");
//            sb.append(main.getDate());
//            sb.append("</date>");
//
//            sb.append("<type>");
//            sb.append(main.getType());
//            sb.append("</type>");
//
//            sb.append("<body>");
//            sb.append(main.getBody());
//            sb.append("</body>");
//
//            sb.append("<address>");
//            sb.append(main.getAddress());
//            sb.append("</address>");
//
//            sb.append("</sms>");
//        }
//
//        sb.append("</smss>");
//        try {
//            File file = new File(Environment.getExternalStorageDirectory(), "xml.xml");
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(sb.toString().getBytes());
//            fos.close();
//            Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();
//        }
//    }

    /** Produce .xml file */
//    public void id_xml(View view) {
//        try {
//            XmlSerializer serializer = Xml.newSerializer();
//            File file = new File(Environment.getExternalStorageDirectory(), "id_xml.xml");
//            FileOutputStream os = new FileOutputStream(file);
//            //initial，写入到那个文件以及编码方式
//            serializer.setOutput(os, "utf-8");
//            serializer.startDocument("utf-8", true); //start
//
//            serializer.startTag(null, "smss"); //开始节点
//
//            for (domain main : smsInfos) {
//
//                serializer.startTag(null, "sms"); //开始标签
//
//                serializer.attribute(null, "id", main.getId() + "");  //不必考虑节点的闭合
//
//                serializer.startTag(null, "date");
//                serializer.text(main.getDate() + "");
//                serializer.endTag(null, "date");
//
//                serializer.startTag(null, "type");
//                serializer.text(main.getType()+"");
//                serializer.endTag(null, "type");
//
//                serializer.startTag(null, "body");
//                serializer.text(main.getBody());
//                serializer.endTag(null, "body");
//
//                serializer.startTag(null, "address");
//                serializer.text(main.getAddress());
//                serializer.endTag(null, "address");
//
//                serializer.endTag(null, "sms"); //结束标签
//            }
//
//            serializer.endTag(null, "smss");     //闭合节点
//
//
//            serializer.endDocument();  // end
//
//            os.close(); //关闭 流
//
//            Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();
//
//        }
//
//
//    }


    /**
     * 坐标反算步骤
     *
     * @param view
     */
    public void cal_zs(View view) {

//        x1Edit.setText("123456");
//        y1Edit.setText("54321");
//        sEdit.setText("236.563");
//        duEdit.setText("10");
//        fenEdit.setText("20");
//        miaoEdit.setText("30");

        zuobiaozhengfansuan zbfs = new zuobiaozhengfansuan();
        x1 = Double.parseDouble(x1Edit.getText().toString());
        y1 = Double.parseDouble(y1Edit.getText().toString());
        du = Double.parseDouble(duEdit.getText().toString());
        fen = Double.parseDouble(fenEdit.getText().toString());
        miao = Double.parseDouble(miaoEdit.getText().toString());
        s = Double.parseDouble(sEdit.getText().toString());
        //度分秒转化角度
        jiaoduzhuanhuan zdzh = new jiaoduzhuanhuan();
        sum = zdzh.jiaoduzhuanmiao(du, fen, miao);
        x2 = s * Math.cos(sum) + x1;
        y2 = s * Math.sin(sum) + y1;
        st2 = String.format("%.4f", x2);
        st3 = String.format("%.4f", y2);
        x2Edit.setText("" + st2);
        y2Edit.setText("" + st2);

    }

}