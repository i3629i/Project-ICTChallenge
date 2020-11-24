package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;


public class MainActivity extends AppCompatActivity {
    TextInputEditText join_id, join_pw;
    EditText joid;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        join_id = findViewById(R.id.edit_id);
        join_pw = findViewById(R.id.edit_pwd);

        findViewById(R.id.btn_in).setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if (join_id.getText().toString().equals("user1") && join_pw.getText().toString().equals("1234")){
                            Intent intent = new Intent(getApplicationContext(), LoadmapActivity.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else if(!join_id.getText().toString().equals("user1")){
                            Toast.makeText(MainActivity.this, "아이디를 잘못 입력하셨습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else if(!join_id.getText().toString().equals("1234")){
                            Toast.makeText(MainActivity.this, "패스워드를 잘못 입력하셨습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "아이디 혹은 패스워드를 잘못 입력하셨습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

}