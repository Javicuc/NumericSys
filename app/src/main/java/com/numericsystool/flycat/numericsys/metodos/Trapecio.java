package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class Trapecio extends Base{

    private String Resultado;

    public String getResultado() {
        return Resultado;
    }

    public Trapecio() {
        this.espaciado = 0;
        this.decimales = 10;
        Resultado = "";
    }

    public double evaluar(Funcion funcion, double a, double b) {

        Resultado += ("a: " + a + System.getProperty("line.separator"));
        Resultado += ("b: " + b + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        double result = ((b - a) / 2) * (funcion.evaluar(a) + funcion.evaluar(b));

        Resultado += System.getProperty("line.separator");
        Resultado += ("Resultado:" + System.getProperty("line.separator"));
        Resultado += (this.redondear(result) + System.getProperty("line.separator"));

        return result;
    }

}
