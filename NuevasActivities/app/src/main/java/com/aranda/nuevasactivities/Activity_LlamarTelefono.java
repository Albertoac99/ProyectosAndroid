package com.aranda.nuevasactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.Manifest.permission.CALL_PHONE;

public class Activity_LlamarTelefono extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar_telefono);

        findViewById(R.id.btnAccionLlamarTelefono).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtNumeroLlamar = findViewById(R.id.txtNumeroLlamar);
                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + txtNumeroLlamar.getText().toString()));
                    startActivity(i);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }

            }
        });


    }
}