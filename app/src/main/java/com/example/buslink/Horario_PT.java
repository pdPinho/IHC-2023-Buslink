package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class Horario_PT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_pt2);
        setOrigemDestino();
    }

    // Colocar a origem e destino da HomePage
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

    //TODO Obrigar a que estejam preenchidos antes de prosseguir xD
    //TODO login page para não crashar

    // button swap handler (origin - destination)
    public void swap_locations(View view) {
        TextView origin = (TextView)findViewById(R.id.origem_);
        TextView destination = (TextView)findViewById(R.id.destino_);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();

        origin.setText(destinationText);
        destination.setText(originText);
    }

    //TODO tabela com o horário
    

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