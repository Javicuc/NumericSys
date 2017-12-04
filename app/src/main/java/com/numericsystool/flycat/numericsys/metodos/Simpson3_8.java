package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class Simpson3_8 extends Base {

    private String Resultado;

    public String getResultado() {
        return Resultado;
    }

    public Simpson3_8() {
        this.espaciado = 0;
        this.decimales = 10;
        Resultado = "";
    }

    public double evaluar(Funcion funcion, double x0, double x1, double x2, double x3) {

        Resultado += ("x0: " + x0 + System.getProperty("line.separator"));
        Resultado += ("x1: " + x1 + System.getProperty("line.separator"));
        Resultado += ("x2: " + x2 + System.getProperty("line.separator"));
        Resultado += ("x3: " + x3 + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        double result = 0;
        result += funcion.evaluar(x0);

        double partes = 0;

        partes += 3 * funcion.evaluar(x1);
        partes += 3 * funcion.evaluar(x2);

        result += partes;

        result += funcion.evaluar(x3);
        result /= 8;
        result *= (x3 - x0);

        Resultado += System.getProperty("line.separator");
        Resultado += ("Resultado:" + System.getProperty("line.separator"));
        Resultado += (this.redondear(result) + System.getProperty("line.separator"));

        return result;
    }
}
