package com.numericsystool.flycat.numericsys.metodos;

/**
 * Created by Javicuc on 02/12/2017.
 */

public class Gauss extends Base {

    private String Resultado;

    public String getResultado() {
        return Resultado;
    }

    public Gauss() {
        this.espaciado = 0;
        Resultado = "";
    }

    public double[][] evaluar(double[][] matriz, boolean pivoteo_parcial) {

        Resultado += this.reportarmatriz(matriz);

        int n = matriz.length;
        double[] x = new double[n];
        double[][] matriz_original = this.clonar(matriz);
        double cte;
        double suma;

        for (int i = 0; i < n - 1; i++) {
            if (pivoteo_parcial) {
                matriz = this.pivoteoParcial(matriz, i);
            }

            Resultado += ("--------" + System.getProperty("line.separator"));
            Resultado += ("I=" + i + System.getProperty("line.separator"));
            Resultado += ("--------" + System.getProperty("line.separator"));

            for (int j = i + 1; j < n; j++) {
                cte = matriz[j][i] / matriz[i][i];
                Resultado += ("alpha= " + this.redondear(matriz[j][i]) + " / " + this.redondear(matriz[i][i]) + " = "
                        + this.redondear(cte) + System.getProperty("line.separator"));
                Resultado += System.getProperty("line.separator");
                for (int k = 0; k <= n; k++) {

                    matriz[j][k] = matriz[j][k] - matriz[i][k] * cte;
                    Resultado += ("A" + j + "" + k + "=A" + j + "" + k + "-alpha*A" + i + "" + k + " => " + System.getProperty("line.separator"));
                    Resultado += (this.redondear(matriz[j][k]) + " = " + this.redondear(matriz[j][k]) + " - "
                            + this.redondear(matriz[i][k]) + " * " + this.redondear(cte) + System.getProperty("line.separator"));
                }

                Resultado += System.getProperty("line.separator");
            }

            Resultado += this.reportarmatriz(matriz);

            Resultado += ("--------------------------------------------------" + System.getProperty("line.separator"));
            Resultado += System.getProperty("line.separator");
            Resultado += System.getProperty("line.separator");
        }

        if (matriz[n - 1][n - 1] == 0) {
            Resultado += ("No se puede seguir con el metodo ya que el coeficiente de la incognita Xn es 0" + System.getProperty("line.separator"));
            return matriz;
        } else {

            Resultado += ("Calculando Xi" + System.getProperty("line.separator"));
            x[n - 1] = matriz[n - 1][n] / matriz[n - 1][n - 1];

            Resultado += ("X" + (n - 1) + "= (" + this.redondear(matriz[n - 1][n]) + ") / ("
                    + this.redondear(matriz[n - 1][n - 1]) + ") =" + this.redondear(x[n - 1]) + System.getProperty("line.separator"));

            for (int i = (n - 2); i >= 0; i--) {
                suma = 0;
                String cadena_suma = "";
                for (int j = 0; j < n; j++) {
                    suma += matriz[i][j] * x[j];
                    cadena_suma += "(" + this.redondear(matriz[i][j]) + ")*(" + this.redondear(x[j]) + ")";

                    if ((n - 1) == j) {
                    } else {
                        cadena_suma += " + ";
                    }
                }

                x[i] = (matriz[i][n] - suma) / matriz[i][i];

                Resultado += ("X" + i + "= (" + this.redondear(matriz[i][n]) + ") - [" + cadena_suma + "] / ("
                        + this.redondear(matriz[i][i]) + ") = " + this.redondear(x[i]) + System.getProperty("line.separator"));
            }
            Resultado += this.comprobar(x,matriz_original);
        }
        return matriz;
    }

    public String comprobar(double[] x, double[][] matriz_original){
        String comprobacion = "";
        comprobacion += System.getProperty("line.separator");
        comprobacion += ("Resultados:" + System.getProperty("line.separator"));
        int n = matriz_original.length;
        for (int i = 0; i < n; i++) {
            comprobacion += ("X" + i + "=" + this.redondear(x[i]) + System.getProperty("line.separator"));
        }

        comprobacion += System.getProperty("line.separator");
        comprobacion += ("Comprobandolo:" + System.getProperty("line.separator"));

        this.reportarmatriz(matriz_original);
        for (int i = 0; i < n; i++) {
            double result = 0;
            for (int j = 0; j < n; j++) {

                result += matriz_original[i][j] * x[j];
                comprobacion += (this.redondear(matriz_original[i][j]) + "(" + this.redondear(x[j]) + ")" + System.getProperty("line.separator"));
                if ((n - 1) == j) {
                } else {
                    comprobacion += ("+" + System.getProperty("line.separator"));
                }
            }

            comprobacion += ("=" + this.redondear(result) + System.getProperty("line.separator"));
        }
        return  comprobacion;
    }
    public double[][] pivoteoParcial(double[][] matriz, int fila) {
        double mayor = 0;
        int fila_mayor = 0;
        int n = matriz.length;
        double[] aux = new double[n + 1];

        for (int i = 0; i < n; i++) {

            if (Math.abs(matriz[i][fila]) > mayor) {
                mayor = Math.abs(matriz[i][fila]);
                fila_mayor = i;
            }

        }

        for (int j = 0; j <= n; j++) {
            aux[j] = matriz[fila][j];
        }

        for (int j = 0; j <= n; j++) {
            matriz[fila][j] = matriz[fila_mayor][j];
        }

        for (int j = 0; j <= n; j++) {
            matriz[fila_mayor][j] = aux[j];
        }

        return matriz;
    }
}
