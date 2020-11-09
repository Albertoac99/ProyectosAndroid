package controller;

import logic.LogSuperficies;
import view.SupTriangulo;

public class ContTriangulo {
    public static void areaTriangulo() {
        String base = SupTriangulo.etxtBaseTriangulo.getText().toString();
        String altura = SupTriangulo.etxtAlturaTriangulo.getText().toString();

        if (base.equals("") || altura.equals("")) {

            LogSuperficies.mostrarMensaje(SupTriangulo.context);
        }
        else{

            SupTriangulo.txtAreaTriangulo.setText(""+ LogSuperficies.areaTriangulo());
        }
    }
}
