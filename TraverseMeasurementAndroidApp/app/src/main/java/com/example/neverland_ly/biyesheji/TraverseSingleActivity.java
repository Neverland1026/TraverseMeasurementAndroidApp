package com.example.neverland_ly.biyesheji;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neverland_ly.biyesheji.Methods.TraverseInfo;
import com.example.neverland_ly.biyesheji.Methods.jiaodujiajian;
import com.example.neverland_ly.biyesheji.Methods.jiaoduzhuanhuan;
import com.example.neverland_ly.biyesheji.Methods.zuobiaozhengfansuan;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class TraverseSingleActivity extends AppCompatActivity {

    private static final int FLING_MIN_DISTANCE = 300;
    private static final int FLING_MIN_VELOCITY = 0;
    public android.support.design.widget.FloatingActionButton shang, xia, btn;
    private Vibrator vibrator;
    public static int a = 1;  //控制点击事件
    Toolbar toolbar;
    private List<TraverseInfo> datainfo;
    /************************************************************/
    public double x1, y1, x2, y2, x11, y11, x22, y22, s, xx, yy;
    public double du1, fen1, miao1, du2, fen2, miao2, du3, fen3, miao3, du4, fen4, miao4;
    public double zz, tt, o, p, q, w, m, n, mm, nn;
    public String str1, str2, str3, str4, str5, stro, strp, strq;
    public String strdu2, strfen2, strmiao2, strdu3, strfen3, strmiao3;
    public String strnote1, strnote2, strnote3;
    public EditText editx1, edity1, editx2, edity2, editx11, edity11, editx22, edity22,editxc, edityc;
    public EditText editdu1, editfen1, editmiao1, editdu2, editfen2, editmiao2, editdu3, editfen3, editmiao3, edits;
    public EditText editdu4, editfen4, editmiao4;
    public EditText editxx, edityy, editbeizhu;
    public LinearLayout oo;
    private static int i = 1;
    public int j, k;
    public TextView tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7, tv_8, tv_title, test1, test2;
    public double sum_s, sum_x, sum_y;

    /************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traverse_single);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotate2);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);

        toolbar = (Toolbar) this.findViewById(R.id.toolbar_tra);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        /************************************************************/
        editx1 = (EditText) this.findViewById(R.id.kzd_x1);
        edity1 = (EditText) this.findViewById(R.id.kzd_y1);
        editx2 = (EditText) this.findViewById(R.id.kzd_x2);
        edity2 = (EditText) this.findViewById(R.id.kzd_y2);
        editxc = (EditText) this.findViewById(R.id.kzd_xc);
        edityc = (EditText) this.findViewById(R.id.kzd_yc);
        editx11 = (EditText) this.findViewById(R.id.i_x);
        edity11 = (EditText) this.findViewById(R.id.i_y);
        editx22 = (EditText) this.findViewById(R.id.k_x);
        edity22 = (EditText) this.findViewById(R.id.k_y);
        edits = (EditText) this.findViewById(R.id.et_s);
        editxx = (EditText) this.findViewById(R.id.zl_x);
        edityy = (EditText) this.findViewById(R.id.zl_y);
        editbeizhu = (EditText) this.findViewById(R.id.edit_beizhu);

        tv_1 = (TextView) this.findViewById(R.id.tv_1);
        tv_2 = (TextView) this.findViewById(R.id.tv_2);
        tv_3 = (TextView) this.findViewById(R.id.tv_3);
        tv_4 = (TextView) this.findViewById(R.id.tv_4);
        tv_5 = (TextView) this.findViewById(R.id.tv_5);
        tv_6 = (TextView) this.findViewById(R.id.tv_6);
        tv_7 = (TextView) this.findViewById(R.id.tv_7);
        tv_8 = (TextView) this.findViewById(R.id.tv_8);
        tv_title = (TextView) this.findViewById(R.id.tv_title);
        test1 = (TextView) this.findViewById(R.id.test1);
        test2 = (TextView) this.findViewById(R.id.test2);

        editdu1 = (EditText) this.findViewById(R.id.et_du1);
        editfen1 = (EditText) this.findViewById(R.id.et_fen1);
        editmiao1 = (EditText) this.findViewById(R.id.et_miao1);
        editdu2 = (EditText) this.findViewById(R.id.et_du2);
        editfen2 = (EditText) this.findViewById(R.id.et_fen2);
        editmiao2 = (EditText) this.findViewById(R.id.et_miao2);
        editdu3 = (EditText) this.findViewById(R.id.et_du3);
        editfen3 = (EditText) this.findViewById(R.id.et_fen3);
        editmiao3 = (EditText) this.findViewById(R.id.et_miao3);
        editdu4 = (EditText) this.findViewById(R.id.et_du4);
        editfen4 = (EditText) this.findViewById(R.id.et_fen4);
        editmiao4 = (EditText) this.findViewById(R.id.et_miao4);

        oo = (LinearLayout) this.findViewById(R.id.oo);
        shang = (android.support.design.widget.FloatingActionButton) this.findViewById(R.id.my_fab_shang);
        xia = (android.support.design.widget.FloatingActionButton) this.findViewById(R.id.my_fab_xia);
        btn = (android.support.design.widget.FloatingActionButton) this.findViewById(R.id.btn_go);
        /************************************************************/

        /** start RotateAnimation */
        btn.startAnimation(operatingAnim);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 震动效果的系统服务
                vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                Animation shake = AnimationUtils.loadAnimation(
                        TraverseSingleActivity.this, R.anim.shake);
                vibrator.vibrate(50);
                /************************************************************/
                if (a == 1) {
                    //检查是否有空值
                    if (editx1.getText().toString().equals("") || edity1.getText().toString().equals("") || editx2.getText().toString().equals("") || edity2.getText().toString().equals("")|| editxc.getText().toString().equals("")|| edityc.getText().toString().equals("")) {
                        editx1.startAnimation(shake);
                        edity1.startAnimation(shake);
                        editx2.startAnimation(shake);
                        edity2.startAnimation(shake);
                        editxc.startAnimation(shake);
                        edityc.startAnimation(shake);
                        vibrator.vibrate(50);
                        Toast.makeText(getApplicationContext(), "请完整的输入X1，Y1，X2,Y2", Toast.LENGTH_SHORT).show();
                    } else {
                        //获取必要量
                        x1 = Double.parseDouble(editx1.getText().toString());
                        y1 = Double.parseDouble(edity1.getText().toString());
                        x2 = Double.parseDouble(editx2.getText().toString());
                        y2 = Double.parseDouble(edity2.getText().toString());
                        //开始计算推算元素
                        sum_x = x2 - x1;
                        sum_y = y2 - y1;
                        zuobiaozhengfansuan fs = new zuobiaozhengfansuan();
                        zz = fs.zbfs_fwj(x1, y1, x2, y2);
                        sum_s = fs.zbfs_S(x1, y1, x2, y2);
                        Log.i("方位角是：", "" + zz);
                        jiaoduzhuanhuan test1 = new jiaoduzhuanhuan();
                        test1.miaozhuanjiaodu(zz);

                        editdu1.setText("" + test1.getDu());
                        editfen1.setText("" + test1.getFen());
                        editmiao1.setText("" + test1.getMiao());
                        editdu2.setText("" + test1.getDu());
                        editfen2.setText("" + test1.getFen());
                        editmiao2.setText("" + test1.getMiao());
                        editx11.setText("" + x2);
                        edity11.setText("" + y2);
                        editx1.setEnabled(false);
                        editx2.setEnabled(false);
                        edity1.setEnabled(false);
                        edity2.setEnabled(false);
                        editxc.setEnabled(false);
                        edityc.setEnabled(false);
                        edits.setEnabled(true);
                        editdu3.setEnabled(true);
                        editfen3.setEnabled(true);
                        editmiao3.setEnabled(true);
                        editbeizhu.setEnabled(true);
                        oo.setVisibility(View.VISIBLE);
                        tv_title.setText("(前)0---第1站---2(后)");
                        a = 2;
                    }
                } else if (a == 2) {
                    //检查是否有空值
                    if (edits.getText().toString().equals("") || editdu3.getText().toString().equals("") || editfen3.getText().toString().equals("") || editmiao3.getText().toString().equals("")) {
                        edits.startAnimation(shake);
                        editdu3.startAnimation(shake);
                        editfen3.startAnimation(shake);
                        editmiao3.startAnimation(shake);
                        vibrator.vibrate(50);
                        Toast.makeText(getApplicationContext(), "请完整的输入S以及转角", Toast.LENGTH_SHORT).show();
                    } else {
                        //获取必要量
                        x11 = Double.parseDouble(editx11.getText().toString());
                        y11 = Double.parseDouble(edity11.getText().toString());

                        du2 = Double.parseDouble(editdu2.getText().toString());
                        fen2 = Double.parseDouble(editfen2.getText().toString());
                        miao2 = Double.parseDouble(editmiao2.getText().toString());
                        du3 = Double.parseDouble(editdu3.getText().toString());
                        fen3 = Double.parseDouble(editfen3.getText().toString());
                        miao3 = Double.parseDouble(editmiao3.getText().toString());

                        strdu2 = String.format("%.0f", du2);
                        strfen2 = String.format("%.0f", fen2);
                        strmiao2 = String.format("%.0f", miao2);
                        strdu3 = String.format("%.0f", du3);
                        strfen3 = String.format("%.0f", fen3);
                        strmiao3 = String.format("%.0f", miao3);

                        s = Double.parseDouble(edits.getText().toString());
                        //开始计算本站值
                        jiaodujiajian test2 = new jiaodujiajian();
                        test2.jiaodujia(du2, fen2, miao2, du3, fen3, miao3);
                        o = test2.getDujia();
                        p = test2.getFenjia();
                        q = test2.getMiaojia();
                        jiaodujiajian test3 = new jiaodujiajian();
                        test3.jiaodujian(o, p, q, 180, 0, 0);

                        o = (int) Math.floor(test3.getDujian());
                        p = (int) Math.floor(test3.getFenjian());
                        q = (int) Math.floor(test3.getMiaojian());
                        stro = String.format("%.0f", o);
                        strp = String.format("%.0f", p);
                        strq = String.format("%.0f", q);
                        editdu4.setText(stro);
                        editfen4.setText(strp);
                        editmiao4.setText(strq);
                        jiaoduzhuanhuan test4 = new jiaoduzhuanhuan();
                        w = test4.jiaoduzhuanmiao(o, p, q);
                        m = s * Math.cos(w * 3.1415926 / 180);
                        n = s * Math.sin(w * 3.1415926 / 180);
                        str1 = String.format("%.4f", m);
                        str2 = String.format("%.4f", n);
                        editxx.setText("" + str1);
                        edityy.setText("" + str2);
                        x22 = x11 + m;
                        y22 = x22 + n;
                        str3 = String.format("%.4f", x22);
                        str4 = String.format("%.4f", y22);
                        editx22.setText("" + str3);
                        edity22.setText("" + str4);
                        str5 = editbeizhu.getText().toString().trim();
                        //不可编辑
                        edits.setEnabled(false);
                        editdu3.setEnabled(false);
                        editfen3.setEnabled(false);
                        editmiao3.setEnabled(false);
                        editbeizhu.setEnabled(false);
                        shang.setVisibility(View.VISIBLE);
                        xia.setVisibility(View.VISIBLE);
                        a = 3;
                    }
                } else if (a == 3) {
                    Toast.makeText(getApplicationContext(), "请选择修改数据或者进入下一站", Toast.LENGTH_SHORT).show();
                }

            }
        });


        /** 长按事件查询结果 */

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(TraverseSingleActivity.this, ResultActivity.class);
                startActivity(intent);
