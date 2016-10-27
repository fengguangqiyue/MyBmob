package com.gaopengjie.vince.mybmob;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gaopengjie.vince.mybmob.bean.Person;
import com.gaopengjie.vince.mybmob.bean.User;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addClick(View view){
        Person person=new Person();
        person.setName("汪苏泷");
        person.setAdddress("北京");
        person.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(int i, String s) {
            }
        });

    }

    public void findClick(View view){
        //查找对象ID：onFailure
        BmobQuery<Person> bmobQuery=new BmobQuery<>();
     //   bmobQuery.getObject("1546cdd87e",new BmobQuery<>());

    }
    public void detClick(View view){
        final Person p1=new Person();
        p1.setAdddress("");
    }

    public void updateClick(View view){
        Person p=new Person();
        p.setName("高尔夫司机");
        p.setAdddress("的时刻监控");
        p.update(this,"1546cdd87e",new UpdateListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(int i, String s) {
            }
        });
    }

    public void updatePassWordClick(View view){
        User.updateCurrentUserPassword(this, "123456", "123123", new UpdateListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "修改密码成功:123123", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(MainActivity.this, "修改失败", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
