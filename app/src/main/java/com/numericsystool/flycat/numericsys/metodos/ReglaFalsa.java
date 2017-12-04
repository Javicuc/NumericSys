package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class ReglaFalsa extends Base{

    public String getResultado() {
        return Result;
    }

    private String Result;

    public ReglaFalsa() {
        Result = "";
    }

    public double evaluar(Funcion funcion, double xa, double xb, double e) {
        return this.evaluar(funcion, xa, xb, e, 100);
    }

    public double evaluar(Funcion funcion, double xa, double xb, double e, int n) {

        Result += ("Xa: "+ xa + System.getProperty("line.separator"));
        Result += ("Xb: "+ xb + System.getProperty("line.separator"));
        Result += (" e: "+ e  + System.getProperty("line.separator"));
        Result += (" n: "+ n  + System.getProperty("line.separator"));
        Result += System.getProperty("line.separator");

        this.funcion = funcion;
        double fb = funcion.evaluar(xb);
        double xi = 0;
        double fi = 0;
        int i = 0;
        n = n > 0 ? n - 1 : n;

        Result +=(
                this.redondear("N", 5, true)
                        + this.redondear("Xa")
                        + this.redondear("Xb")
                        + this.redondear("X inter.")
                        + this.redondear("f(X inter)")
                        + System.getProperty("line.separator"));

        do {
            i++;
            xi = this.getInterpolacion(xa, xb);
            fi = funcion.evaluar(xi);

            Result += (
                    this.redondearString(i + "", 5, true)
                            + this.redondear(xa)
                            + this.redondear(xb)
                            + this.redondear(xi)
                            + this.redondear(fi)
                            + System.getProperty("line.separator"));

            if ((fb * fi) > 0) {
                xb = xi;
            } else {
                xa = xi;
            }


        } while (i <= n && Math.abs(fi) > e);



        Result += "" + System.getProperty("line.separator");

        Result += ("Solución Encontrada:" + this.redondear(xi) + System.getProperty("line.separator"));
        Result += ("Valor de Comprobación:" + this.redondear(funcion.evaluar(xi)) + System.getProperty("line.separator"));

        return xi;
    }
}
