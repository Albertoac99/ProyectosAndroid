package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aranda.superficies.R;

import controller.ContHexagono;

public class SupHexagono extends AppCompatActivity {

    public static EditText etxtLadoHexagono;
    public static EditText etxtApotemaHexagono;
    public static TextView txtAreaHexagono;

    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexagono);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = getApplicationContext();
        etxtApotemaHexagono = findViewById(R.id.etxtApotemaHexagono);
        etxtLadoHexagono = findViewById(R.id.etxtLadoHexagono);
        txtAreaHexagono = findViewById(R.id.txtAreaHexagono);

        Button btnCalcularHexagono = findViewById(R.id.btnCalcularHexagono);

        btnCalcularHexagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContHexagono.areaHexagono();
            }
        });
    }
}