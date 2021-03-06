package com.aranda.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        MenuBuilder m = (MenuBuilder) menu;
        m.setGroupDividerEnabled(true);
        m.setOptionalIconsVisible(true);

        //Que no aparezca una opcion del menu
        //m.findItem(R.id.menu1).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String mensaje = "";

        switch (item.getItemId()){

            case R.id.menu1: mensaje = "opcion 1";
                 break;
            case R.id.menu2: mensaje = "opcion 2";
                break;
            case R.id.menu3: mensaje = "opcion 3";
                break;
            case R.id.menu4: mensaje = "opcion 4";
                break;

        }


        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        return true;
    }
}