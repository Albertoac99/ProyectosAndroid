package controller;

import android.widget.Toast;

import java.util.List;

import logic.AdaptadorProducto;
import logic.LogProducto;
import model.Producto;
import view.Editar;
import view.Principal;

public class ContProducto {
    public static void insertarProducto() {
        String strNombre = Editar.etxtNombre.getText().toString();
        String strPrecio = Editar.etxtPrecio.getText().toString();
        float fltEstrellas = Editar.edtStars.getRating();
        boolean bolFragil = Editar.swtFragil.isChecked();
        int intEnvoltorio= Editar.radBoton.getCheckedRadioButtonId();
        int intCiudad = (int) Editar.lista2.getSelectedItemId();
        int intProveedor = (int) Editar.lista1.getSelectedItemId();



        if(strNombre.equals("") || strPrecio.equals("") || intEnvoltorio==0 || intCiudad==0 || intProveedor==0)
        {
            mostrarMensaje("Todos los campos son obligatorios");
        }
        else{
            LogProducto.insertProducto(Principal.context, new Producto(strNombre, strPrecio,fltEstrellas,bolFragil,intEnvoltorio,intCiudad,intProveedor));
            mostrarMensaje("El producto "+strNombre+" ha sido insertado correctamente.");
            LimpiarCuadros();
        }
    }




    public static void EliminarProducto() {
    }

    public static void EditarProducto() {
    }

    public static void ListarProducto() {
        List<Producto> lista = LogProducto.ListaProducto(Principal.context);
        AdaptadorProducto.HolderProducto.txtNombre.setText("");

        if(lista.size()==0){
            mostrarMensaje("La base de datos está vacía");
        }
        else{
            StringBuilder contenido = new StringBuilder();
            for(Producto producto : lista){
                contenido.append(producto).append("\n");
            }

           // Principal.txtResultados.append(contenido);
        }


    }







    private static void LimpiarCuadros() {
        //Principal.txtNombre.setText("");
       // Principal.txtPrecio.setText("");
    }

    private static void mostrarMensaje(String msg) {
        //Toast.makeText(FrmProducto.context, msg, Toast.LENGTH_SHORT).show();
    }



}

