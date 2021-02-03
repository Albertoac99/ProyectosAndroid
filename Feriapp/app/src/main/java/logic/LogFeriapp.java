package logic;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import controller.ContInicio;
import model.Caseta;
import model.Cuenta;
import view.CrearUsuario;
import view.Inicio;
import view.ListaCasetas;
import view.Perfil;

import static logic.Datos.cuentas;
import static logic.Datos.opcion;
import static logic.Datos.posibleCuenta;

public class LogFeriapp {
    public static ArrayList<Caseta> lstCasetas;


    public static void mensajeCampos(String sMensaje, Context context) {
        Toast.makeText(context, sMensaje, Toast.LENGTH_SHORT).show();
    }

    public static void comprobarUsuarioContrasenia(){
        // Instruccion para saber si existe un usuario con una determinada contraseña en la base de datos (logueo)
        Log.i("ALBERTO", "llega al php");
        opcion=1;
        new Load1Dato_AsyncTask().execute("https://arandacastroalberto.000webhostapp.com/php/getUserPassword.php?usuario="+ Inicio.txtUsuarioLogueo.getText().toString() +"&contrasenia=" +Inicio.txtContraseñaLogueo.getText().toString());
    }

    public static void comprobarUsuario(){
        // Instruccion para comprobar si existe un usuario en la base de datos para luego registrarlo si no existe
        opcion = 2;
        new Load1Dato_AsyncTask().execute("https://arandacastroalberto.000webhostapp.com/php/getUser.php?usuario="+CrearUsuario.txtUsuarioRegistro.getText().toString());
    }

    public static void crearUsuario(){

        new InsertarValores().execute("https://arandacastroalberto.000webhostapp.com/php/insertarUsuario.php?" +
                "usuario="+CrearUsuario.txtUsuarioRegistro.getText().toString()+"&contrasenia="+CrearUsuario.txtContraseñaRegistro.getText().toString()+"&tipoUsuario=0");

    }

    public static void traerCasetas(){
        // Intruccion para traer las casetas de la base de datos
        opcion = 1;
        new LoadDatos_AsyncTask().execute("https://arandacastroalberto.000webhostapp.com/php/getCasetas.php");
    }

    public static void traerTipoCaseta(int tipo){
        // Instruccion para filtrar el tipo de caseta ( publica o privada);
        opcion = 1;
        new LoadDatos_AsyncTask().execute("https://arandacastroalberto.000webhostapp.com/php/getCasetaLibre.php?tipoCaseta="+tipo);

    }

    public static void traerCasetasAforo(){
        // Instruccion para filtrar las casetas que tengan aforo disponible
        opcion = 1;
        new LoadDatos_AsyncTask().execute("https://arandacastroalberto.000webhostapp.com/php/getCasetasAforo.php");

    }


    public static void actualizarUsuario() {
        // Instruccion para actualizar el nombre y la contraseña de un usuario
        new ActualizarValor().execute("https://arandacastroalberto.000webhostapp.com/php/updateUsuario.php?usuarioNuevo="+Perfil.txtNuevoUsuario.getText().toString()
                +"&contraseniaNueva="+Perfil.txtNuevaContrasenia.getText().toString()+"&usuario="+ cuentas.get(0).getUsuario());

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
            Gson gson = new Gson();
            if (opcion ==1) {

                Type type = new TypeToken<List<Caseta>>() {}.getType();

                Datos.casetas = gson.fromJson(resultado, type);

                Intent intent = new Intent(Inicio.context, ListaCasetas.class);

                Inicio.context.startActivity(intent);
            }
            else if(opcion == 2){

            }

        }


    }

    private static class Load1Dato_AsyncTask extends AsyncTask<String, Void, Void>{
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

            if(opcion == 1){
                Type type = new TypeToken<List<Cuenta>>() {}.getType();

                cuentas = gson.fromJson(resultado, type);


                if (Datos.cuentas.size()>0) {
                    // Escribir en las Preferencias
                    SharedPreferences.Editor editorPreferencias = Inicio.pref.edit();
                    editorPreferencias.putString("Id", ""+cuentas.get(0).getIdCuenta());
                    editorPreferencias.putString("Usuario",cuentas.get(0).getUsuario());
                    editorPreferencias.putString("Contrasenia",cuentas.get(0).getContrasenia());
                    editorPreferencias.putString("TipoUsuario", ""+cuentas.get(0).getTipoUsuario());
                    editorPreferencias.apply();
                    LogFeriapp.traerCasetas();
                } else {
                    LogFeriapp.mensajeCampos("Usuario o contraseña incorrecto", Inicio.context);
                }

            }
            else if(opcion ==2){
                Type type = new TypeToken<List<Cuenta>>() {}.getType();

                cuentas = gson.fromJson(resultado, type);

                if (Datos.cuentas.size()==0) {

                    LogFeriapp.crearUsuario();

                } else {
                    LogFeriapp.mensajeCampos("Ya existe un usuario con ese nombre", Inicio.context);
                }

            }
            else if (opcion == 3){
                Type type = new TypeToken<List<Cuenta>>() {}.getType();

                posibleCuenta = gson.fromJson(resultado, type);

                if (posibleCuenta.size()==0){
                    LogFeriapp.actualizarUsuario();
                }
                else{
                    LogFeriapp.mensajeCampos("Ya existe un usuario con ese nombre", Perfil.context);
                }

            }

        }
    }

    private static class InsertarValores extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try{
                URL url = new URL(params[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            }catch (IOException e){
                e.getMessage();
            }


            return null;
        }

        @Override
        public void onPostExecute(Void aVoid){
            Intent intent = new Intent(CrearUsuario.context, Inicio.class);

            CrearUsuario.context.startActivity(intent);

        }
    }

    private static class ActualizarValor extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {

            try{
                URL url = new URL(params[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            }catch (IOException e){
                e.getMessage();
            }


            return null;
        }

        @Override
        public void onPostExecute(Void aVoid){
            Intent intent = new Intent(Perfil.context, ListaCasetas.class);

            Perfil.context.startActivity(intent);

        }


    }


    public static void download() {

        String url = "https://arandacastroalberto.000webhostapp.com/php/imagenes/"+cuentas.get(0).getIdCuenta()+".jpg";

        Perfil.imgFotoPerfil.setImageDrawable(null);

        Glide
                .with(Perfil.context)
                .load(url)
                .apply(RequestOptions.centerCropTransform())
                .into(Perfil.imgFotoPerfil);



    }
}
