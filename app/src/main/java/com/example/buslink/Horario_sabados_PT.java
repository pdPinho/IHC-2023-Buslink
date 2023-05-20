package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class Horario_sabados_PT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_sabados_pt);
        setOrigemDestino();
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

        origin.setText(destinationText);
        destination.setText(originText);
    }


    // Day filter buttons handler
    public void verHorarioDiasUteis(View view){
        TextView origin = (TextView)findViewById(R.id.origem_);
        TextView destination = (TextView)findViewById(R.id.destino_);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();

        Intent intent = new Intent(this, Horario_PT.class);
        intent.putExtra("origem", originText);
        intent.putExtra("destino", destinationText);
        startActivity(intent);
    }
    public void verHorarioDomingo(View view){
        TextView origin = (TextView)findViewById(R.id.origem_);
        TextView destination = (TextView)findViewById(R.id.destino_);

        String originText = origin.getText().toString();
        String destinationText = destination.getText().toString();

        Intent intent = new Intent(this, Horario_domingo_PT.class);
        intent.putExtra("origem", originText);
        intent.putExtra("destino", destinationText);
        startActivity(intent);
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