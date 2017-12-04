package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

public class Biseccion extends Base {

    private String Resultado;

    public Biseccion() {
        this.Resultado = "";
    }
    public String getResultado() {
        return Resultado;
    }
    /**
     *
     * @param funcion funcion a evaluar
     * @param xa valor de Xa
     * @param xb valir de Xb
     * @param e la tolerancia
     * @return el resultado del metodo
     */
    public double evaluar(Funcion funcion, double xa, double xb, double e) {

        Resultado += "Xa: " + xa + System.getProperty("line.separator");
        Resultado += "Xb: " + xb + System.getProperty("line.separator");
        Resultado += " e: " + e  + System.getProperty("line.separator");
        Resultado += System.getProperty("line.separator");

        this.funcion = funcion;
        double fb = funcion.evaluar(xb);
        double xm = 0;
        double x = 0;
        double previo = 0;
        int i = 0;

        Resultado += (
                this.redondear("N", 5, true)
                        + this.redondear("a",13,false)
                        + this.redondear("b",13,false)
                        + this.redondear("c",13,false)
                        + this.redondear("f(a)",13,false)
                        + this.redondear("f(b)",13,false)
                        + this.redondear("f(c)",13,false)
                        + this.redondear("E",13,false)
                        + System.getProperty("line.separator"));
        do {
            i++;
            xm = (xa + xb) / 2;
            double tmpxa, tmpxb;
            tmpxa = xa;
            tmpxb = xb;

            if ((fb * funcion.evaluar(xm)) > 0) {
                xb = xm;
            } else {
                xa = xm;
            }

            Resultado += (
                    this.redondear(i + "", 5, true)
                            + this.redondear(tmpxa,1,12,false)
                            + this.redondear(xm,1,12,false)
                            + this.redondear(tmpxb,1,12,false)
                            + this.redondear(funcion.evaluar(tmpxa),1,12,false)
                            + this.redondear(funcion.evaluar(xm),1,12,false)
                            + this.redondear(funcion.evaluar(tmpxb),1,12,false)
                            + this.redondear(this.getErrorAproximado(xm, previo),1,12,false)
                            + System.getProperty("line.separator"));
            previo = xm;
        } while (Math.abs(xb - xa) > Math.abs(e));

        Resultado += " " + System.getProperty("line.separator");

        x = this.getInterpolacion(xa, xb);

        Resultado += ("Solucion Estimada:" + this.redondear(x) + System.getProperty("line.separator"));
        Resultado += ("Valor de Comprobacion:" + this.redondear(funcion.evaluar(x)) + System.getProperty("line.separator"));

        return x;
    }
}
