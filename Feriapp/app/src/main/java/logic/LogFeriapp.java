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
import view.Inicio;

import static logic.Datos.opcion;

public class LogFeriapp {
    public static ArrayList<Caseta> lstCasetas;
    private static boolean bExiste;

    public static void mensajeCampos() {
        Toast.makeText(CrearUsuario.context, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
    }

    public static boolean cargadatos() {

        if(opcion==1){
            // Intruccion para traer las casetas de la base de datos
            new LoadDatos_AsyncTask().execute("http://albertoarandamedac.tk/getCasetas.php");
        }
        else if(opcion==2){
            // Intruccion para traer las calles de la base de datos
            new LoadDatos_AsyncTask().execute("http://albertoarandamedac.tk/getCalles.php");
        }
        else if(opcion ==3){
            // Instruccion para comprobar si existe un usuario en la base de datos (registro)
            new LoadDatos_AsyncTask().execute("http://albertoarandamedac.tk/getUser.php?usuario="+CrearUsuario.txtUsuarioRegistro.getText().toString());
        }
        else if (opcion == 4){
            // Instruccion para saber si existe un usuario con una determinada contraseña en la base de datos (logueo)
            new LoadDatos_AsyncTask().execute("http://albertoarandamedac.tk/getUserPassword.php?usuario="+ Inicio.txtUsuarioLogueo.getText().toString() +"&contrasenia=" +Inicio.txtContraseñaLogueo.getText().toString());
        }
        else if (opcion == 5){
            // Instruccion para saber si existe una caseta con un determinado numero
            // El numero de la caseta no se auto incrementa en la base de datos para no perder ese numero en caso de que se borre una caseta, ya que es preferible tener las caseta ordenadas desde el 1
            new LoadDatos_AsyncTask().execute("http://albertoarandamedac.tk/getCasetaNumero.php?numeroCaseta=");

        }
        else if (opcion == 6){
            // Instruccion para saber si existe una caseta con un determinado nombre
            new LoadDatos_AsyncTask().execute("http://albertoarandamedac.tk/getCaseta.php?nombreCaseta=");
        }
        else if (opcion == 7){
            // Instruccion para saber las casetas de un determinado tipo (libres o privadas)
            new LoadDatos_AsyncTask().execute("http://albertoarandamedac.tk/getCaseta.php?nombreCaseta=");
        }


        return bExiste;
    }

    private static class LoadDatos_AsyncTask extends AsyncTask<String, Void, Void> {
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

            if(opcion==1) {

                Gson gson = new Gson();
                Type type = new TypeToken<List<Caseta>>() {
                }.getType();


                lstCasetas = gson.fromJson(resultado, type);
                if (lstCasetas == null) {
                    bExiste = false;
                } else {
                    Datos.casetas = lstCasetas;
                    bExiste = true;
                }
            }
            else if (opcion==2){

            }
            else if (opcion==3){

            }
            else if (opcion==4){

            }
            else if (opcion==5){

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
