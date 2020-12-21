package view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.aranda.listaproductosql.R;

import logic.AdaptadorProducto;
import logic.Datos;
import model.Producto;

import static logic.AdaptadorProducto.posicion;

public class Editar extends AppCompatActivity {
    EditText etxtNombre;
    EditText etxtPrecio;
    RatingBar edtStars;
    Button btnGuardar;
    ListView lista2;
    Spinner lista1;
    RadioGroup radBoton;
    Switch swtFragil;
    AdaptadorProducto adaptador;

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.borrar:
                Toast.makeText(this, "borrado", Toast.LENGTH_SHORT).show();
                onBackPressed();

                break;
            case R.id.guardar:
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
                String sNombre = etxtNombre.getText().toString();
                String sPrecio = etxtPrecio.getText().toString();
                float fEstrellas = edtStars.getRating();
                boolean bFragil = swtFragil.isChecked();
                int ID = radBoton.getCheckedRadioButtonId();
                int ciudad = lista2.getSelectedItemPosition();
                int proveedor = (int)lista1.getSelectedItemId();
                adaptador = new AdaptadorProducto(getApplicationContext());
                Datos.elementos.set(AdaptadorProducto.posicion, new Producto(sNombre,sPrecio,fEstrellas,bFragil,ID,ciudad,proveedor));
                //Para volver atrás
                onBackPressed();
                break;

        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        etxtNombre = findViewById(R.id.etxtNombre);
        etxtPrecio = findViewById(R.id.etxtPrecio);
        edtStars = findViewById(R.id.edtStars);
        btnGuardar = findViewById(R.id.btnGuardar);
        lista2 = findViewById(R.id.lista2);
        lista1 = findViewById(R.id.lista1);
        radBoton = findViewById(R.id.radBoton);
        swtFragil = findViewById(R.id.swtFragil);

        etxtNombre.setText(Datos.elementos.get(posicion).getNombre());
        etxtPrecio.setText(Datos.elementos.get(posicion).getPrecio());
        edtStars.setRating(Datos.elementos.get(posicion).getEstrellas());
        lista1.setSelection(Datos.elementos.get(posicion).getProveedor());
        radBoton.check(Datos.elementos.get(posicion).getEnvoltorio());
        swtFragil.setChecked(Datos.elementos.get(posicion).isFragil());

        swtFragil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swtFragil.isChecked()){
                    swtFragil.setChecked(true);
                }
                else{
                    swtFragil.setChecked(false);
                }

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Datos.elementos.set(posicion, new Producto(etxtNombre.getText().toString(),etxtPrecio.getText().toString(),edtStars.getRating()));

                String sNombre = etxtNombre.getText().toString();
                String sPrecio = etxtPrecio.getText().toString();
                float fEstrellas = edtStars.getRating();
                boolean bFragil = swtFragil.isChecked();
                int ID = radBoton.getCheckedRadioButtonId();
                int ciudad = lista2.getSelectedItemPosition();
                int proveedor = (int)lista1.getSelectedItemId();
                adaptador = new AdaptadorProducto(getApplicationContext());
                Datos.elementos.set(AdaptadorProducto.posicion, new Producto(sNombre,sPrecio,fEstrellas,bFragil,ID,ciudad,proveedor));
            }
        });



    }
}