package controller;

import logic.LogSuperficies;
import view.Rectangulo;

public class ContRectangulo {
    public static void areaRectangulo() {
        String base = Rectangulo.etxtBaseRectangulo.getText().toString();
        String altura = Rectangulo.etxtAlturaRectangulo.getText().toString();

        if (base.equals("") || altura.equals("")) {

            LogSuperficies.mostrarMensaje(Rectangulo.context);
        }
        else{

            Rectangulo.txtAreaRectangulo.setText(""+ LogSuperficies.areaRectangulo());
        }
    }
}
