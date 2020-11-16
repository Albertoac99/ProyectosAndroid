package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aranda.listaproductos.R;

import java.util.ArrayList;

import logic.AdaptadorProducto;
import logic.Datos;
import model.Producto;

public class Principal extends AppCompatActivity {

    AdaptadorProducto adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Datos.elementos = getElements();


        RecyclerView listaEjemplo = findViewById(R.id.listaejemplo);
        listaEjemplo.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaEjemplo.setLayoutManager(llm);

        adaptador = new AdaptadorProducto(this);
        listaEjemplo.setAdapter(adaptador);
        adaptador.refrescar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adaptador.refrescar();
    }

    private ArrayList<Producto> getElements() {

        ArrayList<Producto> elementos = new ArrayList<Producto>();
        for (int i = 0; i < 20; i++) {
            //elementos.add(new Producto("Nombre" + i, "Precio" + i, (float) Math.random()*5+1));
            elementos.add(new Producto("NOMBRE_PRODUCTO", "120,75", (float) Math.random()*5+1, false, 1, 1, 0));
        }
        return elementos;
    }
}