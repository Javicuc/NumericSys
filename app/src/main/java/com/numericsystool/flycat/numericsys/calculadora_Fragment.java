package com.numericsystool.flycat.numericsys;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericsystool.flycat.numericsys.funcion.Funcion;
import com.numericsystool.flycat.numericsys.metodos.Biseccion;
import com.numericsystool.flycat.numericsys.metodos.CuadraturaGauss;
import com.numericsystool.flycat.numericsys.metodos.Euler;
import com.numericsystool.flycat.numericsys.metodos.GaussJacobi;
import com.numericsystool.flycat.numericsys.metodos.Lagrange;
import com.numericsystool.flycat.numericsys.metodos.NewtonRaphson;
import com.numericsystool.flycat.numericsys.metodos.PuntoFijo;
import com.numericsystool.flycat.numericsys.metodos.ReglaFalsa;
import com.numericsystool.flycat.numericsys.metodos.RungeKutta;
import com.numericsystool.flycat.numericsys.metodos.Simpson1_3;
import com.numericsystool.flycat.numericsys.metodos.Simpson3_8;
import com.numericsystool.flycat.numericsys.metodos.Trapecio;


/**
 * A simple {@link Fragment} subclass.
 */
public class calculadora_Fragment extends Fragment {


    private int metodoPos;
    private String metodoName;
    private Button btResolver;
    private TextView tvTitleMetodo;
    private TextView tvInputString1;
    private TextView tvInputString2;
    private TextView tvInputDouble1;
    private TextView tvInputDouble2;
    private TextView tvInputDouble3;
    private TextView tvInputDouble4;
    private TextView tvInputInt1;
    private EditText etInputString1;
    private EditText etInputString2;
    private EditText etInputDouble1;
    private EditText etInputDouble2;
    private EditText etInputDouble3;
    private EditText etInputDouble4;
    private EditText etInputInt1;


    public calculadora_Fragment() {
        metodoPos = -1;
        metodoName = "Numeric Sys Calculadora";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora_, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            metodoPos = bundle.getInt("metodoPos",-2);
            metodoName = bundle.getString("metodoName","Método no Encontrado");
        }

        btResolver = (Button) view.findViewById(R.id.bt_Resolver);

        tvTitleMetodo  = (TextView) view.findViewById(R.id.tv_TitleMetodo);
        tvInputString1 = (TextView) view.findViewById(R.id.tv_inputString1);
        tvInputString2 = (TextView) view.findViewById(R.id.tv_inputString2);
        tvInputDouble1 = (TextView) view.findViewById(R.id.tv_inputDouble1);
        tvInputDouble2 = (TextView) view.findViewById(R.id.tv_inputDouble2);
        tvInputDouble3 = (TextView) view.findViewById(R.id.tv_inputDouble3);
        tvInputDouble4 = (TextView) view.findViewById(R.id.tv_inputDouble4);
        tvInputInt1    = (TextView) view.findViewById(R.id.tv_inputInt1);

        etInputString1 = (EditText) view.findViewById(R.id.et_inputString1);
        etInputString2 = (EditText) view.findViewById(R.id.et_inputString2);
        etInputDouble1 = (EditText) view.findViewById(R.id.et_inputDouble1);
        etInputDouble2 = (EditText) view.findViewById(R.id.et_inputDouble2);
        etInputDouble3 = (EditText) view.findViewById(R.id.et_inputDouble3);
        etInputDouble4 = (EditText) view.findViewById(R.id.et_inputDouble4);
        etInputInt1    = (EditText) view.findViewById(R.id.et_inputInt1);

