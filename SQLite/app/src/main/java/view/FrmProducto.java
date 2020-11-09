package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.aranda.sqlite.R;

import java.util.Arrays;
import java.util.List;

import controller.CtrProducto;

public class FrmProducto extends AppCompatActivity {

    public static EditText txtNombre;
    public static EditText txtPrecio;
    public static Spinner lstSeccion;
    public static TextView txtResultados;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
    txtNombre = findViewById(R.id.edtNombre);
    txtPrecio = findViewById(R.id.edtPrecio);
    lstSeccion = findViewById(R.id.spinner);
    txtResultados = findViewById(R.id.txtTexto);

        List<String> secciones = Arrays.asList("Monitor","DiscoDuro", "Memoria", "Teclado");
        lstSeccion.setAdapter(new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, secciones));



    }
    public void clickInsertar(View view){
        CtrProducto.insertarProducto();
    }
    public void clickEliminar(View view){
        CtrProducto.EliminarProducto();
    }
    public void clickEditar(View view){
        CtrProducto.EditarProducto();
    }
    public void clickBuscar(View view){
        CtrProducto.BuscarProducto();
    }
    public void clickListar(View view){
        CtrProducto.ListarProducto();
    }


}