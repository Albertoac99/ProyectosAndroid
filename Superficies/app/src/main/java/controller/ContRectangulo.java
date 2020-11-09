package controller;

import logic.LogSuperficies;
import view.SupRectangulo;

public class ContRectangulo {
    public static void areaRectangulo() {
        String base = SupRectangulo.etxtBaseRectangulo.getText().toString();
        String altura = SupRectangulo.etxtAlturaRectangulo.getText().toString();

        if (base.equals("") || altura.equals("")) {

            LogSuperficies.mostrarMensaje(SupRectangulo.context);
        }
        else{

            SupRectangulo.txtAreaRectangulo.setText(""+ LogSuperficies.areaRectangulo());
        }
    }
}
