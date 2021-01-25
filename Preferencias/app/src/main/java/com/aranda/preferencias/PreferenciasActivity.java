package com.aranda.preferencias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.os.Bundle;

public class PreferenciasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frmPrefetencias, new PreferenciasFragment())
                .commit();
    }

    public static class PreferenciasFragment extends PreferenceFragmentCompat {


        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.opciones, rootKey);
        }
    }

}