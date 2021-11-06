package com.example.saiyagym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DatosUsuario extends AppCompatActivity {

    private EditText nombre, edad;
    Button btnenviarNE;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        btnenviarNE = findViewById(R.id.btnenviarNE);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnenviarNE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name, age;

                name = nombre.getText().toString().trim();
                age = edad.getText().toString().trim();

                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map1 = new HashMap<>();
                map1.put("NameUser", name);
                map1.put("AgeUser", age);
                mDatabase.child("Users").child(iD).updateChildren(map1);

                startActivity(new Intent(getApplicationContext(), PrimerasMedidasUser.class));
                finish();


            }
        });

    }


}