package com.numericsystool.flycat.numericsys.metodos;

import javax.xml.transform.Result;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class Lagrange extends Base {

    private String Resultado;

    public Lagrange() {
        this.espaciado = 0;
        this.decimales = 10;
        Resultado = "";
    }

    public String getResultado() {
        return Resultado;
    }

    public double evaluar(double[] xi, double[] fxi, double x) {

        int n = xi.length;

        double[] Lxi = new double[n];
        double Pnx = 0;

        Resultado += this.reportarcoordenadas(xi, fxi);

        Resultado += ("x = " + x + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");
        Resultado += ("Y(x)=[" + System.getProperty("line.separator"));

        for (int i = 0; i < n; i++) {
            Resultado += (this.redondear(fxi[i]) + System.getProperty("line.separator"));
            Resultado += (" * " + System.getProperty("line.separator"));
            Lxi[i] = this.Lagrangeix(x, i, xi, n);

            Pnx = Pnx + Lxi[i] * fxi[i];

            Resultado += System.getProperty("line.separator");
        }

        Resultado += ("]" + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");
        Resultado += ("Resultado:" + System.getProperty("line.separator"));
        Resultado += ("Pnx=" + this.redondear(Pnx) + System.getProperty("line.separator"));

        return Pnx;
    }

    public double Lagrangeix(double x, int i, double[] xi, int n) {
        double Prod;
        Prod = 1;
        for (int j = 0; j < n; j++) {
            if (i != j) {
                Resultado += ("((x-" + this.redondear(xi[j]) + ")/(" + this.redondear(xi[i]) + " - "
                        + this.redondear(xi[j]) + "))" + System.getProperty("line.separator"));
                Prod = Prod * ((x - xi[j]) / (xi[i] - xi[j]));
                if (j == (n - 1)) {
                    Resultado += (" + " + System.getProperty("line.separator"));
                }
            }
        }
        return Prod;
    }
}
