package com.numericsystool.flycat.numericsys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, NumericiSys_MainAct.class);
        startActivity(intent);
        finish();
    }
}
