package com.example.saiyagym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText email, contrasena;
    Button iniciarsesion, Registro, cerrarsesion;

    private String correo, pass;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        email = findViewById(R.id.correoa);
        contrasena = findViewById(R.id.contrasena);
        iniciarsesion = findViewById(R.id.IniciarSesion);
        Registro = findViewById(R.id.Registro);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();



        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                correo = email.getText().toString().trim();
                pass = contrasena.getText().toString().trim();

                if (!correo.isEmpty() && !pass.isEmpty()) {

                    loginUser();

                } else {

                    Toast.makeText(getApplicationContext(), "Debe completar todos los campos", Toast.LENGTH_SHORT).show();

                }
            }
        });




    }

    private void loginUser () {
        mAuth.signInWithEmailAndPassword(correo, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    startActivity(new Intent(getApplicationContext(), InfoUser.class));
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Sesion no iniciada, comprueba tus datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


public void crear(View view){
        Intent i = new Intent(this, CreateUser.class);
        startActivity(i);
}

}