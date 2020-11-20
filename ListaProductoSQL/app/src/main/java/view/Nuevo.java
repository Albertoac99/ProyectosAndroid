package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import com.aranda.listaproductosql.R;

import logic.AdaptadorProducto;
import logic.Datos;
import model.Producto;

public class Nuevo extends AppCompatActivity {

    public static EditText etxtNombre;
    public static EditText etxtPrecio;
    public static RatingBar edtStars;
    public static Button btnGuardar;
    public static ListView lista2;
    public static Spinner lista1;
    public static RadioGroup radBoton;
    public static Switch swtFragil;
    AdaptadorProducto adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        etxtNombre = findViewById(R.id.etxtNombre);
        etxtPrecio = findViewById(R.id.etxtPrecio);
        edtStars = findViewById(R.id.edtStars);
        btnGuardar = findViewById(R.id.btnGuardar);
        lista2 = findViewById(R.id.lista2);
        lista1 = findViewById(R.id.lista1);
        radBoton = findViewById(R.id.radBoton);
        swtFragil = findViewById(R.id.swtFragil);

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