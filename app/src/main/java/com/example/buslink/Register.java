package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    public static HashMap<String, String> passwords = new HashMap<>();
    public static HashMap<String, String> names = new HashMap<>();
    boolean complete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if(Home.currentLanguage.equals("pt")){
            swap_language_pt(findViewById(android.R.id.content));
        }
        else if(Home.currentLanguage.equals("es")){
            swap_language_es(findViewById(android.R.id.content));
        }
        else if(Home.currentLanguage.equals("en")){
            swap_language_en(findViewById(android.R.id.content));
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if(Home.currentLanguage.equals("pt")){
            swap_language_pt(findViewById(android.R.id.content));
        }
        else if(Home.currentLanguage.equals("es")){
            swap_language_es(findViewById(android.R.id.content));
        }
        else if(Home.currentLanguage.equals("en")){
            swap_language_en(findViewById(android.R.id.content));
        }
    }

    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void return_home(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    // footer buttons section
    public void home(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void about_us(View view){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
    public void help(View view){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
    public void settings(View view){
        Intent intent = new Intent(this, Settings.class);
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

    // button swap language en
    public void swap_language_en(View view){

        Home.currentLanguage = "en";

        Button login = (Button) findViewById(R.id.login);
        login.setText(getResources().getString(R.string.log_in_en));

        TextView name_text = (TextView) findViewById(R.id.name_text);
        name_text.setText(getResources().getString(R.string.name_en));

        TextView confirm_password_text = (TextView) findViewById(R.id.confirm_password_text);
        confirm_password_text.setText(getResources().getString(R.string.confirm_password_en));

        Button register = (Button) findViewById(R.id.register);
        register.setText(getResources().getString(R.string.register_en));

        TextView home_option = (TextView) findViewById(R.id.home_option);
        home_option.setText(getResources().getString(R.string.home_en));

        TextView about_us_option = (TextView) findViewById(R.id.about_us_option);
        about_us_option.setText(getResources().getString(R.string.about_us_en));

        TextView help_option = (TextView) findViewById(R.id.help_option);
        help_option.setText(getResources().getString(R.string.help_en));

        TextView definitions_option = (TextView) findViewById(R.id.definitions_option);
        definitions_option.setText(getResources().getString(R.string.settings_en));
    }

    // button swap language es
    public void swap_language_es(View view){

        Home.currentLanguage = "es";

        Button login = (Button) findViewById(R.id.login);
        login.setText(getResources().getString(R.string.log_in_es));

        TextView name_text = (TextView) findViewById(R.id.name_text);
        name_text.setText(getResources().getString(R.string.name_es));

        TextView confirm_password_text = (TextView) findViewById(R.id.confirm_password_text);
        confirm_password_text.setText(getResources().getString(R.string.confirm_password_es));

        Button register = (Button) findViewById(R.id.register);
        register.setText(getResources().getString(R.string.register_es));

        TextView home_option = (TextView) findViewById(R.id.home_option);
        home_option.setText(getResources().getString(R.string.home_es));

        TextView about_us_option = (TextView) findViewById(R.id.about_us_option);
        about_us_option.setText(getResources().getString(R.string.about_us_es));

        TextView help_option = (TextView) findViewById(R.id.help_option);
        help_option.setText(getResources().getString(R.string.help_es));

        TextView definitions_option = (TextView) findViewById(R.id.definitions_option);
        definitions_option.setText(getResources().getString(R.string.settings_es));

    }

    public void swap_language_pt(View view){

        Home.currentLanguage = "pt";

        Button login = (Button) findViewById(R.id.login);
        login.setText(getResources().getString(R.string.log_in_pt));

        TextView name_text = (TextView) findViewById(R.id.name_text);
        name_text.setText(getResources().getString(R.string.name_pt));

        TextView confirm_password_text = (TextView) findViewById(R.id.confirm_password_text);
        confirm_password_text.setText(getResources().getString(R.string.confirm_password_pt));

        Button register = (Button) findViewById(R.id.register);
        register.setText(getResources().getString(R.string.register_pt));

        TextView home_option = (TextView) findViewById(R.id.home_option);
        home_option.setText(getResources().getString(R.string.home_pt));

        TextView about_us_option = (TextView) findViewById(R.id.about_us_option);
        about_us_option.setText(getResources().getString(R.string.about_us_pt));

        TextView help_option = (TextView) findViewById(R.id.help_option);
        help_option.setText(getResources().getString(R.string.help_pt));

        TextView definitions_option = (TextView) findViewById(R.id.definitions_option);
        definitions_option.setText(getResources().getString(R.string.settings_pt));
    }
}