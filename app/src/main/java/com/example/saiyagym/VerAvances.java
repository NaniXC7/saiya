package com.example.saiyagym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VerAvances extends AppCompatActivity {

    private TextView brazo1, pecho1, abs1, pierna1, gluteos1, pantorria1, pesoactual1;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_avances);

        brazo1 =  findViewById(R.id.brazo1);
        pecho1 =  findViewById(R.id.pecho1);
        abs1 =  findViewById(R.id.abs1);
        pierna1 =  findViewById(R.id.pierna1);
        gluteos1 =  findViewById(R.id.gluteos1);
        pantorria1 =  findViewById(R.id.pantorria1);
        pesoactual1 =  findViewById(R.id.pesoactual1);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        getUserInfo();

    }



    private void getUserInfo(){
        String id=mAuth.getCurrentUser().getUid();

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String Brazo, Pecho, Abs, Pierna, Gluteos, Pantorrilla, PesoActual;

                    Brazo = snapshot.child("Mbrazo").getValue().toString();
                    Pecho = snapshot.child("Mpecho").getValue().toString();
                    Abs = snapshot.child("Mabdomen").getValue().toString();
                    Pierna = snapshot.child("Mpierna").getValue().toString();
                    Gluteos = snapshot.child("Mgluteo").getValue().toString();
                    Pantorrilla = snapshot.child("Mpantorrilla").getValue().toString();
                    PesoActual = snapshot.child("Mpesoactual").getValue().toString();



                    brazo1.setText(Brazo.toUpperCase());
                    pecho1.setText(Pecho.toUpperCase());
                    abs1.setText(Abs.toUpperCase());
                    pierna1.setText(Pierna.toUpperCase());
                    gluteos1.setText(Gluteos.toUpperCase());
                    pantorria1.setText(Pantorrilla.toUpperCase());
                    pesoactual1.setText(PesoActual.toUpperCase());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void regresar(View view){

        Intent i = new Intent(this, Coaching.class);
        startActivity(i);

    }
}