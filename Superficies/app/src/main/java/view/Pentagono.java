package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aranda.superficies.R;

import controller.ContPentagono;

public class Pentagono extends AppCompatActivity {

    public static EditText etxtLadoPentagono;
    public static EditText etxtApotemaPentagono;
    public static TextView txtAreaPentagono;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pentagono);

        context = getApplicationContext();


        etxtApotemaPentagono = findViewById(R.id.etxtApotemaPentagono);
        etxtLadoPentagono = findViewById(R.id.etxtLadoPentagono);
        txtAreaPentagono = findViewById(R.id.txtAreaPentagono);
        Button btnCalcularPentagono = findViewById(R.id.btnCalcularPentagono);

        btnCalcularPentagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContPentagono.areaPentagono();
            }
        });
    }
}