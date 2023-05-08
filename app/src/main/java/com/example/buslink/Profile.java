package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        name.setText(Register.names.get(Login.logged_in));
        email.setText(Login.logged_in);
    }

    public void return_home(View view){
        Intent intent = new Intent(this, Home_PT.class);
        startActivity(intent);
    }

    public void logout(View view){
        Login.logged_in = "";
        Intent intent = new Intent(this, Home_PT.class);
        startActivity(intent);
    }

    public void info(View view){
        Button info = findViewById(R.id.info);
        Button pass = findViewById(R.id.pass);
        info.setBackgroundResource(R.drawable.button_darker);
        pass.setBackgroundResource(R.drawable.button);

        findViewById(R.id.name_text).setVisibility(View.VISIBLE);
        findViewById(R.id.name).setVisibility(View.VISIBLE);
        findViewById(R.id.email_text).setVisibility(View.VISIBLE);
        findViewById(R.id.email).setVisibility(View.VISIBLE);
        findViewById(R.id.password_text).setVisibility(View.VISIBLE);
        findViewById(R.id.password).setVisibility(View.VISIBLE);
    }

    public void pass(View view){
        Button info = findViewById(R.id.info);
        Button pass = findViewById(R.id.pass);
        info.setBackgroundResource(R.drawable.button);
        pass.setBackgroundResource(R.drawable.button_darker);

        findViewById(R.id.name_text).setVisibility(View.GONE);
        findViewById(R.id.name).setVisibility(View.GONE);
        findViewById(R.id.email_text).setVisibility(View.GONE);
        findViewById(R.id.email).setVisibility(View.GONE);
        findViewById(R.id.password_text).setVisibility(View.GONE);
        findViewById(R.id.password).setVisibility(View.GONE);
    }
}