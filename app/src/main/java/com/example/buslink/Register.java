package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    public static HashMap<String, String> passwords = new HashMap<>();
    public static HashMap<String, String> names = new HashMap<>();
    boolean complete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void return_home(View view){
        Intent intent = new Intent(this, Home_PT.class);
        startActivity(intent);
    }

    public void register(View view){
        EditText name = findViewById(R.id.name);
        String name_text = name.getText().toString();
        EditText email = findViewById(R.id.email);
        String email_text = email.getText().toString();
        EditText password = findViewById(R.id.password);
        String password_text = password.getText().toString();
        EditText confirm_password = findViewById(R.id.confirm_password);
        String confirm_password_text = confirm_password.getText().toString();

        Context context = this;

        AlertDialog.Builder alert_builder = new AlertDialog.Builder(context);
        alert_builder.setMessage("É necessário preencher todos os campos");
        alert_builder.setCancelable(true);

        alert_builder.setPositiveButton(
                "ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if(complete){
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        }
                    }
                });

        AlertDialog missing_alert = alert_builder.create();

        if(name_text.isEmpty() || email_text.isEmpty() || password_text.isEmpty()){
            missing_alert.show();
        } /*else if (!email_text.contains("@") || !email_text.contains(".")) { // TODO make email verification more reliable (maybe with a lib?)
            alert_builder.setMessage("Formato de email inválido");
            AlertDialog email_alert = alert_builder.create();
            email_alert.show();
        }*/ else if (!password_text.equals(confirm_password_text)) {
            alert_builder.setMessage("As passwords teem de ser iguais");
            AlertDialog password_alert = alert_builder.create();
            password_alert.show();
        }
        else {
            Register.passwords.put(email_text, password_text);
            Register.names.put(email_text, name_text);
            complete = true;
            alert_builder.setMessage("Registro concluido!");
            AlertDialog complete_alert = alert_builder.create();
            complete_alert.show();
        }

    }
}