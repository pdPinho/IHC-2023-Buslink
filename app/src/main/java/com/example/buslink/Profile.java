package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    private static boolean pass1_added = false;
    public static String pass1_text = "";
    public static String pass1_email = "";
    public static boolean pass1_paid = false;
    private static boolean pass2_added = false;
    public static String pass2_text = "";
    public static String pass2_email = "";
    public static boolean pass2_paid = false;
    private static boolean pass3_added = false;
    public static String pass3_email = "";
    public static  String pass3_text = "";
    public static boolean pass3_paid = false;

    private static ArrayList<ConstraintSet> constraints = new ArrayList<>();

    // TODO passes not be shared between accounts
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
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void forgot(View view){
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

    public void logout(View view){
        Login.logged_in = "";
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void info(View view){
        Button info = findViewById(R.id.info);
        Button pass = findViewById(R.id.pass);
        info.setBackgroundResource(R.drawable.button_darker);
        pass.setBackgroundResource(R.drawable.button);

        findViewById(R.id.logout).setVisibility(View.VISIBLE);
        findViewById(R.id.name_text).setVisibility(View.VISIBLE);
        findViewById(R.id.name).setVisibility(View.VISIBLE);
        findViewById(R.id.email_text).setVisibility(View.VISIBLE);
        findViewById(R.id.email).setVisibility(View.VISIBLE);
        findViewById(R.id.password_text).setVisibility(View.VISIBLE);
        findViewById(R.id.password).setVisibility(View.VISIBLE);
        findViewById(R.id.add_pass_menu).setVisibility(View.GONE);
        findViewById(R.id.pass1_menu).setVisibility(View.GONE);
        findViewById(R.id.pass_template).setVisibility(View.GONE);

        findViewById(R.id.add_pass).setVisibility(View.GONE);
        findViewById(R.id.pass1).setVisibility(View.GONE);
        findViewById(R.id.pass2).setVisibility(View.GONE);
        findViewById(R.id.pass3).setVisibility(View.GONE);
    }

    public void pass(View view){

        ConstraintLayout constraintLayout = findViewById(R.id.parent_layout);
        for(ConstraintSet constraint : constraints){
            constraint.applyTo(constraintLayout);
        }

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
        findViewById(R.id.add_pass_menu).setVisibility(View.GONE);
        findViewById(R.id.pass1_menu).setVisibility(View.GONE);
        findViewById(R.id.pass_template).setVisibility(View.GONE);

        findViewById(R.id.logout).setVisibility(View.VISIBLE);
        if(!pass3_added){
            findViewById(R.id.add_pass).setVisibility(View.VISIBLE);
        }

        if (pass1_added){
            findViewById(R.id.pass1).setVisibility(View.VISIBLE);
        }
        if (pass2_added){
            findViewById(R.id.pass2).setVisibility(View.VISIBLE);
        }
        if (pass3_added){
            findViewById(R.id.pass3).setVisibility(View.VISIBLE);
        }


        Button pass1 = findViewById(R.id.pass1);
        Button pass2 = findViewById(R.id.pass2);
        Button pass3 = findViewById(R.id.pass3);

        pass1.setText(pass1_text);
        pass2.setText(pass2_text);
        pass3.setText(pass3_text);
    }

    // TODO verify email and stuff
    public void finish_add_pass(View view){

        EditText pass_number_view = (EditText) findViewById(R.id.pass_number);
        String pass_number = pass_number_view.getText().toString();

        EditText pass_email_view = (EditText) findViewById(R.id.pass_email);
        String pass_email = pass_email_view.getText().toString();

        if(pass_number.isEmpty() || pass_email.isEmpty()){
            return;
        }

        Context context = this;
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(context);
        alert_builder.setCancelable(true);

        alert_builder.setPositiveButton(
                "ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        if(!pass1_added && Login.logged_in.equals("gsmith@gmail.com")){
            if(!pass_number.equals("123456789")){
                alert_builder.setMessage("Não existe nenhum passe com esse número associado");
                AlertDialog wrong_pass_number = alert_builder.create();
                wrong_pass_number.show();
                return;
            }
            if(!pass_email.equals("hsmith@gmail.com")){
                alert_builder.setMessage("Não existe nenhum passe com esse email associado");
                AlertDialog wrong_pass_email = alert_builder.create();
                wrong_pass_email.show();
                return;
            }
        }



        if(pass1_text.isEmpty()){
            pass1_text = pass_number;
            pass1_email = pass_email;
        } else if(pass2_text.isEmpty()){
            pass2_text = pass_number;
            pass2_email = pass_email;
        } else if(pass3_text.isEmpty()){
            pass3_text = pass_number;
            pass3_email = pass_email;
        }

        add_pass(view);
    }

    public void add_pass(View view){

        Button pass1 = findViewById(R.id.pass1);
        Button pass2 = findViewById(R.id.pass2);
        Button pass3 = findViewById(R.id.pass3);

        if (!pass1_added) {
            pass1.setVisibility(View.VISIBLE);

            ConstraintLayout constraintLayout = findViewById(R.id.parent_layout);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.connect(R.id.add_pass,ConstraintSet.TOP,R.id.pass1,ConstraintSet.BOTTOM, 10);
            constraints.add(constraintSet);
            constraintSet.applyTo(constraintLayout);

            pass1.setText(pass1_text);
            pass1_added = true;

        } else if (!pass2_added) {
            pass2.setVisibility(View.VISIBLE);

            ConstraintLayout constraintLayout = findViewById(R.id.parent_layout);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.connect(R.id.add_pass,ConstraintSet.TOP,R.id.pass2,ConstraintSet.BOTTOM, 10);
            constraints.add(constraintSet);
            constraintSet.applyTo(constraintLayout);

            pass2.setText(pass2_text);
            pass2_added = true;

        } else if (!pass3_added) {
            pass3.setVisibility(View.VISIBLE);

            ConstraintLayout constraintLayout = findViewById(R.id.parent_layout);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.connect(R.id.add_pass,ConstraintSet.TOP,R.id.pass3,ConstraintSet.BOTTOM, 10);
            constraints.add(constraintSet);
            constraintSet.applyTo(constraintLayout);

            pass3.setText(pass3_text);

            pass3_added = true;
        }

        pass(view);
    }

    public void show_pass_add_menu(View view){

        EditText pass_number = (EditText) findViewById(R.id.pass_number);
        pass_number.setText("");

        EditText pass_email = (EditText) findViewById(R.id.pass_email);
        pass_email.setText("");


        findViewById(R.id.add_pass_menu).setVisibility(View.VISIBLE);
        findViewById(R.id.logout).setVisibility(View.GONE);
        findViewById(R.id.add_pass).setVisibility(View.GONE);
        findViewById(R.id.pass1).setVisibility(View.GONE);
        findViewById(R.id.pass2).setVisibility(View.GONE);
        findViewById(R.id.pass3).setVisibility(View.GONE);
    }

    // TODO do the rest of the menus for the other passes
    public void pass1(View view){

        findViewById(R.id.logout).setVisibility(View.GONE);
        findViewById(R.id.add_pass).setVisibility(View.GONE);
        findViewById(R.id.pass1).setVisibility(View.GONE);
        findViewById(R.id.pass2).setVisibility(View.GONE);
        findViewById(R.id.pass3).setVisibility(View.GONE);

        findViewById(R.id.pass_template).setVisibility(View.VISIBLE);
        findViewById(R.id.pass1_menu).setVisibility(View.VISIBLE);

        Button pass1_number = (Button) findViewById(R.id.pass_template);
        pass1_number.setText(pass1_text);
        TextView pass1_name = (TextView) findViewById(R.id.pass1_name);
        pass1_name.setText("Helen Smith");
        TextView pass1_email_view = (TextView) findViewById(R.id.pass1_email);
        pass1_email_view.setText(pass1_email);
        TextView pass1_status = (TextView) findViewById(R.id.pass1_status);
        if(pass1_paid){
            pass1_status.setText("válido (até 10/06/2023)");
            pass1_status.setBackgroundResource(R.drawable.edit_text_border_green);
        }
        else{
            pass1_status.setText("por pagar (23,30€)");
            pass1_status.setBackgroundResource(R.drawable.edit_text_border_yellow);
        }

    }

    // TODO better paying method
    public void pay(View view){
        TextView pass1_status = (TextView) findViewById(R.id.pass1_status);
        if(!pass1_paid){
            pass1_paid=true;
        }
        else{
            pass1(view);
        }
    }

}