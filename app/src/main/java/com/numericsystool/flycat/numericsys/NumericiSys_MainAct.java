package com.numericsystool.flycat.numericsys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class NumericiSys_MainAct extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_metodos:
                    setTitle(R.string.title_bar_menu_metodos);
                    transaction.replace(R.id.content_frame_switch, new menuMetodos_Fragment(), "fragmentMenu").commit();
                    return true;
                case R.id.navigation_calculadora:
                    setTitle(R.string.title_bar_calculadora);
                    transaction.replace(R.id.content_frame_switch, new calculadora_Fragment(), "fragmentCalculadora").commit();
                    return true;
                case R.id.navigation_teoria:
                    setTitle(R.string.title_bar_teoria);
                    transaction.replace(R.id.content_frame_switch, new teoria_Fragment(), "fragmentTeoria").commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerici_sys__main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle(R.string.title_bar_menu_metodos);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame_switch, new menuMetodos_Fragment(), "FragmentMenu");
        fragmentTransaction.commit();

    }

}
