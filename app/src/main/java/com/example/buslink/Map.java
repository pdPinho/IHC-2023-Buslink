package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setOrigemDestino();
    }

    // Colocar a origem e destino corretos
    public void setOrigemDestino(){
        //Ir buscar a origem e destino da HomePage
        Bundle extras = getIntent().getExtras();
        String origem = extras.getString("origem");
        String destino = extras.getString("destino");

        TextView originText = (TextView)findViewById(R.id.origin);
        originText.setText(origem);
        TextView destinationText = (TextView)findViewById(R.id.destination);
        destinationText.setText(destino);
    }

    // button swap language en
    public void swap_language_en(View view){
        Intent intent = new Intent(this, Home_EN.class);
        startActivity(intent);
    }

    // button swap language es
    public void swap_language_es(View view){
        Intent intent = new Intent(this, Home_ES.class);
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

    //Login button handler
    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    // button swap handler (origin - destination)
    public void swap_locations(View view) {
        TextView origin = (TextView)findViewById(R.id.origin);
        TextView destination = (TextView)findViewById(R.id.destination);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();
        Home_PT.origin = destinationText;
        Home_PT.destination = originText;

        origin.setText(destinationText);
        destination.setText(originText);

        ImageView map_org = (ImageView)findViewById(R.id.map_original);
        ImageView map_swap = (ImageView)findViewById(R.id.map_swap);

        if(map_org.getVisibility() == View.VISIBLE) {
            map_org.setVisibility(View.GONE);
            map_swap.setVisibility(View.VISIBLE);
        }
        else{
            map_org.setVisibility(View.VISIBLE);
            map_swap.setVisibility(View.GONE);
        }
    }

    // footer buttons section
    public void home(View view){
        Intent intent = new Intent(this, Home_PT.class);
        startActivity(intent);
    }
    public void about_us(View view){
        Intent intent = new Intent(this, AboutUS_PT.class);
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
}