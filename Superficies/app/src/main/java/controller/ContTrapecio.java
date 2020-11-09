package controller;

import logic.LogSuperficies;
import view.SupTrapecio;

public class ContTrapecio {
    public static void areaTrapecio() {
        String base = SupTrapecio.etxtBaseTrapecio.getText().toString();
        String baseSuperior = SupTrapecio.etxtBaseSuperiorTrapecio.getText().toString();
        String altura = SupTrapecio.etxtAlturaTrapecio.getText().toString();

        if (base.equals("") || altura.equals("") || baseSuperior.equals("")) {

            LogSuperficies.mostrarMensaje(SupTrapecio.context);
        }
        else{

            SupTrapecio.txtAreaTrapecio.setText(""+ LogSuperficies.areaTrapecio());
        }
    }
}
