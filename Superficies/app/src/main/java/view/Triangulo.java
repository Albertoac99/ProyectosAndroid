package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aranda.superficies.R;

import controller.ContTriangulo;

public class Triangulo extends AppCompatActivity {

    public static EditText etxtBaseTriangulo;
    public static EditText etxtAlturaTriangulo;
    public static TextView txtAreaTriangulo;

    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        context = getApplicationContext();

        etxtBaseTriangulo = findViewById(R.id.etxtBaseTriangulo);
        etxtAlturaTriangulo = findViewById(R.id.etxtAlturaTriangulo);
        txtAreaTriangulo = findViewById(R.id.txtAreaTriangulo);

        Button btnCalcularTriangulo = findViewById(R.id.btnCalcularTriangulo);

        btnCalcularTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContTriangulo.areaTriangulo();
            }
        });
    }
}