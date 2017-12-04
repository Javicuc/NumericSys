package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class NewtonRaphson extends Base {

    private String Resultado;

    public String getResultado() {
        return Resultado;
    }

    public NewtonRaphson() {
        Resultado = "";
    }

    public double evaluar(Funcion funcion, Funcion derivada, double x0, double e) {
        return this.evaluar(funcion, derivada, x0, e, 100);
    }

    public double evaluar(Funcion funcion, double x0, double e) {
        return this.evaluar(funcion, null, x0, e, 100);
    }

    public double evaluar(Funcion funcion, double x0, double e, int n) {
        return this.evaluar(funcion, null, x0, e, n);
    }

    public double evaluar(Funcion funcion, Funcion derivada, double x0, double e, int n) {

        Resultado += ("X0: " + x0 + System.getProperty("line.separator"));
        Resultado += (" e: " +  e + System.getProperty("line.separator"));
        Resultado += (" n: " +  n + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        this.funcion = funcion;
        double f0 = funcion.evaluar(x0);
        double deriv_fxo = 0;
        double previo = x0;

        int i = 1;

        Resultado += (
                this.redondear("N", 5, true)
                        + this.redondear("Aprox. la raiz")
                        + this.redondear("Error Relativo aprox.")
                        + System.getProperty("line.separator"));

        Resultado += (
                this.redondear(i + "", 5, true)
                        + this.redondear(x0)
                        + this.redondear("")
                        + System.getProperty("line.separator"));

        while (i < n && Math.abs(f0) > e) {

            i++;
            if (derivada == null) {
                deriv_fxo = this.derivar(x0);
            } else {
                deriv_fxo = derivada.evaluar(x0);
            }

            x0 = x0 - f0 / deriv_fxo;
            f0 = funcion.evaluar(x0);

            Resultado += (
                    this.redondear(i + "", 5, true)
                            + this.redondear(x0)
                            + this.redondear(this.redondear(this.getErrorRelativoAproximado(x0, previo), this.decimales - 1) + "%")
                            + System.getProperty("line.separator"));
            previo = x0;
        }

        Resultado += System.getProperty("line.separator");
        if (Math.abs(f0) > e) {
            Resultado += ("No hay convergencia, no hay solucion" + System.getProperty("line.separator"));
            return 0;
        } else {
            Resultado += ("Solucion Estimada:" + this.redondear(x0) + System.getProperty("line.separator"));
            Resultado += ("Valor de Comprobacion:" + this.redondear(f0) + System.getProperty("line.separator"));
            return x0;
        }
    }
}
