package com.example.neverland_ly.biyesheji.Methods;

/**
 * Created by Neverland_LY on 2016/4/6.
 */
public class TraverseInfo {

    private int id;
    private String type;
    private String coordinate1;
    private String azimuth1;
    private String corner;
    private String azimuth2;
    private String incremental;
    private String coordinate2;
    private String note;

    public TraverseInfo() {

    }

    @Override
    public String toString() {
//        return "本次测量全部数据如下：" +'\n'+
//                "点号：" + id +'\n'+
//                ", type='" + type + '\'' +
//                ", coordinate1='" + coordinate1 + '\'' +
//                ", azimuth1='" + azimuth1 + '\'' +
//                ", corner='" + corner + '\'' +
//                ", azimuth2='" + azimuth2 + '\'' +
//                ", incremental='" + incremental + '\'' +
//                ", coordinate2='" + coordinate2 + '\'' +
//                ", note='" + note + '\'' +
//                '}';


        return  "点号：第" + id +"点"+"\n"+
                "     角度类型：" + type +"\n"+
                "     本站坐标：" + coordinate1 +"\n"+
                "     上一站方位角：" + azimuth1 + "\n"+
                "     转                角：" + corner + "\n"+
                "     下一站方位角：" + azimuth2 + "\n"+
                "     坐标增量：" + incremental +"\n"+
                "     下一站坐标：" + coordinate2 + "\n"+
                "     备注：" + note+ "\n" ;
    }

    public TraverseInfo(int id, String type, String coordinate1, String azimuth1, String corner, String azimuth2, String incremental, String coordinate2, String note) {
        this.id = id;
        this.type = type;
        this.coordinate1 = coordinate1;
        this.azimuth1 = azimuth1;
        this.corner = corner;
        this.azimuth2 = azimuth2;
        this.incremental = incremental;
        this.coordinate2 = coordinate2;
        this.note =note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoordinate1() {
        return coordinate1;
    }

    public void setCoordinate1(String coordinate1) {
        this.coordinate1 = coordinate1;
    }

    public String getAzimuth1() {
        return azimuth1;
    }

    public void setAzimuth1(String azimuth1) {
        this.azimuth1 = azimuth1;
    }

    public String getCorner() {
        return corner;
    }

    public void setCorner(String corner) {
        this.corner = corner;
    }

    public String getAzimuth2() {
        return azimuth2;
    }

    public void setAzimuth2(String azimuth2) {
        this.azimuth2 = azimuth2;
    }

    public String getIncremental() {
        return incremental;
    }

    public void setIncremental(String incremental) {
        this.incremental = incremental;
    }

    public String getCoordinate2() {
        return coordinate2;
    }

    public void setCoordinate2(String coordinate2) {
        this.coordinate2 = coordinate2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
