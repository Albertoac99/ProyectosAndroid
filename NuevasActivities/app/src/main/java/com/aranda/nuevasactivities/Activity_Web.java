package com.aranda.nuevasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

public class Activity_Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        findViewById(R.id.btnAccionWeb).setOnClickListener(view ->{

            EditText txtUrl = findViewById(R.id.txtURL);

            String url = txtUrl.getText().toString();

            if (url.length()>0){

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));

            }


        });



    }
}