        tvTitleMetodo.setText(metodoName);
        final fragment_resultado resultado = new fragment_resultado();
        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        switch (metodoPos){
            case 0:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor para Xa:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el Valor para Xb:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputDouble3.setText("Ingresa la Tolerancia:");
                tvInputDouble3.setVisibility(View.VISIBLE);
                etInputDouble3.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputDouble3))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion = etInputString1.getText().toString();
                            double xa = Double.parseDouble(etInputDouble1.getText().toString());
                            double xb = Double.parseDouble(etInputDouble2.getText().toString());
                            double tolerancia = Double.parseDouble(etInputDouble3.getText().toString());

                            Funcion funcion = new Funcion(etFuncion);
                            Biseccion metodo = new Biseccion();
                            metodo.evaluar(funcion,xa,xb,tolerancia);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            case 1:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor para Xa:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el Valor para Xb:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputDouble3.setText("Ingresa la Tolerancia:");
                tvInputDouble3.setVisibility(View.VISIBLE);
                etInputDouble3.setVisibility(View.VISIBLE);
                tvInputInt1.setText("Ingresa el Numero de Iteraciones:");
                tvInputInt1.setVisibility(View.VISIBLE);
                etInputInt1.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputDouble3)||isEmptyEditText(etInputInt1))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion = etInputString1.getText().toString();
                            double xa = Double.parseDouble(etInputDouble1.getText().toString());
                            double xb = Double.parseDouble(etInputDouble2.getText().toString());
                            double tolerancia = Double.parseDouble(etInputDouble3.getText().toString());
                            int iteraciones = Integer.parseInt(etInputInt1.getText().toString());

                            Funcion funcion = new Funcion(etFuncion);
                            ReglaFalsa metodo = new ReglaFalsa();
                            metodo.evaluar(funcion,xa,xb,tolerancia,iteraciones);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });

                break;
            case 2:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputString2.setText("Ingresa la Función Despejada:");
                tvInputString2.setVisibility(View.VISIBLE);
                etInputString2.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor para X0:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa la Tolerancia:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputInt1.setText("Ingresa el Numero de Iteraciones:");
                tvInputInt1.setVisibility(View.VISIBLE);
                etInputInt1.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputInt1)||isEmptyEditText(etInputString2))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            String etFuncion2 = etInputString2.getText().toString();
                            double x0 = Double.parseDouble(etInputDouble1.getText().toString());
                            double tolerancia = Double.parseDouble(etInputDouble2.getText().toString());
                            int iteraciones = Integer.parseInt(etInputInt1.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            Funcion despejada = new Funcion(etFuncion2);
                            PuntoFijo metodo = new PuntoFijo();
                            metodo.evaluar(funcion,despejada,x0,tolerancia,iteraciones);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            case 3:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputString2.setText("Ingresa la Derivada:");
                tvInputString2.setVisibility(View.VISIBLE);
                etInputString2.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor para X0:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa la Tolerancia:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputInt1.setText("Ingresa el Numero de Iteraciones:");
                tvInputInt1.setVisibility(View.VISIBLE);
                etInputInt1.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputInt1))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            String etFuncion2 = etInputString2.getText().toString();
                            double x0 = Double.parseDouble(etInputDouble1.getText().toString());
                            double tolerancia = Double.parseDouble(etInputDouble2.getText().toString());
                            int iteraciones = Integer.parseInt(etInputInt1.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            Funcion derivada = new Funcion(etFuncion2);
                            NewtonRaphson metodo = new NewtonRaphson();

                            if(etFuncion2.trim().equals(""))
                                metodo.evaluar(funcion, x0, tolerancia, iteraciones);
                            else
                                metodo.evaluar(funcion, derivada, x0, tolerancia, iteraciones);

                            Bundle data = new Bundle();
                            data.putString("Resultado", metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            case 4:
                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        GaussJacobi metodo = new GaussJacobi();
                        double[][] matriz = new double[3][4];

                        matriz[0][0] = 3;
                        matriz[0][1] = -0.2;
                        matriz[0][2] = -0.5;
                        matriz[0][3] = 8;

                        matriz[1][0] = 0.1;
                        matriz[1][1] = 7;
                        matriz[1][2] = 0.4;
                        matriz[1][3] = -19.5;

                        matriz[2][0] = 0.4;
                        matriz[2][1] = 7;
                        matriz[2][2] = 10;
                        matriz[2][3] = 72.4;
                        metodo.evaluar(matriz, 0.01, 100);

                        Bundle data = new Bundle();
                        data.putString("Resultado",metodo.getResultado());

                        resultado.setArguments(data);
                        transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                    }
                });
                break;
            case 5:
                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Lagrange metodo = new Lagrange();
                        double[] x=new double[3];
                        double[] y=new double[3];

                        double numero = 251;
                        x[0]=94;
                        x[1]=205;
                        x[2]=371;

                        y[0]=929;
                        y[1]=902;
                        y[2]=860;

                        metodo.evaluar(x,y,numero);

                        Bundle data = new Bundle();
                        data.putString("Resultado",metodo.getResultado());

                        resultado.setArguments(data);
                        transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                    }
                });
                break;
            case 6:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor de a:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el valor de b:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            double a = Double.parseDouble(etInputDouble1.getText().toString());
                            double b = Double.parseDouble(etInputDouble2.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            Trapecio metodo = new Trapecio();
                            metodo.evaluar(funcion,a,b);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            case 7:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor de a:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el valor de b:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            double a = Double.parseDouble(etInputDouble1.getText().toString());
                            double b = Double.parseDouble(etInputDouble2.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            Simpson1_3 metodo = new Simpson1_3();
                            metodo.evaluar(funcion,a,b);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            case 8:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor de X0:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el valor de X1:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputDouble3.setText("Ingresa el Valor de X2:");
                tvInputDouble3.setVisibility(View.VISIBLE);
                etInputDouble3.setVisibility(View.VISIBLE);
                tvInputDouble4.setText("Ingresa el valor de X3:");
                tvInputDouble4.setVisibility(View.VISIBLE);
                etInputDouble4.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputDouble3)||isEmptyEditText(etInputDouble4))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            double x1 = Double.parseDouble(etInputDouble1.getText().toString());
                            double x2 = Double.parseDouble(etInputDouble2.getText().toString());
                            double x3 = Double.parseDouble(etInputDouble3.getText().toString());
                            double x4 = Double.parseDouble(etInputDouble4.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            Simpson3_8 metodo = new Simpson3_8();
                            metodo.evaluar(funcion,x1,x2,x3,x4);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            case 9:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Intervalo 1:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el Intervalo 2:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputInt1.setText("Ingresa el Numero de Puntos:");
                tvInputInt1.setVisibility(View.VISIBLE);
                etInputInt1.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputInt1))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            double a = Double.parseDouble(etInputDouble1.getText().toString());
                            double b = Double.parseDouble(etInputDouble2.getText().toString());
                            int puntos = Integer.parseInt(etInputInt1.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            CuadraturaGauss metodo = new CuadraturaGauss();
                            metodo.evaluar(funcion,a,b,puntos);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            case 10:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor de a:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el valor de b:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputDouble3.setText("Ingresa el Valor de y:");
                tvInputDouble3.setVisibility(View.VISIBLE);
                etInputDouble3.setVisibility(View.VISIBLE);
                tvInputInt1.setText("Ingresa el Numero de Iteraciones:");
                tvInputInt1.setVisibility(View.VISIBLE);
                etInputInt1.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputDouble3)||isEmptyEditText(etInputInt1))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            double a = Double.parseDouble(etInputDouble1.getText().toString());
                            double b = Double.parseDouble(etInputDouble2.getText().toString());
                            double y = Double.parseDouble(etInputDouble3.getText().toString());
                            int iteraciones = Integer.parseInt(etInputInt1.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            Euler metodo = new Euler();
                            metodo.evaluar(funcion,a,b,y,iteraciones);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });

                break;
            case 11:
                tvInputString1.setText("Ingresa la Función:");
                tvInputString1.setVisibility(View.VISIBLE);
                etInputString1.setVisibility(View.VISIBLE);
                tvInputDouble1.setText("Ingresa el Valor de a:");
                tvInputDouble1.setVisibility(View.VISIBLE);
                etInputDouble1.setVisibility(View.VISIBLE);
                tvInputDouble2.setText("Ingresa el valor de y:");
                tvInputDouble2.setVisibility(View.VISIBLE);
                etInputDouble2.setVisibility(View.VISIBLE);
                tvInputDouble3.setText("Ingresa el Valor Final de x:");
                tvInputDouble3.setVisibility(View.VISIBLE);
                etInputDouble3.setVisibility(View.VISIBLE);
                tvInputInt1.setText("Ingresa el Numero de Iteraciones:");
                tvInputInt1.setVisibility(View.VISIBLE);
                etInputInt1.setVisibility(View.VISIBLE);

                btResolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isEmptyEditText(etInputString1)||isEmptyEditText(etInputDouble1)||isEmptyEditText(etInputDouble2)
                                ||isEmptyEditText(etInputDouble3)||isEmptyEditText(etInputInt1))
                            Toast.makeText(getActivity(),"Complete los Recuadros",Toast.LENGTH_SHORT).show();
                        else{
                            String etFuncion1 = etInputString1.getText().toString();
                            double xi = Double.parseDouble(etInputDouble1.getText().toString());
                            double y = Double.parseDouble(etInputDouble2.getText().toString());
                            double xf = Double.parseDouble(etInputDouble3.getText().toString());
                            int iteraciones = Integer.parseInt(etInputInt1.getText().toString());

                            Funcion funcion = new Funcion(etFuncion1);
                            RungeKutta metodo = new RungeKutta();
                            metodo.evaluar(funcion,xi,y,xf,iteraciones);

                            Bundle data = new Bundle();
                            data.putString("Resultado",metodo.getResultado());

                            resultado.setArguments(data);
                            transaction.replace(R.id.content_frame_switch, resultado, "fragmentResultado").commit();
                        }
                    }
                });
                break;
            default:
                tvInputInt1.setVisibility(View.GONE);
                tvInputString1.setVisibility(View.GONE);
                tvInputString2.setVisibility(View.GONE);
                tvInputDouble1.setVisibility(View.GONE);
                tvInputDouble2.setVisibility(View.GONE);
                tvInputDouble4.setVisibility(View.GONE);

                etInputInt1.setVisibility(View.GONE);
                etInputString1.setVisibility(View.GONE);
                etInputString2.setVisibility(View.GONE);
                etInputDouble1.setVisibility(View.GONE);
                etInputDouble2.setVisibility(View.GONE);
                etInputDouble3.setVisibility(View.GONE);
                etInputDouble4.setVisibility(View.GONE);
                btResolver.setVisibility(View.GONE);
                break;
        }
        return view;
    }
    private boolean isEmptyEditText(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}
