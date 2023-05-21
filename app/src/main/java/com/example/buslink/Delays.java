package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Delays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delays);
        setOrigemDestino();
        getLastUpdateTime();

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


    // Colocar a origem e destino corretos
    public void setOrigemDestino(){
        //Ir buscar a origem e destino da HomePage
        Bundle extras = getIntent().getExtras();
        String origem = extras.getString("origem");
        String destino = extras.getString("destino");

        TextView originText = (TextView)findViewById(R.id.origem_);
        originText.setText(origem);
        TextView destinationText = (TextView)findViewById(R.id.destino_);
        destinationText.setText(destino);
    }


    //Show time of last update
    public void getLastUpdateTime(){
        Date currentTime = Calendar.getInstance().getTime();
        String horasMinutos = currentTime.toString().substring(11,16);

        TextView lastUpdate_text = (TextView)findViewById(R.id.last_updated);
        //String temp = "Ultima atualização: " + horasMinutos;
        String temp = "Ultima atualização: 08:00";
        lastUpdate_text.setText(temp);
    }


    //Login button handler
    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }


    // button swap handler (origin - destination)
    public void swap_locations(View view) {
        TextView origin = (TextView)findViewById(R.id.origem_);
        TextView destination = (TextView)findViewById(R.id.destino_);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();
        Home.origin = destinationText;
        Home.destination = originText;

        origin.setText(destinationText);
        destination.setText(originText);
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

    public void profile(View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void swap_language_en(View view){

        Home.currentLanguage = "en";

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_en));

        TextView header_partida = (TextView) findViewById(R.id.header_partida);
        header_partida.setText(getResources().getString(R.string.departure_en));

        TextView header_chegada = (TextView) findViewById(R.id.header_chegada);
        header_chegada.setText(getResources().getString(R.string.arrival_en));

        TextView header_duracao = (TextView) findViewById(R.id.header_duracao);
        header_duracao.setText(getResources().getString(R.string.duration_en));

        TextView header_custo = (TextView) findViewById(R.id.header_custo);
        header_custo.setText(getResources().getString(R.string.cost_en));

        TextView last_updated = (TextView) findViewById(R.id.last_updated);
        last_updated.setText(getResources().getString(R.string.last_update_en));

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

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_es));

        TextView header_partida = (TextView) findViewById(R.id.header_partida);
        header_partida.setText(getResources().getString(R.string.departure_es));

        TextView header_chegada = (TextView) findViewById(R.id.header_chegada);
        header_chegada.setText(getResources().getString(R.string.arrival_es));

        TextView header_duracao = (TextView) findViewById(R.id.header_duracao);
        header_duracao.setText(getResources().getString(R.string.duration_es));

        TextView header_custo = (TextView) findViewById(R.id.header_custo);
        header_custo.setText(getResources().getString(R.string.cost_es));

        TextView last_updated = (TextView) findViewById(R.id.last_updated);
        last_updated.setText(getResources().getString(R.string.last_update_es));

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

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_pt));

        TextView header_partida = (TextView) findViewById(R.id.header_partida);
        header_partida.setText(getResources().getString(R.string.departure_pt));

        TextView header_chegada = (TextView) findViewById(R.id.header_chegada);
        header_chegada.setText(getResources().getString(R.string.arrival_pt));

        TextView header_duracao = (TextView) findViewById(R.id.header_duracao);
        header_duracao.setText(getResources().getString(R.string.duration_pt));

        TextView header_custo = (TextView) findViewById(R.id.header_custo);
        header_custo.setText(getResources().getString(R.string.cost_pt));

        TextView last_updated = (TextView) findViewById(R.id.last_updated);
        last_updated.setText(getResources().getString(R.string.last_update_pt));

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