package com.gaopengjie.vince.mybmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gaopengjie.vince.mybmob.bean.User;

import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private EditText et_name,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);

    }

    public void logingClick(View view){
       String name=et_name.getText().toString();
        String password=et_password.getText().toString();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }
        final User user=new User();
        user.setUsername(name);
        user.setPassword(password);
        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                if (user.getEmailVerified()){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "用户没有验证邮箱", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
