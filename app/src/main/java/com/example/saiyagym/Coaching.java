package com.example.saiyagym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class Coaching extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coaching2);
    }

    public void registroavance(View view){

        Intent i = new Intent(this, Avances.class);
        startActivity(i);

    }

    public void regresar1(View view){

        Intent i = new Intent(this, VerAvances.class);
        startActivity(i);

    }

    public void rutinas(View view){

        Intent i = new Intent(getApplicationContext(), Ruti.class);
        startActivity(i);

    }
}