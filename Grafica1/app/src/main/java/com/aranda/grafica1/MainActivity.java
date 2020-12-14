package com.aranda.grafica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BarChart graficaBarras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graficaBarras = findViewById(R.id.graficaBarras);

        // Creamos los valores de entrada
        List<BarEntry> entradas = new ArrayList<>();

        entradas.add(new BarEntry(0,2));
        entradas.add(new BarEntry(1,4));
        entradas.add(new BarEntry(2,6));
        entradas.add(new BarEntry(3,8));
        entradas.add(new BarEntry(4,3));
        entradas.add(new BarEntry(5,1));



        // Mandamos los datos para crear la gráfica
        BarDataSet datos = new BarDataSet(entradas, "GRÁFICA DE BARRAS");
        BarData data = new BarData(datos);

        // Ponemos color a cada barra
        datos.setColors(ColorTemplate.COLORFUL_COLORS);

        // La separación entre barras
        data.setBarWidth(0.9f);

        graficaBarras.setData(data);

        // Ponemos las barras centrada
        graficaBarras.setFitBars(true);

        // Hacemos un refresh de la gráfica
        graficaBarras.invalidate();



    }



}