package controller;

import logic.LogSuperficies;
import view.Pentagono;

public class ContPentagono {
    public static void areaPentagono() {
        String lado = Pentagono.etxtLadoPentagono.getText().toString();
        String apotema = Pentagono.etxtApotemaPentagono.getText().toString();
        if(lado.equals("") || apotema.equals("")){
            LogSuperficies.mostrarMensaje(Pentagono.context);
        }
        else{
            Pentagono.txtAreaPentagono.setText(""+ LogSuperficies.areaPentagono());
        }

    }
}
