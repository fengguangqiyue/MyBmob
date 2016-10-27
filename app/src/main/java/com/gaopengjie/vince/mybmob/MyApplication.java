package com.gaopengjie.vince.mybmob;

import android.app.Application;

import com.gaopengjie.vince.mybmob.bean.Person;
import cn.bmob.v3.Bmob;

/**
 * Created by assistant on 2016/10/26.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化数据:
        Bmob.initialize(this,"253f70a1a9098bbfed55a2329f7d5f29");

//        Person p2=new Person();
//        p2.setName("池游泳");

    }
}
