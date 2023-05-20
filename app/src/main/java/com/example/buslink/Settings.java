package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        boolean nightMode = isNightModeActive(getBaseContext());

        if(nightMode) {
            RadioButton radioItemDark = (RadioButton)findViewById(R.id.BlackTheme);
            radioItemDark.setChecked(true);
        }
        else if(!nightMode){
            RadioButton radioItemLight = (RadioButton)findViewById(R.id.WhiteTheme);
            radioItemLight.setChecked(true);
        }

        Button login_button = findViewById(R.id.login_button);
        ImageButton profile_button = findViewById(R.id.profile);

        if(!Login.logged_in.isEmpty()){
            login_button.setVisibility(View.GONE);
            profile_button.setVisibility(View.VISIBLE);
        }
        else{
            login_button.setVisibility(View.VISIBLE);
            profile_button.setVisibility(View.GONE);
        }

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

        Button login_button = findViewById(R.id.login_button);
        ImageButton profile_button = findViewById(R.id.profile);

        if(!Login.logged_in.isEmpty()){
            login_button.setVisibility(View.GONE);
            profile_button.setVisibility(View.VISIBLE);
        }
        else{
            login_button.setVisibility(View.VISIBLE);
            profile_button.setVisibility(View.GONE);
        }

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

    // check if dark or light theme
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
    public void swap_language_en(View view){

        Home.currentLanguage = "en";

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_en));

        RadioButton WhiteTheme = (RadioButton) findViewById(R.id.WhiteTheme);
        WhiteTheme.setText(getResources().getString(R.string.light_en));

        RadioButton BlackTheme = (RadioButton) findViewById(R.id.BlackTheme);
        BlackTheme.setText(getResources().getString(R.string.dark_en));

        TextView home_option = (TextView) findViewById(R.id.home_option);
        home_option.setText(getResources().getString(R.string.home_en));

        TextView about_us_option = (TextView) findViewById(R.id.about_us_option);
        about_us_option.setText(getResources().getString(R.string.about_us_en));

        TextView help_option = (TextView) findViewById(R.id.help_option);
        help_option.setText(getResources().getString(R.string.help_en));

        TextView definitions_option = (TextView) findViewById(R.id.definitions_option);
        definitions_option.setText(getResources().getString(R.string.settings_en));

        hide_language_options(view);

        findViewById(R.id.current_language_pt).setVisibility(View.GONE);
        findViewById(R.id.current_language_en).setVisibility(View.VISIBLE);
        findViewById(R.id.current_language_es).setVisibility(View.GONE);
    }

    // button swap language es
    public void swap_language_es(View view){

        Home.currentLanguage = "es";

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_es));

        RadioButton WhiteTheme = (RadioButton) findViewById(R.id.WhiteTheme);
        WhiteTheme.setText(getResources().getString(R.string.light_es));

        RadioButton BlackTheme = (RadioButton) findViewById(R.id.BlackTheme);
        BlackTheme.setText(getResources().getString(R.string.dark_es));

        TextView home_option = (TextView) findViewById(R.id.home_option);
        home_option.setText(getResources().getString(R.string.home_es));

        TextView about_us_option = (TextView) findViewById(R.id.about_us_option);
        about_us_option.setText(getResources().getString(R.string.about_us_es));

        TextView help_option = (TextView) findViewById(R.id.help_option);
        help_option.setText(getResources().getString(R.string.help_es));

        TextView definitions_option = (TextView) findViewById(R.id.definitions_option);
        definitions_option.setText(getResources().getString(R.string.settings_es));

        hide_language_options(view);

        findViewById(R.id.current_language_pt).setVisibility(View.GONE);
        findViewById(R.id.current_language_en).setVisibility(View.GONE);
        findViewById(R.id.current_language_es).setVisibility(View.VISIBLE);
    }

    public void swap_language_pt(View view){

        Home.currentLanguage = "pt";

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_pt));

        RadioButton WhiteTheme = (RadioButton) findViewById(R.id.WhiteTheme);
        WhiteTheme.setText(getResources().getString(R.string.light_pt));

        RadioButton BlackTheme = (RadioButton) findViewById(R.id.BlackTheme);
        BlackTheme.setText(getResources().getString(R.string.dark_pt));

        TextView home_option = (TextView) findViewById(R.id.home_option);
        home_option.setText(getResources().getString(R.string.home_pt));

        TextView about_us_option = (TextView) findViewById(R.id.about_us_option);
        about_us_option.setText(getResources().getString(R.string.about_us_pt));

        TextView help_option = (TextView) findViewById(R.id.help_option);
        help_option.setText(getResources().getString(R.string.help_pt));

        TextView definitions_option = (TextView) findViewById(R.id.definitions_option);
        definitions_option.setText(getResources().getString(R.string.settings_pt));

        hide_language_options(view);
        findViewById(R.id.current_language_pt).setVisibility(View.VISIBLE);
        findViewById(R.id.current_language_en).setVisibility(View.GONE);
        findViewById(R.id.current_language_es).setVisibility(View.GONE);
    }

    // button show language options
    public void show_language_options(View view){
        findViewById(R.id.current_language_pt).setVisibility(View.GONE);
        findViewById(R.id.current_language_en).setVisibility(View.GONE);
        findViewById(R.id.current_language_es).setVisibility(View.GONE);

        findViewById(R.id.table_select_language).setVisibility(View.VISIBLE);
    }

    // button hide language options
    public void hide_language_options(View view){
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
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
    public void settings(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void profile(View view){
        Intent intent = new Intent(this, Profile.class);
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