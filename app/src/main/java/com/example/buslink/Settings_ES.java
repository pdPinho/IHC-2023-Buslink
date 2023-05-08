package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Settings_ES extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_es);

        boolean nightMode = isNightModeActive(getBaseContext());

        if(nightMode) {
            RadioButton radioItemDark = (RadioButton)findViewById(R.id.BlackTheme);
            radioItemDark.setChecked(true);
        }
        else if(!nightMode){
            RadioButton radioItemLight = (RadioButton)findViewById(R.id.WhiteTheme);
            radioItemLight.setChecked(true);
        }
    }

    public static boolean isNightModeActive(Context context) {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        if (defaultNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            return true;
        }
        if (defaultNightMode == AppCompatDelegate.MODE_NIGHT_NO) {
            return false;
        }

        int currentNightMode = context.getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                return false;
            case Configuration.UI_MODE_NIGHT_YES:
                return true;
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                return false;
        }
        return false;
    }

    // button swap language en
    public void swap_language_pt(View view){
        Intent intent = new Intent(this, Settings_PT.class);
        startActivity(intent);
    }

    // button swap language es
    public void swap_language_en(View view){
        Intent intent = new Intent(this, Settings_EN.class);
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
        Intent intent = new Intent(this, Home_ES.class);
        startActivity(intent);
    }
    public void about_us(View view){
        Intent intent = new Intent(this, AboutUS_ES.class);
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


    // Theme button section
    public void swapToLight(View view){
        RadioButton radioItemLight = (RadioButton)findViewById(R.id.WhiteTheme);

        if (radioItemLight.isChecked())
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public void swapToDark(View view){
        RadioButton radioItemDark = (RadioButton)findViewById(R.id.BlackTheme);

        if (radioItemDark.isChecked())
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }
}