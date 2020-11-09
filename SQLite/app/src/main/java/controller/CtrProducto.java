package controller;

import android.widget.Toast;

import java.util.List;

import logic.LogProducto;
import model.Producto;
import view.FrmProducto;

public class CtrProducto {
    public static void insertarProducto() {
    String strNombre = FrmProducto.txtNombre.getText().toString();
    String strPrecio = FrmProducto.txtPrecio.getText().toString();
    int intSeccion = FrmProducto.lstSeccion.getSelectedItemPosition();

    if(strNombre.equals("") || strPrecio.equals("")){
        mostrarMensaje("Todos los campos son obligatorios");
    }
    else{
        LogProducto.insertProducto(FrmProducto.context, new Producto(null, strNombre,Double.parseDouble(strPrecio),(long)intSeccion));
        mostrarMensaje("El producto "+strNombre+" ha sido insertado correctamente.");
        LimpiarCuadros();
    }
    }




    public static void EliminarProducto() {
    }

    public static void EditarProducto() {
    }

    public static void BuscarProducto() {
    }

    public static void ListarProducto() {
        List<Producto> lista = LogProducto.ListaProducto(FrmProducto.context);
        FrmProducto.txtResultados.setText("");

        if(lista.size()==0){
            mostrarMensaje("La base de datos está vacía");
        }
        else{
            StringBuilder contenido = new StringBuilder();
            for(Producto producto : lista){
                contenido.append(producto).append("\n");
            }

            FrmProducto.txtResultados.append(contenido);
        }


    }







    private static void LimpiarCuadros() {
        FrmProducto.txtNombre.setText("");
        FrmProducto.txtPrecio.setText("");
    }

    private static void mostrarMensaje(String msg) {
        Toast.makeText(FrmProducto.context, msg, Toast.LENGTH_SHORT).show();
    }



}
