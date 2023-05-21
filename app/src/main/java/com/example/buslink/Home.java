package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class Home extends AppCompatActivity {

    public static String origin = "";
    public static String destination = "";
    private static String[] stops;
    public static String currentLanguage = "pt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        stops = getResources().getStringArray(R.array.stops);

        AutoCompleteTextView origin = (AutoCompleteTextView) findViewById(R.id.origin);
        AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.destination);
        origin.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stops));
        destination.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stops));

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

        setOrigemDestino();

        if(currentLanguage.equals("pt")){
            swap_language_pt(findViewById(android.R.id.content));
        }
        else if(currentLanguage.equals("es")){
            swap_language_es(findViewById(android.R.id.content));
        }
        else if(currentLanguage.equals("en")){
            swap_language_en(findViewById(android.R.id.content));
        }
    }

    // Colocar a origem e destino corretos
    public void setOrigemDestino(){
        TextView originText = (TextView) findViewById(R.id.origin);
        originText.setText(origin);
        TextView destinationText = (TextView) findViewById(R.id.destination);
        destinationText.setText(destination);
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

        if(currentLanguage.equals("pt")){
            swap_language_pt(findViewById(android.R.id.content));
        }
        else if(currentLanguage.equals("es")){
            swap_language_es(findViewById(android.R.id.content));
        }
        else if(currentLanguage.equals("en")){
            swap_language_en(findViewById(android.R.id.content));
        }
    }

    // button swap handler (origin - destination)
    public void swap_locations(View view) {
        AutoCompleteTextView origin = (AutoCompleteTextView)findViewById(R.id.origin);
        AutoCompleteTextView destination = (AutoCompleteTextView)findViewById(R.id.destination);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();

        origin.setText(destinationText);
        destination.setText(originText);
    }

    // button swap language en
    public void swap_language_en(View view){

        Home.currentLanguage = "en";

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setText(getResources().getString(R.string.log_in_en));

        TextView origem_text = (TextView) findViewById(R.id.origem_text);
        origem_text.setText(getResources().getString(R.string.from_en));

        AutoCompleteTextView origin = (AutoCompleteTextView) findViewById(R.id.origin);
        origin.setHint(getResources().getString(R.string.from_where_en));

        TextView destino_text = (TextView) findViewById(R.id.destino_text);
        destino_text.setText(getResources().getString(R.string.to_en));

        AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.destination);
        destination.setHint(getResources().getString(R.string.to_where_en));

        Button horarios = (Button) findViewById(R.id.horarios);
        horarios.setText(getResources().getString(R.string.timetable_en));

        Button proximos_autocarros = (Button) findViewById(R.id.proximos_autocarros);
        proximos_autocarros.setText(getResources().getString(R.string.nextbus_en));

        Button ver_mapa = (Button) findViewById(R.id.ver_mapa);
        ver_mapa.setText(getResources().getString(R.string.map_en));

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

        TextView origem_text = (TextView) findViewById(R.id.origem_text);
        origem_text.setText(getResources().getString(R.string.from_es));

        AutoCompleteTextView origin = (AutoCompleteTextView) findViewById(R.id.origin);
        origin.setHint(getResources().getString(R.string.from_where_es));

        TextView destino_text = (TextView) findViewById(R.id.destino_text);
        destino_text.setText(getResources().getString(R.string.to_es));

        AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.destination);
        destination.setHint(getResources().getString(R.string.to_where_es));

        Button horarios = (Button) findViewById(R.id.horarios);
        horarios.setText(getResources().getString(R.string.timetable_es));

        Button proximos_autocarros = (Button) findViewById(R.id.proximos_autocarros);
        proximos_autocarros.setText(getResources().getString(R.string.nextbus_es));

        Button ver_mapa = (Button) findViewById(R.id.ver_mapa);
        ver_mapa.setText(getResources().getString(R.string.map_es));

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

        TextView origem_text = (TextView) findViewById(R.id.origem_text);
        origem_text.setText(getResources().getString(R.string.from_pt));

        AutoCompleteTextView origin = (AutoCompleteTextView) findViewById(R.id.origin);
        origin.setHint(getResources().getString(R.string.from_where_pt));

        TextView destino_text = (TextView) findViewById(R.id.destino_text);
        destino_text.setText(getResources().getString(R.string.to_pt));

        AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.destination);
        destination.setHint(getResources().getString(R.string.to_where_pt));

        Button horarios = (Button) findViewById(R.id.horarios);
        horarios.setText(getResources().getString(R.string.timetable_pt));

        Button proximos_autocarros = (Button) findViewById(R.id.proximos_autocarros);
        proximos_autocarros.setText(getResources().getString(R.string.nextbus_pt));

        Button ver_mapa = (Button) findViewById(R.id.ver_mapa);
        ver_mapa.setText(getResources().getString(R.string.map_pt));

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


    // Horario button handler
    public void verHorario(View view){
        AutoCompleteTextView origin = (AutoCompleteTextView)findViewById(R.id.origin);
        AutoCompleteTextView destination = (AutoCompleteTextView)findViewById(R.id.destination);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();
        this.origin = originText;
        this.destination = destinationText;



        if (!originText.isEmpty() && !destinationText.isEmpty() && !(destinationText == originText) && Arrays.asList(stops).contains(originText.toUpperCase()) && Arrays.asList(stops).contains(destinationText.toUpperCase())) {
            Intent intent = new Intent(this, Timetables.class);
            intent.putExtra("origem", originText.toUpperCase());
            intent.putExtra("destino", destinationText.toUpperCase());
            startActivity(intent);
        }
    }

    // Proximos Autocarros button handler
    public void verProximosAutocarros(View view){
        AutoCompleteTextView origin = (AutoCompleteTextView)findViewById(R.id.origin);
        AutoCompleteTextView destination = (AutoCompleteTextView)findViewById(R.id.destination);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();
        this.origin = originText;
        this.destination = destinationText;

        if (!originText.isEmpty() && !destinationText.isEmpty() && !(destinationText == originText) && Arrays.asList(stops).contains(originText.toUpperCase()) && Arrays.asList(stops).contains(destinationText.toUpperCase())) {
            Intent intent = new Intent(this, Delays.class);
            intent.putExtra("origem", originText.toUpperCase());
            intent.putExtra("destino", destinationText.toUpperCase());
            startActivity(intent);
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

    public void map(View view){
        AutoCompleteTextView origin = (AutoCompleteTextView)findViewById(R.id.origin);
        AutoCompleteTextView destination = (AutoCompleteTextView)findViewById(R.id.destination);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();
        this.origin = originText;
        this.destination = destinationText;

        if (!originText.isEmpty() && !destinationText.isEmpty()  && !(destinationText == originText) && Arrays.asList(stops).contains(originText.toUpperCase()) && Arrays.asList(stops).contains(destinationText.toUpperCase())) {
            Intent intent = new Intent(this, Map.class);
            intent.putExtra("origem", originText.toUpperCase());
            intent.putExtra("destino", destinationText.toUpperCase());
            startActivity(intent);
        }
    }
}