package com.aranda.imagenes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText txtFileName;
    private ImageView imgFoto;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFileName = findViewById(R.id.txtFileName);
        imgFoto = findViewById(R.id.imgFoto);

        imgFoto.setOnClickListener(v -> selectFromGallery());

        findViewById(R.id.btnSelectFromGaleria).setOnClickListener(v -> selectFromGallery());
        findViewById(R.id.btnDownload).setOnClickListener(v -> download());
        findViewById(R.id.btnUpload).setOnClickListener(v -> upload());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            try {

                Uri path = data.getData();
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(path), null, null);
                imgFoto.setImageBitmap(bitmap);

            }catch (NullPointerException | FileNotFoundException ignored){


            }
        }

    }

    // Métodos para seleccionar desde la galería
    private void selectFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccione una aplicacion"),0);
    }

    private void download() {

        String url = "https://media-exp1.licdn.com/dms/image/C4E03AQEwZqUKRtZI8A/profile-displayphoto-shrink_800_800/0/1610477742377?e=1616630400&v=beta&t=ksoG0ThlnJAmNV5w9CpUqU1Jm1qZBMFUdt2p_SYJTHY";

        imgFoto.setImageDrawable(null);

        Glide
                .with(getApplicationContext())
                .load(url)
                .apply(RequestOptions.centerCropTransform())
                .into(imgFoto);

        Toast.makeText(getApplicationContext(), "Imagen descargada", Toast.LENGTH_SHORT).show();


    }

    private void upload() {

        if(txtFileName.getText().toString().length() == 0){
            Toast.makeText(getApplicationContext(), "Falta el nombre del archivo", Toast.LENGTH_LONG).show();
            return;
        }

        String strURL = "http://albertoarandamedac.tk/images/imagen.php";

        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor", false, false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, strURL,
                s -> {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Imagen subida con exito", Toast.LENGTH_SHORT).show();
                },
                volleyError -> {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                }

                ){
            @Override
            public Map<String, String> getParams(){
                Hashtable<String, String> params = new Hashtable<>();

                params.put("imagenData", getStringImage(bitmap));
                params.put("imagenName",txtFileName.getText().toString());

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte [] imageBytes = baos.toByteArray();


       return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }


}