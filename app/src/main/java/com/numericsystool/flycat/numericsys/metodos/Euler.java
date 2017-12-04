package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

import javax.xml.transform.Result;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class Euler extends Base {

    private String Resultado;

    public String getResultado() {
        return Resultado;
    }

    public Euler() {
        this.espaciado = 0;
        this.decimales = 5;
        Resultado = "";
    }

    public double evaluar(Funcion funcion, double x0, double x1, double y, int n) {

        Resultado += ("x0: " + x0 + System.getProperty("line.separator"));
        Resultado += ("x1: " + x1 + System.getProperty("line.separator"));
        Resultado += (" y: " +  y + System.getProperty("line.separator"));
        Resultado += (" n: " +  n + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        double result = 0;
        double f, h;
        double X[] = new double[n + 1];
        double Y[] = new double[n + 1];
        h = (x1 - x0) / n;

        Resultado += ("h: " + h + System.getProperty("line.separator"));
        X[0] = x0;
        Resultado += ("Y" + 0 + ": " + Y[0] + System.getProperty("line.separator"));
        Y[0] = y;
        Resultado += ("X" + 0 + ": " + Y[0] + System.getProperty("line.separator"));
        Resultado += ("---------------------------------" + System.getProperty("line.separator"));
        for (int i = 0; i < n; i++) {
            f = funcion.evaluar(X[i], Y[i]);
            Resultado += ("f x" + (i) + "y" + (i) + " : " + f + System.getProperty("line.separator"));
            Y[i + 1] = Y[i] + (h * f);
            Resultado += ("Y" + (i + 1) + ": " + Y[i + 1] + System.getProperty("line.separator"));
            X[i + 1] = X[i] + h;
            Resultado += ("X" + (i + 1) + ": " + X[i + 1] + System.getProperty("line.separator"));
            Resultado += ("---------------------------------" + System.getProperty("line.separator"));
        }
        result = Y[n];

        Resultado += this.reportarcoordenadas(X, Y);

        Resultado += (System.getProperty("line.separator"));
        Resultado += ("Resultado:" + System.getProperty("line.separator"));
        Resultado += (this.redondear(result) + System.getProperty("line.separator"));

        return result;
    }
}