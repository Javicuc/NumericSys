package com.numericsystool.flycat.numericsys;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_resultado extends Fragment {


    public fragment_resultado() {
        // Required empty public constructor
    }

    private TextView wvResultado;
    private String metodoResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            metodoResultado = bundle.getString("Resultado","Resultado no Encontrado");
        }

        wvResultado = (TextView) view.findViewById(R.id.wv_Resultado);
        wvResultado.setText(metodoResultado);

        return view;
    }
}
