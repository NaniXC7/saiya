package com.example.saiyagym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class CreateUser extends AppCompatActivity {

    private EditText email, contrasena, contrasenaconfirmacion;
    Button enviarEC;

    private String correo, pass1, pass2;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        email = findViewById(R.id.email);
        contrasena = findViewById(R.id.contrasena);
        contrasenaconfirmacion = findViewById(R.id.contrasenaconfirmacion);
        enviarEC = findViewById(R.id.enviarEC);

        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        enviarEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                correo = email.getText().toString().trim();
                pass1 = contrasena.getText().toString().trim();
                pass2= contrasenaconfirmacion.getText().toString().trim();

                if (!correo.isEmpty()&&!pass1.isEmpty()&&!pass2.isEmpty()){


                    if(pass1.equals(pass2)){

                        if (pass1.length()>=8){

                            registerUser();

                        }else{

                            Toast.makeText(getApplicationContext(),"El password debe contener al menos 8 caracteres",Toast.LENGTH_SHORT).show();

                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Las contraseñas no coinden",Toast.LENGTH_SHORT).show();
                    }

                }else{

                    Toast.makeText(getApplicationContext(),"Debe completar cada uno de los campos",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(correo, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Map<String,Object> map = new HashMap<>();
                    map.put("Email",correo);
                    map.put("Password",pass1);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(),DatosUsuario.class));
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(),"Error, los datos no fueron creados correctamente",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

                else{
                    Toast.makeText(getApplicationContext(),"Uusario no registrado, error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}