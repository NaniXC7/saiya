package com.example.saiyagym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Ruti extends AppCompatActivity {

    Button lunes, martes, miercoles, jueves, viernes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruti);

        lunes = findViewById(R.id.Lunes);
        martes = findViewById(R.id.Martes);
        miercoles = findViewById(R.id.Miercoles);
        jueves = findViewById(R.id.Jueves);
        viernes = findViewById(R.id.Viernes);



    }

    public void regresar(View view){

        Intent i = new Intent(this, Coaching.class);
        startActivity(i);

    }

}