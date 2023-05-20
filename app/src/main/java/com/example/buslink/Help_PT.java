package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Help_PT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_help_pt);

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
    public void settings(View view){
        Intent intent = new Intent(this, Settings_PT.class);
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

    // button swap language en
    public void swap_language_en(View view){

        Home.currentLanguage = "en";

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_en));

        Button lost_pass = (Button) findViewById(R.id.lost_pass);
        lost_pass.setText(getResources().getString(R.string.lost_pass_en));

        TextView actual_lost_pass_text = (TextView) findViewById(R.id.actual_lost_pass_text);
        actual_lost_pass_text.setText(getResources().getString(R.string.lost_pass_text_en));

        Button buy_pass_online = (Button) findViewById(R.id.buy_pass_online);
        buy_pass_online.setText(getResources().getString(R.string.buy_pass_en));

        TextView actual_buy_pass_online_text = (TextView) findViewById(R.id.actual_buy_pass_online_text);
        actual_buy_pass_online_text.setText(getResources().getString(R.string.buy_pass_text_en));

        Button register_account = (Button) findViewById(R.id.register_account);
        register_account.setText(getResources().getString(R.string.register_benefits_en));

        TextView actual_register_account_text = (TextView) findViewById(R.id.actual_register_account_text);
        actual_register_account_text.setText(getResources().getString(R.string.register_benefits_text_en));

        Button contact = (Button) findViewById(R.id.contact);
        contact.setText(getResources().getString(R.string.get_in_contact_en));

        TextView actual_contact_text = (TextView) findViewById(R.id.actual_contact_text);
        actual_contact_text.setText(getResources().getString(R.string.get_in_contact_text_en));

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

        Button lost_pass = (Button) findViewById(R.id.lost_pass);
        lost_pass.setText(getResources().getString(R.string.lost_pass_es));

        TextView actual_lost_pass_text = (TextView) findViewById(R.id.actual_lost_pass_text);
        actual_lost_pass_text.setText(getResources().getString(R.string.lost_pass_text_es));

        Button buy_pass_online = (Button) findViewById(R.id.buy_pass_online);
        buy_pass_online.setText(getResources().getString(R.string.buy_pass_es));

        TextView actual_buy_pass_online_text = (TextView) findViewById(R.id.actual_buy_pass_online_text);
        actual_buy_pass_online_text.setText(getResources().getString(R.string.buy_pass_text_es));

        Button register_account = (Button) findViewById(R.id.register_account);
        register_account.setText(getResources().getString(R.string.register_benefits_es));

        TextView actual_register_account_text = (TextView) findViewById(R.id.actual_register_account_text);
        actual_register_account_text.setText(getResources().getString(R.string.register_benefits_text_es));

        Button contact = (Button) findViewById(R.id.contact);
        contact.setText(getResources().getString(R.string.get_in_contact_es));

        TextView actual_contact_text = (TextView) findViewById(R.id.actual_contact_text);
        actual_contact_text.setText(getResources().getString(R.string.get_in_contact_text_es));

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

        Button lost_pass = (Button) findViewById(R.id.lost_pass);
        lost_pass.setText(getResources().getString(R.string.lost_pass_pt));

        TextView actual_lost_pass_text = (TextView) findViewById(R.id.actual_lost_pass_text);
        actual_lost_pass_text.setText(getResources().getString(R.string.lost_pass_text_pt));

        Button buy_pass_online = (Button) findViewById(R.id.buy_pass_online);
        buy_pass_online.setText(getResources().getString(R.string.buy_pass_pt));

        TextView actual_buy_pass_online_text = (TextView) findViewById(R.id.actual_buy_pass_online_text);
        actual_buy_pass_online_text.setText(getResources().getString(R.string.buy_pass_text_pt));

        Button register_account = (Button) findViewById(R.id.register_account);
        register_account.setText(getResources().getString(R.string.register_benefits_pt));

        TextView actual_register_account_text = (TextView) findViewById(R.id.actual_register_account_text);
        actual_register_account_text.setText(getResources().getString(R.string.register_benefits_text_pt));

        Button contact = (Button) findViewById(R.id.contact);
        contact.setText(getResources().getString(R.string.get_in_contact_pt));

        TextView actual_contact_text = (TextView) findViewById(R.id.actual_contact_text);
        actual_contact_text.setText(getResources().getString(R.string.get_in_contact_text_pt));

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