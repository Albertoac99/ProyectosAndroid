package logic;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Caseta;
import view.CrearUsuario;

public class LogFeriapp {
    public static List<Caseta> lstCasetas;

    public static void mensajeCampos() {
        Toast.makeText(CrearUsuario.context, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
    }

    public static void cargadatos() {

        new LoadDataCasetas_AsyncTask().execute("http://albertoarandamedac.tk/getCasetas.php");

    }

    private static class LoadDataCasetas_AsyncTask extends AsyncTask<String, Void, Void> {
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
            Type type = new TypeToken<List<Caseta>>(){}.getType();

            Log.i("ALBERTO","HOLA: "+resultado);
            lstCasetas = gson.fromJson(resultado, type);
            Log.i("ALBERTO","HOLA32423423: "+lstCasetas.toString());
            Datos.casetas = lstCasetas;
            for (Caseta c : Datos.casetas){
                System.out.println("ADFSFSDFSFSFSD: "+c);
            }
/*
            List<String> listaNombres = new ArrayList<>();

            for(Caseta c : lstCasetas){

                listaNombres.add(c.getNombreCaseta());

            }
*/
           // Mispinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, listaMarcas));


        }


    }
}
