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

public class PrimerasMedidasUser extends AppCompatActivity {

    private EditText mbrazo, mpecho, mabs, mpierna, mgluteos, mpantorria, pesoinicial, pesofinal;
    Button btnregistrarse;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeras_medidas_user);

        mbrazo = findViewById(R.id.mbrazo);
        mpecho = findViewById(R.id.mpecho);
        mabs = findViewById(R.id.mabs);
        mpierna = findViewById(R.id.mpierna);
        mgluteos = findViewById(R.id.mgluteos);
        mpantorria = findViewById(R.id.mpantorria);
        pesoinicial = findViewById(R.id.pesoinicial);
        pesofinal = findViewById(R.id.pesofinal);
        btnregistrarse = findViewById(R.id.btnregistrarse);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Brazo, Pecho, Abdomen, Pierna, Gluteo, Pantorrilla, PesoInicial, PesoMeta;

                Brazo = mbrazo.getText().toString().trim();
                Abdomen = mabs.getText().toString().trim();
                Pecho = mpecho.getText().toString().trim();
                Pierna = mpierna.getText().toString().trim();
                Gluteo = mgluteos.getText().toString().trim();
                Pantorrilla = mpantorria.getText().toString().trim();
                PesoInicial = pesoinicial.getText().toString().trim();
                PesoMeta = pesofinal.getText().toString().trim();


                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map2 = new HashMap<>();
                map2.put("Mbrazo", Brazo);
                map2.put("Mpecho", Pecho);
                map2.put("Mabdomen", Abdomen);
                map2.put("Mpierna", Pierna);
                map2.put("Mgluteo", Gluteo);
                map2.put("Mpantorrilla", Pantorrilla);
                map2.put("MpesoInicial", PesoInicial);
                map2.put("MpesoMeta", PesoMeta);

                mDatabase.child("Users").child(iD).updateChildren(map2);

                Toast.makeText(getApplicationContext(), "Cuenta Registrada Exitosamente", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), IniciarSesionActivity.class);
                startActivity(i);


            }
        });

    }
}