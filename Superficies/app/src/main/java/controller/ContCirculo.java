package controller;

import logic.LogSuperficies;
import view.SupCirculo;

public class ContCirculo {
    public static void areaCirculo() {
        String radio = SupCirculo.etxtRadioCirculo.getText().toString();
        if(radio.equals("")){
            LogSuperficies.mostrarMensaje(SupCirculo.context);
        }
        else{
            SupCirculo.txtAreaCirculo.setText(""+ LogSuperficies.areaCirculo());
        }
    }
}
