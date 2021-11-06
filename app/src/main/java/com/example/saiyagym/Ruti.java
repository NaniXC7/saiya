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
    TextView ruti1, ruti2, ruti3, ruti4, ruti5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruti);

        lunes = findViewById(R.id.Lunes);
        martes = findViewById(R.id.Martes);
        miercoles = findViewById(R.id.Miercoles);
        jueves = findViewById(R.id.Jueves);
        viernes = findViewById(R.id.Viernes);
        ruti1 = findViewById(R.id.ruti1);
        ruti2 = findViewById(R.id.ruti2);
        ruti3 = findViewById(R.id.ruti3);
        ruti4 = findViewById(R.id.ruti4);
        ruti5 = findViewById(R.id.ruti5);



        lunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Lunes | Pecho", Toast.LENGTH_SHORT).show();

                ruti1.setText("Press Plano con Barra | 4 Series X12 repeticiones");
                ruti2.setText("Press Plano con Mancuernas | 4 Series X15 repeticiones");
                ruti3.setText("Press inclinado con Barra | 4 Series X15 repeticiones");
                ruti4.setText("Press inclinado con Mancuernas | 4 Series X15 repeticiones");
                ruti5.setText("Domeinadas Diamante | 4 Series X10 repeticiones");

            }
        });

        martes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Martes | Pierna", Toast.LENGTH_SHORT).show();

                ruti1.setText("Desplantes | 4 Series X12 repeticiones | ida y vuelta");
                ruti2.setText("Sentadilla Sumo | 4 Series X15 repeticiones");
                ruti3.setText("Peso Muerto | 4 Series X15 repeticiones");
                ruti4.setText("Extension de Cuádriceps | 4 Series X15 repeticiones");
                ruti5.setText("Femorales | 4 Series X15 repeticiones");

            }
        });

        miercoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Miercoles | Hombro", Toast.LENGTH_SHORT).show();

                ruti1.setText("Laterales | 4 Series X12 repeticiones");
                ruti2.setText("Frontales | 4 Series X12 repeticiones");
                ruti3.setText("Trapecio | 4 Series X15 repeticiones");
                ruti4.setText("Jalón de Polea | 4 Series X15 repeticiones | Cada brazo");
                ruti5.setText("Press Militar | 4 Series X12 repeticiones");

            }
        });

        jueves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Lunes | Bíceps", Toast.LENGTH_SHORT).show();

                ruti1.setText("Curl Concentrado | 4 Series X12 repeticiones");
                ruti2.setText("Predicador | 4 Series X12 repeticiones");
                ruti3.setText("Martillo | 4 Series X10 repeticiones");
                ruti4.setText("Curl de Bíceps con mancuernas | 4 Series X12 repeticiones");
                ruti5.setText("Curl de Bíceps con Barra Z | 4 Series X15 repeticiones");

            }
        });

        viernes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Lunes | Tríceps", Toast.LENGTH_SHORT).show();

                ruti1.setText("Patada de Tríceps | 4 Series X12 repeticiones");
                ruti2.setText("Copa | 4 Series X15 repeticiones");
                ruti3.setText("Extension de Tríceps | 4 Series X15 repeticiones");
                ruti4.setText("Rompe Cráneos | 4 Series X15 repeticiones");
                ruti5.setText("Jalon del Hombre araña | 4 Series X10 repeticiones");

            }
        });



    }

    public void regresar(View view){

        Intent i = new Intent(this, Coaching.class);
        startActivity(i);

    }

}