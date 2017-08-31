package com.example.zhanggang.duotiaomurecyclerview;

/**
 * 类作用：
 * 时  间：2017/8/15 - 19:49.
 * 创建人：张刚
 */

public class Data {
    public Data(String title, String name, String picture) {
        this.title = title;
        this.name = name;
        this.picture = picture;
    }

    public String title;
    public String name;
    public String picture;

    public int type;

    public void setType(int type) {
        this.type = type;
    }
}
