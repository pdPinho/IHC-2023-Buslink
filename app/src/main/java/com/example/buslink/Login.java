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
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    public static String logged_in = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Register.passwords.put("georgesmith123@gmail.com", "IHC2023");
        Register.names.put("georgesmith123@gmail.com", "George Smith");

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

    public void return_home(View view){
        Intent intent = new Intent(this, Home.class);
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
        Intent intent = new Intent(this, Help_PT.class);
        startActivity(intent);
    }
    public void settings(View view) {
        Intent intent = new Intent(this, Settings_PT.class);
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

    // button swap language en
    public void swap_language_en(View view){

        Home.currentLanguage = "en";

        Button register_new = (Button) findViewById(R.id.register_new);
        register_new.setText(getResources().getString(R.string.register_en));

        TextView or_text = (TextView) findViewById(R.id.or_text);
        or_text.setText(getResources().getString(R.string.or_en));

        Button login = (Button) findViewById(R.id.login);
        login.setText(getResources().getString(R.string.log_in_en));

        TextView forgot_password = (TextView) findViewById(R.id.forgot_password);
        forgot_password.setText(getResources().getString(R.string.forgot_en));

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

        Button register_new = (Button) findViewById(R.id.register_new);
        register_new.setText(getResources().getString(R.string.register_es));

        TextView or_text = (TextView) findViewById(R.id.or_text);
        or_text.setText(getResources().getString(R.string.or_es));

        Button login = (Button) findViewById(R.id.login);
        login.setText(getResources().getString(R.string.log_in_es));

        TextView forgot_password = (TextView) findViewById(R.id.forgot_password);
        forgot_password.setText(getResources().getString(R.string.forgot_es));

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

        Button register_new = (Button) findViewById(R.id.register_new);
        register_new.setText(getResources().getString(R.string.register_pt));

        TextView or_text = (TextView) findViewById(R.id.or_text);
        or_text.setText(getResources().getString(R.string.or_pt));

        Button login = (Button) findViewById(R.id.login);
        login.setText(getResources().getString(R.string.log_in_pt));

        TextView forgot_password = (TextView) findViewById(R.id.forgot_password);
        forgot_password.setText(getResources().getString(R.string.forgot_pt));

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