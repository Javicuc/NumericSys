package com.numericsystool.flycat.numericsys;
import java.util.Scanner;
/*
 * [a,b] son intervalos
 * f: funcion
 * a: limite inferior
 * b: limite suoerior
 * it: contador de iteraciones
 * it_limite: numero maximo de iteraciones
 */

public class regla_Falsa {
    public static double f(double x){//este se modifcara segun el ejemplo de funtion
        return -(x*x)-(2*x)+1;
    }
    public static void funcion(String[] args) {
        Scanner a1 = new Scanner(System.in);
        Scanner b1 = new Scanner(System.in);

        System.out.println("Intervalo inferior:");
        a1.nextDouble();
        System.out.println("Intervalo superior");
        b1.nextDouble();
        double a=a1.nextDouble();
        double b=b1.nextDouble();
        double  c;
        int it_limite=10;
        int it=0;
        /*[a,b] es el intervalo F(a)*f(b)<0 */
        if(f(a)*f(b)>0)
        {
            System.out.println("No cumple. trate otro intevalo. ");
        }
        while(1>0){
            //iteración
            it=it++;
            c=((f(b)*a)-(f(a)*b))/(f(b)-f(a));
            System.out.println(+it+"  "+ a+ "  "+ c );
            System.out.println(+b+"  "+f(a)+"  "+f(c));
            if(it>=it_limite)
            {
                System.out.println("se excedio el limite de iteraciones.");
                break;
            }
            if(f(c)<=1e-10){
                System.out.println("La raiz aproximada es r = "+ c);
                System.out.println("El valor de f en r = " + f(c));
                return;
            }
            if(f(a)*f(c)<0)
            {
                b=c;
            }
            else{
                a=c;
            }
        }
    }
}
