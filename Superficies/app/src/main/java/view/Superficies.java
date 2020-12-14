package view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        rectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SupRectangulo.class);

                startActivity(intent);
            }
        });

        triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SupTriangulo.class);

                startActivity(intent);
            }
        });

        circulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SupCirculo.class);

                startActivity(intent);
            }
        });

        hexagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SupHexagono.class);

                startActivity(intent);
            }
        });

        pentagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SupPentagono.class);

                startActivity(intent);
            }
        });

        trapecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SupTrapecio.class);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menuCirculo:
                intent = new Intent(this, SupCirculo.class);
                startActivity(intent);
                break;
            case R.id.menuHexagono:
                intent = new Intent(this, SupHexagono.class);
                startActivity(intent);
                break;
            case R.id.menuPentagono:
                intent = new Intent(this, SupPentagono.class);
                startActivity(intent);
                break;
            case R.id.menuTrapecio:
                intent = new Intent(this, SupTrapecio.class);
                startActivity(intent);
                break;
            case R.id.menuTriangulo:
                intent = new Intent(this, SupTriangulo.class);
                startActivity(intent);
                break;
            case R.id.menuRectangulo:
                intent = new Intent(this, SupRectangulo.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}