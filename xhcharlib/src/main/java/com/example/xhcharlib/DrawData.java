package com.example.xhcharlib;

/**
 * Created by XINHAO_HAN on 2018/3/15.
 */

public class DrawData {

    //点的X
    private float dianX;
    //点的Y
    private float dianY;

    private String date;

    private int color;

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getDianX() {
        return dianX;
    }

    public void setDianX(float dianX) {
        this.dianX = dianX;
    }

    public float getDianY() {
        return dianY;
    }

    public void setDianY(float dianY) {
        this.dianY = dianY;
    }
}
