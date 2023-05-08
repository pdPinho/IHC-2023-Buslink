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
        EditText name = (EditText) findViewById(R.id.name);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        EditText confirm_password = (EditText) findViewById(R.id.confirm_password);

        Context context = this;

        AlertDialog.Builder alert_builder = new AlertDialog.Builder(context);
        alert_builder.setMessage("É perciso preencher todos os campos");
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

        if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            missing_alert.show();
        } else if (!password.getText().toString().equals(confirm_password.getText().toString())) {
            alert_builder.setMessage("As passwords teem de ser iguais");
            AlertDialog password_alert = alert_builder.create();
            password_alert.show();
        }
        else {
            Register.passwords.put(email.getText().toString(), password.getText().toString());
            Register.names.put(email.getText().toString(), name.getText().toString());
            complete = true;
            alert_builder.setMessage("Registro concluido!");
            AlertDialog complete_alert = alert_builder.create();
            complete_alert.show();
        }

    }
}