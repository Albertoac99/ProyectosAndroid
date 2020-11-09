package controller;

import logic.LogSuperficies;
import view.SupHexagono;

public class ContHexagono {
    public static void areaHexagono() {

        String lado = SupHexagono.etxtLadoHexagono.getText().toString();
        String apotema = SupHexagono.etxtApotemaHexagono.getText().toString();

        if(lado.equals("") || apotema.equals("")){
            LogSuperficies.mostrarMensaje(SupHexagono.context);
        }
        else{
            SupHexagono.txtAreaHexagono.setText(""+ LogSuperficies.areaHexagono());
        }

    }
}
