package com.example.saiyagym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Coaching extends AppCompatActivity {

    Button cerrarsesion;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coaching2);

        cerrarsesion = findViewById(R.id.cerrarsesion);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), IniciarSesionActivity.class));
                finish();

                Toast.makeText(getApplicationContext(), "Sesion Finalizada", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "El dolor que sientes hoy es la fuerza que tendrás mañana", Toast.LENGTH_SHORT).show();

            }
        });
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

    public void nutricion(View view){

        Intent i = new Intent(getApplicationContext(), Nutricion.class);
        startActivity(i);

    }
}