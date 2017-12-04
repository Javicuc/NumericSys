package com.numericsystool.flycat.numericsys;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class teoria_Fragment extends Fragment {

    private ListView listMenu;
    private ListViewAdapter adapterList;
    private List<NumericalMethod> listMethods;

    public teoria_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teoria_, container, false);

        listMenu = (ListView) view.findViewById(R.id.lv_menuMetodosTeoria);

        getMethodsList();

        adapterList = new ListViewAdapter(view.getContext(), R.layout.list_item, listMethods);
        listMenu.setAdapter(adapterList);
        listMenu.setOnItemClickListener(onItemClick);

        return view;
    }

    public List<NumericalMethod> getMethodsList() {
        listMethods = new ArrayList<>();

        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Bisección", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Regla Falsa",""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Punto Fijo", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Newton Raphson", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Jacobi", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Lagrange", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Trapecio", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Simpson 1/3", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Simpson 3/8", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Cuadratura de Gauss", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Euler", ""));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_teoria,"Runge Kutta", ""));

        return listMethods;

    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String metodoName = listMethods.get(position).getTitle();

            Bundle data = new Bundle();
            data.putInt("metodoPos", position);
            data.putString("metodoName",metodoName);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragment_teoriaWebView teoria = new fragment_teoriaWebView();
            teoria.setArguments(data);
            transaction.replace(R.id.content_frame_switch, teoria, "fragmentTeoria").commit();

        }
    };

}
