package com.aranda.consultawebservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner Mispinner;
    private Coche miCoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargadatos();

       // getCoche(3);

        Mispinner = findViewById(R.id.Mispinner);

    }

    private void cargadatos() {

        new LoadDataCoches_AsyncTask().execute("http://albertoarandamedac.tk/consulta1.php");

    }



    private void getCoche(int code){

        new Load1Coche_AsyncTask().execute("http://192.168.31.235/sandbox/getCoche.php?id="+code);
    }

    public class Load1Coche_AsyncTask extends AsyncTask<String, Void, Void>{
        String resultado;

        @Override
        protected Void doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                String stringBuffer;
                String str = "";

                while ((stringBuffer = bufferedReader.readLine()) != null) {

                    str = String.format("%s%s", str, stringBuffer);

                }
                ;

                bufferedReader.close();
                resultado = str;


            } catch (IOException e) {
                resultado = e.getMessage();
            }


            return null;
        }
            @Override
            public void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);

                Gson gson = new Gson();
                Type type = new TypeToken<List<Coche>>(){}.getType();
                List<Coche> lstCoches = gson.fromJson(resultado, type);

                miCoche = lstCoches.get(0);


            }
        }

    public class LoadDataCoches_AsyncTask extends AsyncTask<String, Void, Void>{
        String resultado;

        @Override
        protected Void doInBackground(String... params) {

            try{
                URL url = new URL(params[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                String stringBuffer;
                String str = "";

                while ((stringBuffer = bufferedReader.readLine()) != null){

                    str = String.format("%s%s", str, stringBuffer);

                };

                bufferedReader.close();
                resultado = str;


            }catch (IOException e){
                resultado = e.getMessage();
            }


            return null;
        }

        @Override
        public void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);

            Gson gson = new Gson();
            Type type = new TypeToken<List<Coche>>(){}.getType();
            List<Coche> lstCoches = new ArrayList<Coche>();
            lstCoches = gson.fromJson(resultado, type);

            List<String> listaMarcas = new ArrayList<>();

            for(Coche c : lstCoches){

                listaMarcas.add(c.getMarca());

            }

            Mispinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, listaMarcas));

             for(Coche c : lstCoches){
                Log.i("ALBERTO", c.toString());
            }

        }


    }

}