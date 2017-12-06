package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class Simpson1_3 extends Base {

    private String Resultado;

    public String getResultado() {
        return Resultado;
    }

    public Simpson1_3() {
        this.espaciado = 0;
        this.decimales = 10;
        Resultado = "";
    }

    public double evaluar(Funcion funcion, double a, double b) {

        Resultado += ("a: " + a + System.getProperty("line.separator"));
        Resultado += ("b: " + b + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        double result = 0;
        result += funcion.evaluar(a);

        double xm = (a + b) / 2;

        result += 4 * funcion.evaluar(xm);

        result += funcion.evaluar(b);
        result *= ((b - a) / 6);

        Resultado += System.getProperty("line.separator");
        Resultado += ("Resultado:" + System.getProperty("line.separator"));
        Resultado += (this.redondear(result) + System.getProperty("line.separator"));

        return result;

    }
}
