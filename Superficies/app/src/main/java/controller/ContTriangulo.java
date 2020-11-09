package controller;

import logic.LogSuperficies;
import view.Triangulo;

public class ContTriangulo {
    public static void areaTriangulo() {
        String base = Triangulo.etxtBaseTriangulo.getText().toString();
        String altura = Triangulo.etxtAlturaTriangulo.getText().toString();

        if (base.equals("") || altura.equals("")) {

            LogSuperficies.mostrarMensaje(Triangulo.context);
        }
        else{

            Triangulo.txtAreaTriangulo.setText(""+ LogSuperficies.areaTriangulo());
        }
    }
}
