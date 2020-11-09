package controller;

import logic.LogSuperficies;
import view.SupPentagono;

public class ContPentagono {
    public static void areaPentagono() {
        String lado = SupPentagono.etxtLadoPentagono.getText().toString();
        String apotema = SupPentagono.etxtApotemaPentagono.getText().toString();
        if(lado.equals("") || apotema.equals("")){
            LogSuperficies.mostrarMensaje(SupPentagono.context);
        }
        else{
            SupPentagono.txtAreaPentagono.setText(""+ LogSuperficies.areaPentagono());
        }

    }
}
