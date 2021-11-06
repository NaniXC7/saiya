package com.example.saiyagym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Nutricion extends AppCompatActivity {

    Button lunes, martes, miercoles, jueves, viernes;
    TextView ruti1, ruti2, ruti3, ruti4, ruti5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricion);

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

                Toast.makeText(getApplicationContext(), "Día Lunes", Toast.LENGTH_SHORT).show();

                ruti1.setText("Desayuno :\n 4 huevos al gusto con aceite de dieta.\n80gr Arroz.\n50gr de aguacate." +
                        "\n 40gr Frijoles.\n Bebida: Agua Pura Cielo 600ml");
                ruti2.setText("Almuerzo:\n100gr de Pechuga de pollo\n 80gr Arroz.\n50gr Aguacate.\n Ensalada de Lechuga con tomate.\n" +
                        "Bebida: Fresco Natural");
                ruti3.setText("Cena:\nMedia docena de chorizos ahumados.\n100gr chirmol.\n80gr Frijoles.\n Bebida: Café");

            }
        });

        martes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Martes", Toast.LENGTH_SHORT).show();

                ruti1.setText("Desayuno :\n 200gr de atún.\n80gr Arroz.\n50gr de aguacate." +
                        "\n 40gr Frijoles.\n Bebida: Cajita de Incaparina 300ml");
                ruti2.setText("Almuerzo:\n300gr de Picado de Verduras con Carne\n 80gr Arroz.\n50gr Aguacate.\n 80gr Frijoles.\n" +
                        "Bebida: Agua Pura 600ml");
                ruti3.setText("Cena:\n4 Salchichas de Pavo.\n3 tortillas.\n80gr Frijoles.\n Bebida: Leche chocolatada");

            }
        });

        miercoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Miercoles", Toast.LENGTH_SHORT).show();

                ruti1.setText("Desayuno :\n 5 Panqueques.\n100gr d miel de maple.\n50gr de Granola." +
                        "\n Bebida: Juco de Naranja con pulpa 600ml");
                ruti2.setText("Almuerzo:\n300gr de carne de cerdo\n 80gr Arroz.\n50gr Aguacate.\n 80gr Ensalada de verduras.\n" +
                        "Bebida: Jugo de zanahoria 600ml");
                ruti3.setText("Cena:\n4 huevos.\n100gr Arroz.\n80gr Frijoles.\n Bebida: Mosh");

            }
        });

        jueves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Jueves", Toast.LENGTH_SHORT).show();

                ruti1.setText("Desayuno :\n Yogourt Con Frutas.\n100gr de granola. "+
                        "\n Bebida: Juco de Toronja con pulpa 600ml");
                ruti2.setText("Almuerzo:\nLomito de res\n 80gr Arroz.\n 80gr Ensalada de verduras.\n50gr Aguacate.\n" +
                        "Bebida: Agua Pura 600ml");
                ruti3.setText("Cena:\nEnsalada de Lechuga con Verduras.\n Bebida: Té frío al gusto");

            }
        });

        viernes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Día Viernes", Toast.LENGTH_SHORT).show();

                ruti1.setText("Desayuno :\n Cereal integral.\n300gr de Frutas.\n 500ml de Leche +Prptreína.");
                ruti2.setText("Almuerzo:\n5 Empanadas al gusto\n 200ml de Salsa.\n 80gr Curtido.\n" +
                        "Bebida: Cola Shanpan 600ml");
                ruti3.setText("Aguantar hambre por exceso de calorias consumidas");

            }
        });
    }

    public void regresar(View view){

        Intent i = new Intent(this, Coaching.class);
        startActivity(i);

    }
}