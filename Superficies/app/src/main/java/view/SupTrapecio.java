package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aranda.superficies.R;

import controller.ContTrapecio;

public class SupTrapecio extends AppCompatActivity {

    public static EditText etxtAlturaTrapecio;
    public static EditText etxtBaseTrapecio;
    public static EditText etxtBaseSuperiorTrapecio;
    public static TextView txtAreaTrapecio;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapecio);

        context = getApplicationContext();

        txtAreaTrapecio = findViewById(R.id.txtAreaTrapecio);
        etxtAlturaTrapecio = findViewById(R.id.etxtAlturaTrapecio);
        etxtBaseTrapecio = findViewById(R.id.etxtBaseTrapecio);
        etxtBaseSuperiorTrapecio = findViewById(R.id.etxtBaseSuperiorTrapecio);

        Button btnCalcularTrapecio = findViewById(R.id.btnCalcularTrapecio);

        btnCalcularTrapecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContTrapecio.areaTrapecio();
            }
        });
    }
}