//                finish();
                return true;
            }
        });

        /***如果发现错误，重新编辑 */
        shang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可以编辑
                edits.setEnabled(true);
                editdu3.setEnabled(true);
                editfen3.setEnabled(true);
                editmiao3.setEnabled(true);
                editbeizhu.setEnabled(true);
                shang.setVisibility(View.INVISIBLE);
                xia.setVisibility(View.INVISIBLE);
                a = 2;
            }
        });

        datainfo = new ArrayList<TraverseInfo>();

        /**  进行下一站的测算 */
        xia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始存储数据了

                x11 = Double.parseDouble(editx11.getText().toString());
                y11 = Double.parseDouble(edity11.getText().toString());
                x22 = Double.parseDouble(editx22.getText().toString());
                y22 = Double.parseDouble(edity22.getText().toString());
                du4 = Double.parseDouble(editdu4.getText().toString());
                fen4 = Double.parseDouble(editfen4.getText().toString());
                miao4 = Double.parseDouble(editmiao4.getText().toString());
                du2 = Double.parseDouble(editdu2.getText().toString());
                fen2 = Double.parseDouble(editfen2.getText().toString());
                miao2 = Double.parseDouble(editmiao2.getText().toString());
                du3 = Double.parseDouble(editdu3.getText().toString());
                fen3 = Double.parseDouble(editfen3.getText().toString());
                miao3 = Double.parseDouble(editmiao3.getText().toString());
                xx = Double.parseDouble(editxx.getText().toString());
                yy = Double.parseDouble(edityy.getText().toString());
                s = Double.parseDouble(edits.getText().toString());
                sum_s = sum_s + s;
                sum_x = sum_x + xx;
                sum_y = sum_y + yy;
                strnote1 = String.format("%.4f", sum_s);
                strnote2 = String.format("%.4f", sum_x);
                strnote3 = String.format("%.4f", sum_y);
                str5 = str5 + "(本站结束时，ΣS=" + strnote1 + "m,Σ△X=" + strnote2 + "m,Σ△Y=" + strnote3 + "m)";

                datainfo.add(new TraverseInfo(i, "左角", x11 + "," + y11, strdu2 + "°" + strfen2 + "′" + strmiao2 + "″", strdu3 + "°" + strfen3 + "′" + strmiao3 + "″", stro + "°" + strp + "′" + strq + "″", xx + "," + yy, x22 + "," + y22, str5));

                /** 这里是把一堆数据写入到 .xml */
                try {
                    XmlSerializer serializer = Xml.newSerializer();
                    File file = new File(Environment.getExternalStorageDirectory(), "TraverseResult.xml");
                    FileOutputStream os = new FileOutputStream(file);
                    //initial，写入到那个文件以及编码方式
                    serializer.setOutput(os, "utf-8");
                    serializer.startDocument("utf-8", true);

                    serializer.startTag(null, "导线测量库");

                    for (TraverseInfo main : datainfo) {

                        serializer.startTag(null, "导线测量");

                        serializer.attribute(null, "点号", main.getId() + "");

                        serializer.startTag(null, "类型");
                        serializer.text(main.getType() + "");
                        serializer.endTag(null, "类型");

                        serializer.startTag(null, "本站坐标");
                        serializer.text(main.getCoordinate1() + "");
                        serializer.endTag(null, "本站坐标");

                        serializer.startTag(null, "上一方位角");
                        serializer.text(main.getAzimuth1());
                        serializer.endTag(null, "上一方位角");

                        serializer.startTag(null, "转角");
                        serializer.text(main.getCorner());
                        serializer.endTag(null, "转角");

                        serializer.startTag(null, "下一方位角");
                        serializer.text(main.getAzimuth2());
                        serializer.endTag(null, "下一方位角");

                        serializer.startTag(null, "坐标增量");
                        serializer.text(main.getIncremental());
                        serializer.endTag(null, "坐标增量");

                        serializer.startTag(null, "下一站坐标");
                        serializer.text(main.getCoordinate2());
                        serializer.endTag(null, "下一站坐标");

                        serializer.startTag(null, "本站备注");
                        serializer.text(main.getNote());
                        serializer.endTag(null, "本站备注");

                        serializer.endTag(null, "导线测量");
                    }

                    serializer.endTag(null, "导线测量库");


                    serializer.endDocument();

                    os.close();

                    Toast.makeText(getApplicationContext(), "该站的数据已经成功上传", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "该站的数据上传失败", Toast.LENGTH_LONG).show();
                }


                editx11.setText(str3);
                edity11.setText(str4);
                editdu2.setText("" + o);
                editfen2.setText("" + p);
                editmiao2.setText("" + q);
                edits.setText("");
                editx22.setText("");
                edity22.setText("");
                editdu3.setText("");
                editfen3.setText("");
                editmiao3.setText("");
                editdu4.setText("");
                editfen4.setText("");
                editmiao4.setText("");
                editxx.setText("");
                edityy.setText("");
                editbeizhu.setText("");
                edits.setEnabled(true);
                editdu3.setEnabled(true);
                editfen3.setEnabled(true);
                editmiao3.setEnabled(true);
                editbeizhu.setEnabled(true);
                shang.setVisibility(View.INVISIBLE);
                xia.setVisibility(View.INVISIBLE);
                i = i + 1;
                j = i - 1;
                k = i + 1;
                tv_title.setText("(前)" + j + "---第" + i + "站---" + k + "(后)");
                a = 2;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(TraverseSingleActivity.this, TypeActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

}