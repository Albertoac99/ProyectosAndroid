package controller;

import logic.LogSuperficies;
import view.Circulo;

public class ContCirculo {
    public static void areaCirculo() {
        String radio = Circulo.etxtRadioCirculo.getText().toString();
        if(radio.equals("")){
            LogSuperficies.mostrarMensaje(Circulo.context);
        }
        else{
            Circulo.txtAreaCirculo.setText(""+ LogSuperficies.areaCirculo());
        }
    }
}
