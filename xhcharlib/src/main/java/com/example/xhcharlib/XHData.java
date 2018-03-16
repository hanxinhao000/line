package com.example.xhcharlib;

import android.graphics.Color;

/**
 * Created by XINHAO_HAN on 2018/3/15.
 */

public class XHData {

    private float x = 0;
    private float y = 0;

    private int color = Color.parseColor("#adadad");
    //是否使用数据/坐标
    private boolean isDataUser = true;

    private float data = 0;

    //日期
    private String date;

    public String getDate() {
        return date;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public XHData(boolean isDataUser, float data) {
        this.isDataUser = isDataUser;
        this.data = data;
    }

    public XHData(boolean isDataUser, float data, String date) {
        this.isDataUser = isDataUser;
        this.data = data;
        this.date = date;
    }

    public XHData(boolean isDataUser, float data, String date, int color) {
        this.isDataUser = isDataUser;
        this.data = data;
        this.date = date;
        this.color = color;
    }

    public boolean isDataUser() {
        return isDataUser;
    }

    public void setDataUser(boolean dataUser) {
        isDataUser = dataUser;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public XHData() {
    }

    public XHData(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        x += (50 + 100);
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {

        y += 100;
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
