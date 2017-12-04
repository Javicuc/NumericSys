package com.numericsystool.flycat.numericsys;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class menuMetodos_Fragment extends Fragment {

    private ListView listMenu;
    private ListViewAdapter adapterList;
    private List<NumericalMethod> listMethods;

    public menuMetodos_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_metodos_, container, false);

        listMenu = (ListView) view.findViewById(R.id.lv_menuMetodos);

        getMethodsList();

        adapterList = new ListViewAdapter(view.getContext(), R.layout.list_item, listMethods);
        listMenu.setAdapter(adapterList);
        listMenu.setOnItemClickListener(onItemClick);

        return view;
    }

    public List<NumericalMethod> getMethodsList() {
        listMethods = new ArrayList<>();

        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Bisección", getString(R.string.descBiseccion)));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Regla Falsa", getString(R.string.descReglaFalsa)));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Punto Fijo", "Descripción Método 3"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Newton Raphson", "Descripción Método 4"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Jacobi", "Descripción Método 5"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Lagrange", "Descripción Método 6"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Trapecio", "Descripción Método 7"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Simpson 1/3", "Descripción Método 8"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Simpson 3/8", "Descripción Método 9"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Cuadratura de Gauss", "Descripción Método 10"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Euler", "Descripción Método 11"));
        listMethods.add(new NumericalMethod(R.drawable.ic_action_calculator,"Runge Kutta", "Descripción Método 12"));

        return listMethods;

    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String metodoName = listMethods.get(position).getTitle();

            android.support.design.widget.BottomNavigationView navigationView = (android.support.design.widget.BottomNavigationView)getActivity().findViewById(R.id.navigation);
            navigationView.setSelectedItemId(R.id.navigation_calculadora);
            getActivity().setTitle(R.string.title_bar_calculadora);

            Bundle data = new Bundle();
            data.putInt("metodoPos", position);
            data.putString("metodoName",metodoName);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            calculadora_Fragment calculadora = new calculadora_Fragment();
            calculadora.setArguments(data);
            transaction.replace(R.id.content_frame_switch, calculadora, "fragmentCalculadora").commit();

        }
    };
}
