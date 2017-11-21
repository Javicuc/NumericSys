package com.numericsystool.flycat.numericsys;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activity_menu_metodos extends AppCompatActivity {

    private ViewStub stubList;
    private ViewStub stubGrid;
    private GridView gridMenu;
    private ListView listMenu;
    private ListViewAdapter adapterList;
    private GridViewAdapter adapterGrid;
    private List<NumericalMethod> listMethods;
    private int currentViewMode = 0;

    static final int VIEW_LIST_MODE = 0;
    static final int VIEW_GRID_MODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_metodos);

        stubList = (ViewStub) findViewById(R.id.stubList);
        stubGrid = (ViewStub) findViewById(R.id.stubGrid);

        stubList.inflate();
        stubGrid.inflate();

        listMenu = (ListView) findViewById(R.id.lv_menuMetodos);
        gridMenu = (GridView) findViewById(R.id.gv_menuMetodos);

        getMethodsList();

        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", Context.MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode",VIEW_LIST_MODE);

        listMenu.setOnItemClickListener(onItemClick);
        gridMenu.setOnItemClickListener(onItemClick);

        switchView();
    }
    private void switchView() {
        if(VIEW_LIST_MODE == currentViewMode){
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        } else{
            stubList.setVisibility(View.GONE);
            stubGrid.setVisibility(View.VISIBLE);
        }

        setAdapter();

    }

    private void setAdapter() {
        if(VIEW_LIST_MODE == currentViewMode){
            adapterList = new ListViewAdapter(this, R.layout.list_item, listMethods);
            listMenu.setAdapter(adapterList);
        } else{
            adapterGrid = new GridViewAdapter(this, R.layout.grid_item, listMethods);
            gridMenu.setAdapter(adapterGrid);
        }
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
            Toast.makeText(getApplicationContext(),listMethods.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_switch,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_menu_1:
                if(VIEW_LIST_MODE == currentViewMode){
                    currentViewMode = VIEW_GRID_MODE;
                } else{
                    currentViewMode = VIEW_LIST_MODE;
                }

                switchView();

                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode",currentViewMode);
                editor.commit();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
