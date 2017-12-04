package com.numericsystool.flycat.numericsys.metodos;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class GaussJacobi extends GaussSeidel {

    private String Resultado;

    public GaussJacobi() {
        Resultado = "";
    }

    @Override
    public String getResultado() {
        return Resultado;
    }

    public double[][] evaluar(double[][] matriz, double error, int limite) {

        Resultado += ("e: " + error + System.getProperty("line.separator"));
        Resultado += ("n: " + limite + System.getProperty("line.separator"));
        Resultado += System.getProperty("line.separator");

        boolean ok = false;
        double[][] matriz_original = this.clonar(matriz);
        int n = matriz.length;

        double[] Xa = new double[n];
        double[] Xp = new double[n];
        double[] Xt = new double[n];
        Xp = this.inicializar(Xp);
        Xa = this.inicializar(Xa);
        Xt = this.inicializar(Xt);

        Resultado += this.reportarmatriz(matriz);
        for (int k = 0; k < limite; k++) {

            Resultado += ("--------" + System.getProperty("line.separator"));
            Resultado += ("I=" + k + System.getProperty("line.separator"));
            Resultado += ("--------" + System.getProperty("line.separator"));

            for (int i = 0; i < n; i++) {

                double s = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        s = s + matriz[i][j] * Xa[j];
                    }
                }
                Resultado += ("Xt" + i + "=(M" + i + "" + n + "-s)/A" + i + "" + i + " = (" + this.redondear(matriz[i][n])
                        + "-" + this.redondear(s) + ")/" + this.redondear(matriz[i][i])
                        + "=" + this.redondear((matriz[i][n] - s) / matriz[i][i]) + System.getProperty("line.separator"));
                Xt[i] = (matriz[i][n] - s) / matriz[i][i];
            }

            Xa = this.actualizarX(Xt, Xa);
            Resultado += System.getProperty("line.separator");

            Resultado += ("Resultados Xa:");
            Resultado += ("[");
            for (int i = 0; i < n; i++) {
                Resultado += (this.redondear(Xa[i], this.decimales + 4, false) + (i < (n - 1) ? ", " : ""));
            }
            Resultado += ("]" + System.getProperty("line.separator"));

            Resultado += ("Resultados Xp:");
            Resultado += ("[");
            for (int i = 0; i < n; i++) {
                Resultado += (this.redondear(Xp[i], this.decimales + 4, false) + (i < (n - 1) ? ", " : ""));
            }
            Resultado += ("]" + System.getProperty("line.separator"));

            ok = verificarTolerancia(Xa, Xp, error);

            if (ok) {
                break;
            }

            Xp = this.actualizarX(Xa, Xp);

            Resultado += System.getProperty("line.separator");
            Resultado += ("-----------------------------------" + System.getProperty("line.separator"));
            Resultado += System.getProperty("line.separator");
        }

        if (!ok) {
            Resultado += ("No se Encontro la Solucion" + System.getProperty("line.separator"));
        } else {
            Resultado += this.comprobar(Xa, matriz_original);
        }

        return matriz;
    }
}
