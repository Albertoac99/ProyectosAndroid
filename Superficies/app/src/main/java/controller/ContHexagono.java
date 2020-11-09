package controller;

import logic.LogSuperficies;
import view.Hexagono;

public class ContHexagono {
    public static void areaHexagono() {

        String lado = Hexagono.etxtLadoHexagono.getText().toString();
        String apotema = Hexagono.etxtApotemaHexagono.getText().toString();

        if(lado.equals("") || apotema.equals("")){
            LogSuperficies.mostrarMensaje(Hexagono.context);
        }
        else{
            Hexagono.txtAreaHexagono.setText(""+ LogSuperficies.areaHexagono());
        }

    }
}
