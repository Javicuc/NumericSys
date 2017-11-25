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

        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 1", "Descripción Método 1"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 2", "Descripción Método 2"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 3", "Descripción Método 3"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 4", "Descripción Método 4"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 5", "Descripción Método 5"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 6", "Descripción Método 6"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 7", "Descripción Método 7"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 8", "Descripción Método 8"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 9", "Descripción Método 9"));
        listMethods.add(new NumericalMethod(R.mipmap.ic_launcher,"Metodo 10", "Descripción Método 10"));

        return listMethods;

    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(getActivity(),listMethods.get(position).getTitle(), Toast.LENGTH_SHORT).show();

            android.support.design.widget.BottomNavigationView navigationView = (android.support.design.widget.BottomNavigationView)getActivity().findViewById(R.id.navigation);
            navigationView.setSelectedItemId(R.id.navigation_calculadora);
            getActivity().setTitle(R.string.title_bar_calculadora);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame_switch, new calculadora_Fragment(), "fragmentCalculadora").commit();
        }
    };
}
