package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.aranda.superficies.R;

public class Superficies extends AppCompatActivity {
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton rectangulo = findViewById(R.id.btnRectangulo);
        ImageButton triangulo = findViewById(R.id.btnTriangulo);
        ImageButton circulo = findViewById(R.id.btnCirculo);
        ImageButton hexagono = findViewById(R.id.btnHexagono);
        ImageButton pentagono = findViewById(R.id.btnPentagono);
        ImageButton trapecio = findViewById(R.id.btnTrapecio);

        rectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Rectangulo.class);

                startActivity(intent);
            }
        });

        triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Triangulo.class);

                startActivity(intent);
            }
        });

        circulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Circulo.class);

                startActivity(intent);
            }
        });

        hexagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hexagono.class);

                startActivity(intent);
            }
        });

        pentagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pentagono.class);

                startActivity(intent);
            }
        });

        trapecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Trapecio.class);

                startActivity(intent);
            }
        });
    }
}