package com.gaopengjie.vince.mybmob;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.gaopengjie.vince.mybmob.bean.User;
import java.io.File;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

public class ReqisterActivity extends AppCompatActivity {
    private EditText et_name,et_password,et_phone,et_email,et_icon;
    private int valiCode=1;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqister);
        //初始化Bmob
        Bmob.initialize(this,"253f70a1a9098bbfed55a2329f7d5f29");

         et_name = (EditText) findViewById(R.id.editText_name);
         et_password = (EditText) findViewById(R.id.editText2_password);
         et_phone = (EditText) findViewById(R.id.editText3_phone);
         et_email= (EditText) findViewById(R.id.editText_Email);
         et_icon= (EditText) findViewById(R.id.editText_icon);


    }

   //跳转到登录页面
    public void logingClick(View v){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);

    }

    //注册
    public void loginClick(View v){
        final String name=et_name.getText().toString();
        final String password=et_password.getText().toString();
        final String phone=et_phone.getText().toString();
        final String email=et_email.getText().toString();
        final String icon=et_icon.getText().toString();

        String path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/"+icon;

       final BmobFile bmobFile=new BmobFile(new File(path));

        bmobFile.upload(this, new UploadFileListener() {
            @Override
            public void onSuccess() {
                User user=new User();
                user.setUsername(name);
                user.setPassword(password);
                user.setEmail(email);
                user.setMobilePhoneNumber(phone);
                user.setIcon(bmobFile);

                //注意：不能用save方法进行注册
                user.signUp(ReqisterActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(ReqisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        //通过BmobUser.getCurrentUser(context)方法获取登录成功后的本地用户信息
                    }
                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(ReqisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(int i, String s) {

            }
        });


    }
}
