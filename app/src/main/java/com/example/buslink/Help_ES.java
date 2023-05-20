package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class Help_ES extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_es);
    }

    // button swap language en
    public void swap_language_en(View view){
        Intent intent = new Intent(this, Help_EN.class);
        startActivity(intent);
    }

    // button swap language pt
    public void swap_language_pt(View view){
        Intent intent = new Intent(this, Help_PT.class);
        startActivity(intent);
    }

    // button show language options
    public void show_language_options(View view){
        findViewById(R.id.current_language).setVisibility(View.INVISIBLE);
        findViewById(R.id.table_select_language).setVisibility(View.VISIBLE);
    }

    // button hide language options
    public void hide_language_options(View view){
        findViewById(R.id.current_language).setVisibility(View.VISIBLE);
        findViewById(R.id.table_select_language).setVisibility(View.INVISIBLE);
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
        Intent intent = new Intent(this, Help_ES.class);
        startActivity(intent);
    }
    public void settings(View view){
        Intent intent = new Intent(this, Settings_ES.class);
        startActivity(intent);
    }


    // FAQ button section
    public void lost_Pass(View view){
        View lost_pass_text = findViewById(R.id.lost_pass_text);

        if(lost_pass_text.getVisibility() != View.VISIBLE) {
            findViewById(R.id.buy_pass_online).setVisibility(View.GONE);
            findViewById(R.id.register_account).setVisibility(View.GONE);
            findViewById(R.id.contact).setVisibility(View.GONE);
            lost_pass_text.setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.buy_pass_online).setVisibility(View.VISIBLE);
            findViewById(R.id.register_account).setVisibility(View.VISIBLE);
            findViewById(R.id.contact).setVisibility(View.VISIBLE);
            lost_pass_text.setVisibility(View.GONE);
        }

    }

    public void buy_Online(View view){
        View buy_online_text = findViewById(R.id.buy_pass_online_text);

        if(buy_online_text.getVisibility() != View.VISIBLE) {
            findViewById(R.id.lost_pass).setVisibility(View.GONE);
            findViewById(R.id.register_account).setVisibility(View.GONE);
            findViewById(R.id.contact).setVisibility(View.GONE);
            buy_online_text.setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.lost_pass).setVisibility(View.VISIBLE);
            findViewById(R.id.register_account).setVisibility(View.VISIBLE);
            findViewById(R.id.contact).setVisibility(View.VISIBLE);
            buy_online_text.setVisibility(View.GONE);
        }
    }

    public void register_Account(View view){
        View register_text = findViewById(R.id.register_account_text);

        if(register_text.getVisibility() != View.VISIBLE) {
            findViewById(R.id.buy_pass_online).setVisibility(View.GONE);
            findViewById(R.id.lost_pass).setVisibility(View.GONE);
            findViewById(R.id.contact).setVisibility(View.GONE);
            register_text.setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.buy_pass_online).setVisibility(View.VISIBLE);
            findViewById(R.id.lost_pass).setVisibility(View.VISIBLE);
            findViewById(R.id.contact).setVisibility(View.VISIBLE);
            register_text.setVisibility(View.GONE);
        }
    }

    public void contact(View view){
        View contact_text = findViewById(R.id.contact_text);

        if(contact_text.getVisibility() != View.VISIBLE) {
            findViewById(R.id.buy_pass_online).setVisibility(View.GONE);
            findViewById(R.id.register_account).setVisibility(View.GONE);
            findViewById(R.id.lost_pass).setVisibility(View.GONE);
            contact_text.setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.buy_pass_online).setVisibility(View.VISIBLE);
            findViewById(R.id.register_account).setVisibility(View.VISIBLE);
            findViewById(R.id.lost_pass).setVisibility(View.VISIBLE);
            contact_text.setVisibility(View.GONE);
        }
    }
}