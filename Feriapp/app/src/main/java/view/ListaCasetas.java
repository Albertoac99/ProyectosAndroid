package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        ContListaCasetas.obtenerCasetas();

        RecyclerView rcvCasetas = findViewById(R.id.rcvCasetas);
        rcvCasetas.setHasFixedSize(true);

        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        rcvCasetas.setLayoutManager(llm);

        adaptadorCaseta = new AdaptadorCaseta(this);
        rcvCasetas.setAdapter(adaptadorCaseta);
        adaptadorCaseta.refrescar();
*/
    }


    private ArrayList<Caseta> getElements() {

        ArrayList<Caseta> elementos = new ArrayList<Caseta>();
        for (int i = 0; i < 10; i++) {
            elementos.add(new Caseta(i,"caseta"+i,"calle"+i,100,i+1,"10:30-12:00",true));
        }
        return elementos;
    }
}