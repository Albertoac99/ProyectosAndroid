package com.aranda.preferencias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtFirma = findViewById(R.id.txtFirma);

        // Acceso a las Preferencias
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        // Leer de las Preferencias
        String la_firma = pref.getString("Firma", "Don Manuel Ruiz de Lopera, Director de Recursos");
        txtFirma.setText(la_firma);

        // Escribir en las Preferencias
        SharedPreferences.Editor editorPreferencias = pref.edit();
        editorPreferencias.putString("Firma","Don Antonio, Jefe de Recursos Humanos");
        editorPreferencias.apply();

        findViewById(R.id.btnPreferencias).setOnClickListener(v->
                startActivity(new Intent(this, PreferenciasActivity.class))
                );
    }
}