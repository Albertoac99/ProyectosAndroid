package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aranda.listaproductos.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Grafico extends AppCompatActivity {

    PieChart graficaTarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        graficaTarta = findViewById(R.id.graficaTartas);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(18.5f, "Green"));
        entries.add(new PieEntry(26.7f, "Yellow"));
        entries.add(new PieEntry(24.0f, "Red"));
        entries.add(new PieEntry(30.8f, "Blue"));
        PieDataSet set = new PieDataSet(entries, "Election Results");
        PieData data = new PieData(set);
        set.setColors(ColorTemplate.COLORFUL_COLORS);
        graficaTarta.setData(data);
        graficaTarta.invalidate(); // refresh
    }
}