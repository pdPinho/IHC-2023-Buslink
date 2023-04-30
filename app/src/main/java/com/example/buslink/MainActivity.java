package com.example.buslink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}