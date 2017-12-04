package com.numericsystool.flycat.numericsys.metodos;

import com.numericsystool.flycat.numericsys.funcion.Funcion;

/**
 * Created by Javicuc on 04/12/2017.
 */

public class RungeKutta extends Base {

    private String Resultado;

    public RungeKutta() {
        this.espaciado = 0;
        this.decimales = 5;
        Resultado = "";
    }

    public String getResultado() {
        return Resultado;
    }

    /**
     * El metodo orden4 encuentra la solucion de la ecuacion diferencial en un
     * punto.
     *
     * @param funcion funcion de la ecuacion diferencial
     * @param x0 valor en x anterior
     * @param y0 valor en y anterior
     * @param h incremento
     * @return valor de la ecuacion en el punto (y(x+h))
     */
    public double orden4(Funcion funcion, double x0, double y0, double h) {
        double F1 = funcion.evaluar(x0, y0);
        double F2 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F1);
        double F3 = funcion.evaluar(x0 + 0.5 * h, y0 + 0.5 * h * F2);
        double F4 = funcion.evaluar(x0 + h, y0 + h * F3);
        //System.out.println(+F1);
        //System.out.println(+F2);
        //System.out.println(+F3);
        //System.out.println(+F4);

        Resultado += ("" + this.redondear(y0) + " + (" + this.redondear(h) + " * (" + this.redondear(F1) + " + 2 * ("
                + this.redondear(F2) + " + " + this.redondear(F3) + ") + " + this.redondear(F4) + ")) / 6 = "
                + this.redondear(y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6) + System.getProperty("line.separator"));
        return y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6.0;
    }

    /**
     * El metodo evaluar guarda en una tabla los puntos solucion de la
     * ecuacion.
     *
     * @param funcion funcion de la ecuacion diferencial
     * @param x0 valor x inicial
     * @param y0 valor y inicial
     * @param xn valor x final
     * @param n cantidad de iteraciones
     * @return tabla con los valores de la funcion
     */
    public double[] evaluar(Funcion funcion, double x0, double y0, double xn, int n) {

        Resultado += ("x0: " + x0 + System.getProperty("line.separator"));
        Resultado += ("y0: " + y0 + System.getProperty("line.separator"));
        Resultado += ("xn: " + xn + System.getProperty("line.separator"));
        Resultado += (" n: " +  n + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        double[] Y = new double[n + 1];
        double[] X = new double[n + 1];

        this.inicializar(X, x0);
        double h = (xn - x0) / n;
        Y[0] = y0;
        X[0] = x0;
        for (int i = 0; i < n; i++) {
            Resultado += ("I=" + i + System.getProperty("line.separator"));
            y0 = this.orden4(funcion, x0, y0, h);
            x0 += h;
            X[i + 1] = x0;
            Y[i + 1] = y0;
        }

        Resultado += System.getProperty("line.separator");
        Resultado += ("Resultado:" + System.getProperty("line.separator"));
        Resultado += this.reportarcoordenadas(X, Y);
        
        return Y;
    }
}
