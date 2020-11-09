package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aranda.superficies.R;

import controller.ContCirculo;

public class SupCirculo extends AppCompatActivity {

    public static Context context;
    public static EditText etxtRadioCirculo;
    public static TextView txtAreaCirculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        context = getApplicationContext();

        etxtRadioCirculo = findViewById(R.id.etxtRadioCirculo);
        txtAreaCirculo = findViewById(R.id.txtAreaCirculo);
        Button btnCalcularCirculo = findViewById(R.id.btnCalcularCirculo);

        btnCalcularCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContCirculo.areaCirculo();
            }
        });
    }
}