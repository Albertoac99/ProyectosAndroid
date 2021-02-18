package view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aranda.feriapp.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Map;

import controller.ContPerfil;
import logic.Datos;

import static logic.Datos.cuentas;

public class Perfil extends AppCompatActivity {
    public static EditText txtNuevaContrasenia;
    public static EditText txtNuevoUsuario;
    public static Button btnEditar;
    Button btnCambiaFoto;
    public static Button btnGuardarCambios;
    public static Context context;
    public static ImageView imgFotoPerfil;
    public static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        context = getApplicationContext();
        imgFotoPerfil = findViewById(R.id.imgFotoPerfil);
        txtNuevaContrasenia = findViewById(R.id.txtNuevaContrasenia);
        txtNuevoUsuario = findViewById(R.id.txtNuevoUsuario);
        btnEditar = findViewById(R.id.btnEditarCampos);
        btnCambiaFoto = findViewById(R.id.btnCambiarFoto);
        btnGuardarCambios = findViewById(R.id.btnGuardarCambios);
        ContPerfil.noEditable();

        ContPerfil.downloadFoto();
        txtNuevoUsuario.setText(Datos.cuentas.getUsuario());
        txtNuevaContrasenia.setText(Datos.cuentas.getContrasenia());

        btnEditar.setOnClickListener(v ->{
            ContPerfil.editar();
        });

        btnGuardarCambios.setOnClickListener(v -> {
            ContPerfil.cambiarUsuario();
        });
        btnCambiaFoto.setOnClickListener(v->{
            selectFromGallery();

        });

    }

    private void selectFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccione una aplicacion"),0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            try {

                Uri path = data.getData();
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(path), null, null);
                imgFotoPerfil.setImageBitmap(bitmap);
                upload();

            }catch (NullPointerException | FileNotFoundException ignored){
                Log.i("ALBERTO", "eres una mierda");

            }
        }

    }
    public void upload() {

        String strURL = "https://arandacastroalberto.000webhostapp.com/php/imagen.php";

        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor", false, false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, strURL,
                s -> {
                    loading.dismiss();
                    Toast.makeText(Perfil.context, "Imagen subida con exito", Toast.LENGTH_SHORT).show();
                },
                volleyError -> {
                    loading.dismiss();
                    Toast.makeText(Perfil.context, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                }

        ){
            @Override
            public Map<String, String> getParams(){
                Hashtable<String, String> params = new Hashtable<>();

                params.put("imagenData", getStringImage(Perfil.bitmap));
                params.put("imagenName", ""+cuentas.getIdCuenta());

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Perfil.context);
        requestQueue.add(stringRequest);

    }
    private String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte [] imageBytes = baos.toByteArray();


        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }
}