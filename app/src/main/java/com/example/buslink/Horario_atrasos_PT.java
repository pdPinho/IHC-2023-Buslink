package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Horario_atrasos_PT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_atrasos_pt);
        setOrigemDestino();
        getLastUpdateTime();
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
        Intent intent = new Intent(this, Help_PT.class);
        startActivity(intent);
    }
    public void settings(View view){
        Intent intent = new Intent(this, Settings_PT.class);
        startActivity(intent);
    }
}