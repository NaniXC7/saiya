package com.example.saiyagym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Avances extends AppCompatActivity {

    private EditText brazo, pecho, abs, pierna, gluteos, pantorria, pesoactual;
    Button btnenvi;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avances);

        brazo = findViewById(R.id.brazo);
        pecho = findViewById(R.id.pecho);
        abs = findViewById(R.id.abs);
        pierna = findViewById(R.id.pierna);
        gluteos = findViewById(R.id.gluteos);
        pantorria = findViewById(R.id.pantorria);
        pesoactual = findViewById(R.id.pesoactual);
        btnenvi = findViewById(R.id.btnenvi);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnenvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Brazo, Pecho, Abdomen, Pierna, Gluteo, Pantorrilla, PesoActual;

                Brazo = brazo.getText().toString().trim();
                Abdomen = abs.getText().toString().trim();
                Pecho = pecho.getText().toString().trim();
                Pierna = pierna.getText().toString().trim();
                Gluteo = gluteos.getText().toString().trim();
                Pantorrilla = pantorria.getText().toString().trim();
                PesoActual = pesoactual.getText().toString().trim();


                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map3 = new HashMap<>();
                map3.put("Mbrazo", Brazo);
                map3.put("Mpecho", Pecho);
                map3.put("Mabdomen", Abdomen);
                map3.put("Mpierna", Pierna);
                map3.put("Mgluteo", Gluteo);
                map3.put("Mpantorrilla", Pantorrilla);
                map3.put("Mpesoactual", PesoActual);

                mDatabase.child("Users").child(iD).updateChildren(map3);

                Toast.makeText(getApplicationContext(), "Medidas Actualizadas Correctamente", Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void regresar(View view){

        Intent i = new Intent(this, Coaching.class);
        startActivity(i);

    }
}