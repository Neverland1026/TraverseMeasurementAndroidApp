package com.example.neverland_ly.biyesheji;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.neverland_ly.biyesheji.Methods.TraverseInfo;
import com.example.neverland_ly.biyesheji.Methods.TraversePullParser;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    /**
     * 在这里调用
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result();//方法调用
    }

    /**
     * 这都是解析
     */
    public void result() {
        TextView tv = (TextView) this.findViewById(R.id.tv);
        //使用类加载器加载xml文件
        //下面这句话是用来读取工程下的文件的
        //List<TraverseInfo> traverseInfos = TraversePullParser.getTraverseInfos(ResultActivity.class.getClassLoader()
        //        .getResourceAsStream("TraverseResult.xml"));
        /*if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(),
                        "TraverseResult.xml");//这句话是从sd卡读取文件
                FileInputStream inputStream = new FileInputStream(file);//这句话是将文件作为文件输出流输出
                byte[] b = new byte[inputStream.available()];
                inputStream.read(b);//这句话是把读出来的内容放到字节数组中
                tv.setText(new String(b));
                Toast.makeText(ResultActivity.this, "读取文件成功",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(ResultActivity.this, "读取失败",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            // 此时SDcard不存在或者不能进行读写操作的
            Toast.makeText(ResultActivity.this,
                    "此时SDcard不存在或者不能进行读写操作", Toast.LENGTH_SHORT).show();
        }*/

        //以下使用pullparser解析文件存放到list
        List<TraverseInfo> traverseInfos = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(),
                    "TraverseResult.xml");//这句话是从sd卡读取文件
            TraverseInfo traverseInfo = null;
            FileInputStream stream = new FileInputStream(file);//这句话是将文件作为文件输出流输出
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(stream, "utf-8");//这里的编码，和你在文件写入时需要一致
            int evnType = parser.getEventType();
            while (evnType != XmlPullParser.END_DOCUMENT) {
                switch (evnType) {
                    case XmlPullParser.START_TAG:
                        String tag = parser.getName();
                        if ("导线测量库".equals(parser.getName())) {
                            //解析到全局开始的标签
                            traverseInfos = new ArrayList<TraverseInfo>();
                        } else if ("导线测量".equals(parser.getName())) {
                            traverseInfo = new TraverseInfo();
                            traverseInfo.setId(Integer.parseInt(parser.getAttributeValue(0)));
                        } else if ("类型".equals(parser.getName())) {
                            traverseInfo.setType(parser.nextText());
                        } else if ("本站坐标".equals(parser.getName())) {
                            traverseInfo.setCoordinate1(parser.nextText());
                        } else if ("上一方位角".equals(parser.getName())) {
                            traverseInfo.setAzimuth1(parser.nextText());
                        } else if ("转角".equals(parser.getName())) {
                            traverseInfo.setCorner(parser.nextText());
                        } else if ("下一方位角".equals(parser.getName())) {
                            traverseInfo.setAzimuth2(parser.nextText());
                        } else if ("坐标增量".equals(parser.getName())) {
                            traverseInfo.setIncremental(parser.nextText());
                        } else if ("下一站坐标".equals(parser.getName())) {
                            traverseInfo.setCoordinate2(parser.nextText());
                        } else if ("本站备注".equals(parser.getName())) {
                            traverseInfo.setNote(parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("导线测量".equals(parser.getName())) {
                            traverseInfos.add(traverseInfo);
                            traverseInfo = null;
                        }
                        break;
                    default:
                        break;
                }
                evnType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //这里可以遍历list然后展示结果了
        String showTraverseStr = "";
        if (null != traverseInfos && traverseInfos.size() > 0) {//此处判断，防止空指针异常
            for (TraverseInfo info : traverseInfos) {
                showTraverseStr += info.toString() + "\n";
            }
        }
        tv.setText(showTraverseStr);
    }

    /**
     * 这都是解析
     */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ResultActivity.this, TraverseActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}


