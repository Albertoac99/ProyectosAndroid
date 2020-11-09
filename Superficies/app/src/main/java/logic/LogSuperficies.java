package logic;

import android.content.Context;
import android.graphics.Rect;
import android.widget.EditText;
import android.widget.Toast;

import view.Circulo;
import view.Hexagono;
import view.Pentagono;
import view.Rectangulo;
import view.Trapecio;
import view.Triangulo;

public class LogSuperficies {

    public static final Double PI = 3.1416;

    public static double areaCirculo() {

        Double radio = Double.parseDouble(Circulo.etxtRadioCirculo.getText().toString());

        Double resultado = Math.pow(radio,2) * PI;

        return resultado;
    }

    public static double areaHexagono() {

        Double perimetro = Double.parseDouble(Hexagono.etxtLadoHexagono.getText().toString())*6;

        Double apotema = Double.parseDouble(Hexagono.etxtApotemaHexagono.getText().toString());

        Double resultado = (perimetro * apotema) / 2;

        return resultado;
    }

    public static double areaPentagono() {

        Double perimetro = Double.parseDouble(Pentagono.etxtLadoPentagono.getText().toString())*5;

        Double apotema = Double.parseDouble(Pentagono.etxtApotemaPentagono.getText().toString());

        Double resultado = (perimetro * apotema) /2;

        return resultado;
    }

    public static double areaRectangulo() {

        Double base = Double.parseDouble(Rectangulo.etxtBaseRectangulo.getText().toString());

        Double altura = Double.parseDouble(Rectangulo.etxtAlturaRectangulo.getText().toString());

        Double resultado = base * altura;

        return resultado;
    }

    public static double areaTrapecio() {

        Double base = Double.parseDouble(Trapecio.etxtBaseTrapecio.getText().toString());

        Double baseSuperior = Double.parseDouble(Trapecio.etxtBaseSuperiorTrapecio.getText().toString());

        Double altura = Double.parseDouble(Trapecio.etxtAlturaTrapecio.getText().toString());

        Double resultado = ((base + baseSuperior) /2)*altura;

        return resultado;
    }

    public static double areaTriangulo() {

        Double base = Double.parseDouble(Triangulo.etxtBaseTriangulo.getText().toString());

        Double altura = Double.parseDouble(Triangulo.etxtAlturaTriangulo.getText().toString());

        Double resultado = (base * altura) / 2;

        return resultado;
    }

    public static void mostrarMensaje(Context context) {
        Toast.makeText(context, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
    }
}
