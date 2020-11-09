package com.aranda.ejercicioestrellitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import model.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Persona> elementos = getElements();

        // Vinculamos el objeto del controlador con el de la vista
        RecyclerView listaEjemplo = findViewById(R.id.listaejemplo);

        // Impide cambiar el tamaño del RecycleView
        listaEjemplo.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaEjemplo.setLayoutManager(llm);

        AdaptadorPersona adaptador = new AdaptadorPersona(elementos);
        listaEjemplo.setAdapter(adaptador);
        adaptador.refrescar();


    }

    private ArrayList<Persona> getElements() {

        ArrayList<Persona> elementos = new ArrayList<Persona>();
        for (int i = 0; i < 20; i++) {
            elementos.add(new Persona("Nombre" + i, "Apellidos" + i, (float) Math.random()*5+1));
        }
        return elementos;
    }
}