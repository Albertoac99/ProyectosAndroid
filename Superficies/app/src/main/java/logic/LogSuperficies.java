package logic;

import android.content.Context;
import android.widget.Toast;

import view.SupCirculo;
import view.SupHexagono;
import view.SupPentagono;
import view.SupRectangulo;
import view.SupTrapecio;
import view.SupTriangulo;

public class LogSuperficies {

    public static final Double PI = 3.1416;

    public static double areaCirculo() {

        Double radio = Double.parseDouble(SupCirculo.etxtRadioCirculo.getText().toString());

        Double resultado = Math.pow(radio,2) * PI;

        return resultado;
    }

    public static double areaHexagono() {

        Double perimetro = Double.parseDouble(SupHexagono.etxtLadoHexagono.getText().toString())*6;

        Double apotema = Double.parseDouble(SupHexagono.etxtApotemaHexagono.getText().toString());

        Double resultado = (perimetro * apotema) / 2;

        return resultado;
    }

    public static double areaPentagono() {

        Double perimetro = Double.parseDouble(SupPentagono.etxtLadoPentagono.getText().toString())*5;

        Double apotema = Double.parseDouble(SupPentagono.etxtApotemaPentagono.getText().toString());

        Double resultado = (perimetro * apotema) /2;

        return resultado;
    }

    public static double areaRectangulo() {

        Double base = Double.parseDouble(SupRectangulo.etxtBaseRectangulo.getText().toString());

        Double altura = Double.parseDouble(SupRectangulo.etxtAlturaRectangulo.getText().toString());

        Double resultado = base * altura;

        return resultado;
    }

    public static double areaTrapecio() {

        Double base = Double.parseDouble(SupTrapecio.etxtBaseTrapecio.getText().toString());

        Double baseSuperior = Double.parseDouble(SupTrapecio.etxtBaseSuperiorTrapecio.getText().toString());

        Double altura = Double.parseDouble(SupTrapecio.etxtAlturaTrapecio.getText().toString());

        Double resultado = ((base + baseSuperior) /2)*altura;

        return resultado;
    }

    public static double areaTriangulo() {

        Double base = Double.parseDouble(SupTriangulo.etxtBaseTriangulo.getText().toString());

        Double altura = Double.parseDouble(SupTriangulo.etxtAlturaTriangulo.getText().toString());

        Double resultado = (base * altura) / 2;

        return resultado;
    }

    public static void mostrarMensaje(Context context) {
        Toast.makeText(context, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
    }
}
