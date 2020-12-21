package com.aranda.nuevasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

public class Activity_Email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        findViewById(R.id.btnAccionEmail).setOnClickListener(view -> {

            EditText txtEmailAdress = findViewById(R.id.txtDireccionEmail);
            EditText txtAsuntoEmail = findViewById(R.id.txtAsuntoEmail);
            EditText txtMensajeEmail = findViewById(R.id.txtMenajeEmail);

            String adress = txtEmailAdress.getText().toString();
            String subject = txtAsuntoEmail.getText().toString();
            String textBody = txtMensajeEmail.getText().toString();

            Intent selectorEmail = new Intent(Intent.ACTION_SENDTO);
            selectorEmail.setData(Uri.parse("mailto:"));

            Intent i = new Intent(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_EMAIL,new String[] {adress});
            i.putExtra(Intent.EXTRA_SUBJECT, subject);
            i.putExtra(Intent.EXTRA_TEXT, textBody);
            i.setSelector(selectorEmail);

            startActivity(Intent.createChooser(i,"Seleccione app"));




        });



    }
}