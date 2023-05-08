package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Home_EN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_en);

        String[] stops = getResources().getStringArray(R.array.stops);

        AutoCompleteTextView origin = (AutoCompleteTextView) findViewById(R.id.origin);
        AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.destination);
        origin.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stops));
        destination.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stops));

        // show menu when clicked
        /*origin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                origin.showDropDown();
            }
        });*/
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


    // button swap language es
    public void swap_language_es(View view){
        Intent intent = new Intent(this, Home_ES.class);
        startActivity(intent);
    }

    // button swap language pt
    public void swap_language_pt(View view){
        Intent intent = new Intent(this, Home_PT.class);
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
        Intent intent = new Intent(this, Home_EN.class);
        startActivity(intent);
    }
    public void about_us(View view){
        Intent intent = new Intent(this, AboutUS_EN.class);
        startActivity(intent);
    }
    public void help(View view){
        Intent intent = new Intent(this, Help_EN.class);
        startActivity(intent);
    }
    public void settings(View view){
        Intent intent = new Intent(this, Settings_EN.class);
        startActivity(intent);
    }
}