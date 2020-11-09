package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aranda.superficies.R;

import controller.ContRectangulo;

public class SupRectangulo extends AppCompatActivity {

    public static EditText etxtBaseRectangulo;
    public static EditText etxtAlturaRectangulo;
    public static TextView txtAreaRectangulo;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        context = getApplicationContext();

        etxtBaseRectangulo = findViewById(R.id.etxtBaseRectangulo);
        etxtAlturaRectangulo = findViewById(R.id.etxtAlturaRectangulo);
        txtAreaRectangulo = findViewById(R.id.txtAreaRectangulo);

        Button btnCalcularRectangulo = findViewById(R.id.btnCalcularRectangulo);

        btnCalcularRectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContRectangulo.areaRectangulo();
            }
        });
    }
}