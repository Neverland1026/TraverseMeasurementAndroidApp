package com.example.neverland_ly.biyesheji.Methods;

import android.util.Xml;


import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neverland_LY on 2016/4/8.
 */
public class TraversePullParser {


    public static List<TraverseInfo> getTraverseInfos( InputStream is ){

        List<TraverseInfo> traverseInfos = null;
        TraverseInfo traverseInfo = null;
        //创建xml pull解析器
        XmlPullParser parser = Xml.newPullParser();
        try{
            //初始化pull xml解析
            parser.setInput(is, "utf-8");
            int type = parser.getEventType();//获取eventType
            //循环读取节点cd
            while( type != XmlPullParser.END_DOCUMENT){
                switch( type ){
                    case XmlPullParser.START_TAG:
                        if( "导线测量库".equals( parser.getName() ) ){
                            //解析到全局开始的标签
                            traverseInfos = new ArrayList<TraverseInfo>();
                        }else if( "导线测量".equals(parser.getName()) ){
                            traverseInfo = new TraverseInfo();
                            traverseInfo.setId(Integer.parseInt(parser.getAttributeValue(0)) );
                        }else if("类型".equals(parser.getName())){
                            traverseInfo.setType(parser.nextText() );
                        }else if("本站坐标".equals(parser.getName())){
                            traverseInfo.setCoordinate1(parser.nextText());
                        }else if("上一方位角".equals(parser.getName())){
                            traverseInfo.setAzimuth1(parser.nextText());
                        }else if("转角".equals(parser.getName())){
                            traverseInfo.setCorner(parser.nextText());
                        }else if("下一方位角".equals(parser.getName())){
                            traverseInfo.setAzimuth2(parser.nextText());
                        }else if("坐标增量".equals(parser.getName())){
                            traverseInfo.setIncremental(parser.nextText());
                        }else if("下一站坐标".equals(parser.getName())){
                            traverseInfo.setCoordinate2(parser.nextText());
                        }else if("本站备注".equals(parser.getName())){
                            traverseInfo.setNote(parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("导线测量".equals(parser.getName())){
                            traverseInfos.add(traverseInfo);
                            traverseInfo = null;
                        }
                        break;
                }
                type = parser.next();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return traverseInfos;

    }
}
