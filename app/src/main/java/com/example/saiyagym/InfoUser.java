package com.example.saiyagym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saiyagym.databinding.ActivityInfoUserBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class InfoUser<binding> extends AppCompatActivity {

    Button cerrarsesion, c1, c2, c3, c4, c5;
    private TextView welcome;
    private String couch;


    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_user);

        cerrarsesion = findViewById(R.id.cerrarsesion);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        welcome = findViewById(R.id.welcome);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                couch = "Baki Hanma";

                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map1 = new HashMap<>();
                map1.put("Entrenador", couch);
                mDatabase.child("Users").child(iD).updateChildren(map1);

                startActivity(new Intent(getApplicationContext(), Coaching.class));
                finish();

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                couch = "Satoru Goujo";

                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map1 = new HashMap<>();
                map1.put("Entrenador", couch);
                mDatabase.child("Users").child(iD).updateChildren(map1);

                startActivity(new Intent(getApplicationContext(), Coaching.class));
                finish();

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                couch = "Rock Lee";

                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map1 = new HashMap<>();
                map1.put("Entrenador", couch);
                mDatabase.child("Users").child(iD).updateChildren(map1);

                startActivity(new Intent(getApplicationContext(), Coaching.class));
                finish();

            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                couch = "El Cuto";

                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map1 = new HashMap<>();
                map1.put("Entrenador", couch);
                mDatabase.child("Users").child(iD).updateChildren(map1);

                startActivity(new Intent(getApplicationContext(), Coaching.class));
                finish();

            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                couch = "El Enjutado";

                String iD = mAuth.getCurrentUser().getUid();
                Map<String,Object> map1 = new HashMap<>();
                map1.put("Entrenador", couch);
                mDatabase.child("Users").child(iD).updateChildren(map1);

                startActivity(new Intent(getApplicationContext(), Coaching.class));
                finish();

            }
        });



        getUserInfo();

    }

    public void entrenador(View view){

        Intent i = new Intent(getApplicationContext(), Coaching.class);
        startActivity(i);

    }

    private void getUserInfo(){
        String id=mAuth.getCurrentUser().getUid();

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String name=snapshot.child("NameUser").getValue().toString();


                    welcome.setText("BIENVENIDO "+name.toUpperCase());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}