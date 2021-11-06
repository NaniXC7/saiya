package com.example.saiyagym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Rutinas extends AppCompatActivity {

    Spinner combodias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);

        combodias = findViewById(R.id.spinerdias);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_dias,
                android.R.layout.simple_spinner_item);
    }

    public void regresar(View view){

        Intent i = new Intent(this, Coaching.class);
        startActivity(i);

    }
}