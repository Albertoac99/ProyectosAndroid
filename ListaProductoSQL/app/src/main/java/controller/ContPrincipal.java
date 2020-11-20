package controller;

import android.widget.Toast;

import java.util.List;

import logic.Datos;
import logic.LogPrincipal;
import model.Producto;
import view.Nuevo;
import view.Principal;

public class ContPrincipal {
    public static void insertarProducto() {

        String strNombre = Nuevo.etxtNombre.getText().toString();
        String strPrecio = Nuevo.etxtPrecio.getText().toString();
        float fltNumStars = Nuevo.edtStars.getRating();
        boolean fragil = Nuevo.swtFragil.isChecked();
        int envoltorio = Nuevo.radBoton.getCheckedRadioButtonId();
        int ciudad = (int) Nuevo.lista2.getSelectedItemId();
        int proveedor = (int) Nuevo.lista1.getSelectedItemId();





        if(strNombre.equals("") || strPrecio.equals("") || envoltorio==0 || ciudad==0 || proveedor==0){
            mostrarMensaje("Todos los campos son obligatorios");
        }
        else{
            LogPrincipal.insertProducto(Principal.context, new Producto(strNombre,strPrecio,fltNumStars,fragil,envoltorio,ciudad,proveedor));
            mostrarMensaje("El producto "+strNombre+" ha sido insertado correctamente.");
            LimpiarCuadros();
        }
    }




    public static void EliminarProducto() {
        String strNombre = Nuevo.etxtNombre.getText().toString();
        String strPrecio = Nuevo.etxtPrecio.getText().toString();
        float fltNumStars = Nuevo.edtStars.getRating();
        boolean fragil = Nuevo.swtFragil.isChecked();
        int envoltorio = Nuevo.radBoton.getCheckedRadioButtonId();
        int ciudad = (int) Nuevo.lista2.getSelectedItemId();
        int proveedor = (int) Nuevo.lista1.getSelectedItemId();

        LogPrincipal.borrarProducto(Principal.context, new Producto(strNombre,strPrecio,fltNumStars,fragil,envoltorio,ciudad,proveedor));
    }

    public static void EditarProducto() {
        String strNombre = Nuevo.etxtNombre.getText().toString();
        String strPrecio = Nuevo.etxtPrecio.getText().toString();
        float fltNumStars = Nuevo.edtStars.getRating();
        boolean fragil = Nuevo.swtFragil.isChecked();
        int envoltorio = Nuevo.radBoton.getCheckedRadioButtonId();
        int ciudad = (int) Nuevo.lista2.getSelectedItemId();
        int proveedor = (int) Nuevo.lista1.getSelectedItemId();

        LogPrincipal.editarProducto(Principal.context, new Producto(strNombre,strPrecio,fltNumStars,fragil,envoltorio,ciudad,proveedor));
    }

    public static void BuscarProducto() {
    }

    public static void ListarProducto() {
        List<Producto> lista = LogPrincipal.ListaProducto(Principal.context);

        if(lista.size()==0){
            mostrarMensaje("La base de datos está vacía");
        }
        else{
            StringBuilder contenido = new StringBuilder();
            for(Producto producto : lista){
                contenido.append(producto).append("\n");
            }

        }


    }







    private static void LimpiarCuadros() {
    }

    private static void mostrarMensaje(String msg) {
        Toast.makeText(Principal.context, msg, Toast.LENGTH_SHORT).show();
    }

}
