package com.aranda.nuevasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityWhatsapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        findViewById(R.id.btnAccionEnviarWhatsapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNumeroWhatsapp = findViewById(R.id.txtNumeroWhatsapp);
                EditText txtMensajeWhatsapp = findViewById(R.id.txtMensajeWhatsapp);

                String numero = txtNumeroWhatsapp.getText().toString();

                if (!numero.startsWith("+34")) {

                    numero = "+34" + numero;

                }

                String mensaje = txtMensajeWhatsapp.getText().toString();

                if (mensaje.length() > 0) {
            try {
                String uri = "whatsapp://send?phone=" + numero + "&text=" + mensaje;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(uri));
                startActivity(i);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "No hay whatsapp", Toast.LENGTH_SHORT).show();
            }
                } else {
                    try{
                    String uri = "smsto:" + numero;
                    Intent in = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
                    in.setPackage("com.whatsapp");

                        startActivity(in);

                    } catch(Exception e) {
                        Toast.makeText(getApplicationContext(), "No hay whatsapp", Toast.LENGTH_SHORT).show();
                    }

                }
            }
            });


        }
    }