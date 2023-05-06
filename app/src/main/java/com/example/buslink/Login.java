package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void return_home(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void register(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void forgot_password(View view){
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }
}