package view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.aranda.feriapp.R;

import java.util.ArrayList;

import controller.ContListaCasetas;
import logic.AdaptadorCaseta;
import logic.Datos;
import model.Caseta;

import static logic.LogFeriapp.lstCasetas;

public class ListaCasetas extends AppCompatActivity {


    AdaptadorCaseta adaptadorCaseta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_casetas);

        RecyclerView rcvCasetas = findViewById(R.id.rcvCasetas);
        rcvCasetas.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rcvCasetas.setLayoutManager(llm);

        adaptadorCaseta = new AdaptadorCaseta(this);
        rcvCasetas.setAdapter(adaptadorCaseta);
        adaptadorCaseta.refrescar();

    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuBuilder m = (MenuBuilder) menu;
        m.setGroupDividerEnabled(true);
        m.setOptionalIconsVisible(true);

        //Que no aparezca una opcion del menu
        //m.findItem(R.id.menu1).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){

            case R.id.itmPerfil:

                break;
            case R.id.itmEspacio:

                break;
            case R.id.itmPublica:

                break;
            case R.id.itmPrivada:

                break;

        }

        return true;
    }

}