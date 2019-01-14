package com.ll.ll20190107;

import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ll.ll20190107.bean.Result;
import com.ll.ll20190107.bean.User;



public class MainActivity extends AppCompatActivity {

    private EditText text;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text = findViewById(R.id.text_phone);
         pass = findViewById(R.id.text_pass);
          findViewById(R.id.log_but).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  LoginPrecenter loginPrecenter = new LoginPrecenter(new LoginCall());
                  loginPrecenter.reqeust(text.getText().toString().trim(),pass.getText().toString().trim());
              }
          });
    }
    class LoginCall implements  DataCall<Result<User>>{
        @Override
        public void success(Result<User> data) {
            Toast.makeText(MainActivity.this, data.getMessage()+"", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void fail() {
            Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
        }
    }
}
