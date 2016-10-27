package com.gaopengjie.vince.mybmob.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by assistant on 2016/10/26.
 */
public class Person extends BmobObject {

    private String name;
    private String adddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adddress='" + adddress + '\'' +
                '}';
    }
}
