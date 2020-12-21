package com.aranda.nuevasactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.SEND_SMS;

public class Ativity_SMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativity_s_m_s);



        findViewById(R.id.btnAccionEnviarSMS).setOnClickListener(view ->{



            if (ContextCompat.checkSelfPermission(getApplicationContext(), SEND_SMS)== PackageManager.PERMISSION_GRANTED) {

                EditText txtNumeroSMS = findViewById(R.id.txtNumeroSMS);
                EditText txtMensajeSMS = findViewById(R.id.txtMensajeSMS);

                String numero = txtNumeroSMS.getText().toString();

                if(!numero.startsWith("+34")){

                    numero = "+34" + numero;
                }

                String mensaje = txtMensajeSMS.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(numero, null, mensaje, null, null);
                    Toast.makeText(getApplicationContext(), "SMS enviado correctamente", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error enviando el SMS", Toast.LENGTH_SHORT).show();
                }
            } else {
                requestPermissions(new String[]{SEND_SMS}, 1);
            }






        });




    }
}