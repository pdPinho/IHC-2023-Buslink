package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    public static String logged_in = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void return_home(View view){
        Intent intent = new Intent(this, Home_PT.class);
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

    public void login(View view){
        EditText email = (EditText) findViewById(R.id.email);
        String email_text = email.getText().toString();
        EditText password = (EditText) findViewById(R.id.password);
        String password_text = password.getText().toString();

        Context context = this;

        AlertDialog.Builder alert_builder = new AlertDialog.Builder(context);
        alert_builder.setMessage("É perciso preencher todos os campos");
        alert_builder.setCancelable(true);

        alert_builder.setPositiveButton(
                "ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog missing_alert = alert_builder.create();

        if(email_text.isEmpty() || password_text.isEmpty()){
            missing_alert.show();
        } else if (!Register.passwords.containsKey(email_text)) {
            alert_builder.setMessage("Email não está registado");
            AlertDialog email_alert = alert_builder.create();
            email_alert.show();
        } else if (!password_text.equals(Register.passwords.get(email_text))) {
            alert_builder.setMessage("Password incorreta");
            AlertDialog password_alert = alert_builder.create();
            password_alert.show();
        } else {
            logged_in = email_text;
            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
        }
    }
}