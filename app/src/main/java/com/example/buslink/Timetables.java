package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Timetables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetables);
        setOrigemDestino();

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


    // Day filter buttons handler
    public void verHorarioSabado(View view) {

        findViewById(R.id.tabela_dias_uteis).setVisibility(View.GONE);
        findViewById(R.id.tabela_domingos).setVisibility(View.GONE);
        findViewById(R.id.tabela_sabados).setVisibility(View.VISIBLE);

        Button dias_uteis = (Button) findViewById(R.id.dias_uteis);
        dias_uteis.setBackgroundResource(R.drawable.button);

        Button domingos = (Button) findViewById(R.id.domingos);
        domingos.setBackgroundResource(R.drawable.button);

        Button sabados = (Button) findViewById(R.id.sabados);
        sabados.setBackgroundResource(R.drawable.button_darker);

    }
    public void verHorarioDomingo(View view){
        findViewById(R.id.tabela_dias_uteis).setVisibility(View.GONE);
        findViewById(R.id.tabela_domingos).setVisibility(View.VISIBLE);
        findViewById(R.id.tabela_sabados).setVisibility(View.GONE);

        Button dias_uteis = (Button) findViewById(R.id.dias_uteis);
        dias_uteis.setBackgroundResource(R.drawable.button);

        Button domingos = (Button) findViewById(R.id.domingos);
        domingos.setBackgroundResource(R.drawable.button_darker);

        Button sabados = (Button) findViewById(R.id.sabados);
        sabados.setBackgroundResource(R.drawable.button);
    }

    public void verHorarioDiasUteis(View view){
        findViewById(R.id.tabela_dias_uteis).setVisibility(View.VISIBLE);
        findViewById(R.id.tabela_domingos).setVisibility(View.GONE);
        findViewById(R.id.tabela_sabados).setVisibility(View.GONE);

        Button dias_uteis = (Button) findViewById(R.id.dias_uteis);
        dias_uteis.setBackgroundResource(R.drawable.button_darker);

        Button domingos = (Button) findViewById(R.id.domingos);
        domingos.setBackgroundResource(R.drawable.button);

        Button sabados = (Button) findViewById(R.id.sabados);
        sabados.setBackgroundResource(R.drawable.button);
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

    // button swap language en
    public void swap_language_en(View view){

        Home.currentLanguage = "en";

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_en));

        Button dias_uteis = (Button) findViewById(R.id.dias_uteis);
        dias_uteis.setText(getResources().getString(R.string.business_days_en));

        Button sabados = (Button) findViewById(R.id.sabados);
        sabados.setText(getResources().getString(R.string.saturdays_en));

        Button domingos = (Button) findViewById(R.id.domingos);
        domingos.setText(getResources().getString(R.string.sundays_en));

        TextView partida_dias_uteis = (TextView) findViewById(R.id.partida_dias_uteis);
        partida_dias_uteis.setText(getResources().getString(R.string.departure_en));
        TextView partida_sabados = (TextView) findViewById(R.id.partida_sabados);
        partida_sabados.setText(getResources().getString(R.string.departure_en));
        TextView partida_domingos = (TextView) findViewById(R.id.partida_domingos);
        partida_domingos.setText(getResources().getString(R.string.departure_en));

        TextView chegada_dias_uteis = (TextView) findViewById(R.id.chegada_dias_uteis);
        chegada_dias_uteis.setText(getResources().getString(R.string.arrival_en));
        TextView chegada_sabados = (TextView) findViewById(R.id.chegada_sabados);
        chegada_sabados.setText(getResources().getString(R.string.arrival_en));
        TextView chegada_domingos = (TextView) findViewById(R.id.chegada_domingos);
        chegada_domingos.setText(getResources().getString(R.string.arrival_en));

        TextView duracao_dias_uteis = (TextView) findViewById(R.id.duracao_dias_uteis);
        duracao_dias_uteis.setText(getResources().getString(R.string.duration_en));
        TextView duracao_sabados = (TextView) findViewById(R.id.duracao_sabados);
        duracao_sabados.setText(getResources().getString(R.string.duration_en));
        TextView duracao_domingos = (TextView) findViewById(R.id.duracao_domingos);
        duracao_domingos.setText(getResources().getString(R.string.duration_en));

        TextView custo_dias_uteis = (TextView) findViewById(R.id.custo_dias_uteis);
        custo_dias_uteis.setText(getResources().getString(R.string.cost_en));
        TextView custo_sabados = (TextView) findViewById(R.id.custo_sabados);
        custo_sabados.setText(getResources().getString(R.string.cost_en));
        TextView custo_domingos = (TextView) findViewById(R.id.custo_domingos);
        custo_domingos.setText(getResources().getString(R.string.cost_en));

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

        Button dias_uteis = (Button) findViewById(R.id.dias_uteis);
        dias_uteis.setText(getResources().getString(R.string.business_days_es));

        Button sabados = (Button) findViewById(R.id.sabados);
        sabados.setText(getResources().getString(R.string.saturdays_es));

        Button domingos = (Button) findViewById(R.id.domingos);
        domingos.setText(getResources().getString(R.string.sundays_es));

        TextView partida_dias_uteis = (TextView) findViewById(R.id.partida_dias_uteis);
        partida_dias_uteis.setText(getResources().getString(R.string.departure_es));
        TextView partida_sabados = (TextView) findViewById(R.id.partida_sabados);
        partida_sabados.setText(getResources().getString(R.string.departure_es));
        TextView partida_domingos = (TextView) findViewById(R.id.partida_domingos);
        partida_domingos.setText(getResources().getString(R.string.departure_es));

        TextView chegada_dias_uteis = (TextView) findViewById(R.id.chegada_dias_uteis);
        chegada_dias_uteis.setText(getResources().getString(R.string.arrival_es));
        TextView chegada_sabados = (TextView) findViewById(R.id.chegada_sabados);
        chegada_sabados.setText(getResources().getString(R.string.arrival_es));
        TextView chegada_domingos = (TextView) findViewById(R.id.chegada_domingos);
        chegada_domingos.setText(getResources().getString(R.string.arrival_es));

        TextView duracao_dias_uteis = (TextView) findViewById(R.id.duracao_dias_uteis);
        duracao_dias_uteis.setText(getResources().getString(R.string.duration_es));
        TextView duracao_sabados = (TextView) findViewById(R.id.duracao_sabados);
        duracao_sabados.setText(getResources().getString(R.string.duration_es));
        TextView duracao_domingos = (TextView) findViewById(R.id.duracao_domingos);
        duracao_domingos.setText(getResources().getString(R.string.duration_es));

        TextView custo_dias_uteis = (TextView) findViewById(R.id.custo_dias_uteis);
        custo_dias_uteis.setText(getResources().getString(R.string.cost_es));
        TextView custo_sabados = (TextView) findViewById(R.id.custo_sabados);
        custo_sabados.setText(getResources().getString(R.string.cost_es));
        TextView custo_domingos = (TextView) findViewById(R.id.custo_domingos);
        custo_domingos.setText(getResources().getString(R.string.cost_es));

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

        Button dias_uteis = (Button) findViewById(R.id.dias_uteis);
        dias_uteis.setText(getResources().getString(R.string.business_days_pt));

        Button sabados = (Button) findViewById(R.id.sabados);
        sabados.setText(getResources().getString(R.string.saturdays_pt));

        Button domingos = (Button) findViewById(R.id.domingos);
        domingos.setText(getResources().getString(R.string.sundays_pt));

        TextView partida_dias_uteis = (TextView) findViewById(R.id.partida_dias_uteis);
        partida_dias_uteis.setText(getResources().getString(R.string.departure_pt));
        TextView partida_sabados = (TextView) findViewById(R.id.partida_sabados);
        partida_sabados.setText(getResources().getString(R.string.departure_pt));
        TextView partida_domingos = (TextView) findViewById(R.id.partida_domingos);
        partida_domingos.setText(getResources().getString(R.string.departure_pt));

        TextView chegada_dias_uteis = (TextView) findViewById(R.id.chegada_dias_uteis);
        chegada_dias_uteis.setText(getResources().getString(R.string.arrival_pt));
        TextView chegada_sabados = (TextView) findViewById(R.id.chegada_sabados);
        chegada_sabados.setText(getResources().getString(R.string.arrival_pt));
        TextView chegada_domingos = (TextView) findViewById(R.id.chegada_domingos);
        chegada_domingos.setText(getResources().getString(R.string.arrival_pt));

        TextView duracao_dias_uteis = (TextView) findViewById(R.id.duracao_dias_uteis);
        duracao_dias_uteis.setText(getResources().getString(R.string.duration_pt));
        TextView duracao_sabados = (TextView) findViewById(R.id.duracao_sabados);
        duracao_sabados.setText(getResources().getString(R.string.duration_pt));
        TextView duracao_domingos = (TextView) findViewById(R.id.duracao_domingos);
        duracao_domingos.setText(getResources().getString(R.string.duration_pt));

        TextView custo_dias_uteis = (TextView) findViewById(R.id.custo_dias_uteis);
        custo_dias_uteis.setText(getResources().getString(R.string.cost_pt));
        TextView custo_sabados = (TextView) findViewById(R.id.custo_sabados);
        custo_sabados.setText(getResources().getString(R.string.cost_pt));
        TextView custo_domingos = (TextView) findViewById(R.id.custo_domingos);
        custo_domingos.setText(getResources().getString(R.string.cost_pt));

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