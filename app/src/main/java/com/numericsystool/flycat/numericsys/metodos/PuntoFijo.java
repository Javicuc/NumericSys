package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class PuntoFijo extends Base {

    private String Resultado;

    public PuntoFijo() {
        Resultado = "";
    }

    public double evaluar(Funcion funcion, Funcion mejorado, double x0, double e) {
        return this.evaluar(funcion, mejorado, x0, e, 100);
    }

    public double evaluar(Funcion funcion, Funcion mejorado, double x0, double e, int n) {

        Resultado += ("X0: " + x0 + System.getProperty("line.separator"));
        Resultado += (" e: " +  e + System.getProperty("line.separator"));
        Resultado += (" n: " +  n + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        this.funcion = funcion;
        double xm = 0;
        double q = 0;
        int i = 0;


        Resultado += (
                this.redondear("N", 5, true)
                        + this.redondear("X0")
                        + this.redondear("X Mejorado")
                        + System.getProperty("line.separator"));

        do {
            i++;
            xm = mejorado.evaluar(x0);

            Resultado += (
                    this.redondear(i + "", 5, true)
                            + this.redondear(x0)
                            + this.redondear(xm)
                            + System.getProperty("line.separator"));

            q = Math.abs(xm - x0);
            x0 = xm;


        } while (i < n && q > e);


        if (q > e) {
            Resultado += ("No hay Convergencia" + System.getProperty("line.separator"));
            return 0;
        } else {

            Resultado += System.getProperty("line.separator");

            Resultado += ("Solucion Encontrada:" + this.redondear(xm) + System.getProperty("line.separator"));
            Resultado += ("Valor de Comprobacion:" + this.redondear(funcion.evaluar(xm)) + System.getProperty("line.separator"));

            return xm;
        }
    }

    public String getResultado() {
        return Resultado;
    }
}