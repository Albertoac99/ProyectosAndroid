package controller;

import logic.LogSuperficies;
import view.Trapecio;

public class ContTrapecio {
    public static void areaTrapecio() {
        String base = Trapecio.etxtBaseTrapecio.getText().toString();
        String baseSuperior = Trapecio.etxtBaseSuperiorTrapecio.getText().toString();
        String altura = Trapecio.etxtAlturaTrapecio.getText().toString();

        if (base.equals("") || altura.equals("") || baseSuperior.equals("")) {

            LogSuperficies.mostrarMensaje(Trapecio.context);
        }
        else{

            Trapecio.txtAreaTrapecio.setText(""+ LogSuperficies.areaTrapecio());
        }
    }
}
