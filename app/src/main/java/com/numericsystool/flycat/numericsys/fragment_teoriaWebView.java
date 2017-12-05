package com.numericsystool.flycat.numericsys;


import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.AbstractSequentialList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_teoriaWebView extends Fragment {


    private int metodoPos;
    private String metodoName;
    private WebView wvTeoria;

    public fragment_teoriaWebView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teoriawebview, container, false);

        wvTeoria = (WebView) view.findViewById(R.id.wv_Teoria);
        WebSettings webSettings = wvTeoria.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvTeoria.setWebViewClient(new WebViewClient());

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            metodoPos = bundle.getInt("metodoPos",-2);
            metodoName = bundle.getString("metodoName","Método no Encontrado");
        }
        getActivity().setTitle(metodoName);

        switch (metodoPos){
            case 0:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/M%C3%A9todo_de_bisecci%C3%B3n");
                break;
            case 1:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/M%C3%A9todo_de_la_regla_falsa");
                break;
            case 2:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/M%C3%A9todo_del_punto_fijo");
                break;
            case 3:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/M%C3%A9todo_de_Newton");
                break;
            case 4:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/M%C3%A9todo_de_Jacobi");
                break;
            case 5:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/Interpolaci%C3%B3n_polin%C3%B3mica_de_Lagrange");
                break;
            case 6:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/Regla_del_trapecio");
                break;
            case 7:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/Regla_de_Simpson");
                break;
            case 8:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/Regla_de_Simpson");
                break;
            case 9:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/Cuadratura_de_Gauss");
                break;
            case 10:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/M%C3%A9todo_de_Euler");
                break;
            case 11:
                wvTeoria.loadUrl("https://es.wikipedia.org/wiki/M%C3%A9todo_de_Runge-Kutta");
                break;
            default:
                wvTeoria.loadUrl("https://es.wikipedia.org/");
                break;
        }

        return view;
    }
    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        return builder;
    }
}
