package com.aranda.ejercicio6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    static int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Alberto", "Método onCreate terminado");

    }

    @Override
    protected void onPause(){
        super.onPause();
        cont++;
        Log.i("Alberto","Está en pausa " + cont + " veces");
        if (cont == 5){
            super.onDestroy();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Alberto","Volviendo a la aplicación");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.i("Alberto","Atras");
    }

    @Override
    protected void onDestroy() {
        super.onResume();
        Log.i("Alberto","A tomar por culo la aplicacion");

    }
}