package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText edt_diasDeEstancia;
    private TextView txt_precioAdultos;
    private TextView txt_precioNiños;
    private TextView txt_descuentoVIP;
    private TextView txt_total;

    String tipo_temporada = "";//para saber la temporada que ha cogido


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //das memoria-------------------
        edt_diasDeEstancia = (EditText) findViewById(R.id.edt_diasDeEstancia);
        txt_precioAdultos = (TextView) findViewById(R.id.txt_precioAdultos);
        txt_precioNiños = (TextView) findViewById(R.id.txt_precioNiños);
        txt_descuentoVIP = (TextView) findViewById(R.id.txt_descuentoVIP);
        txt_total = (TextView) findViewById(R.id.txt_total);
        //coges el intent---------------------
        Intent intent = getIntent();
        if(intent != null){
            tipo_temporada = intent.getStringExtra(MainActivity.EXTRA_TEMPORADA);
        }


    }

    public void calcular(View view) {
    }

    public void siEsVIP(View view) {
    }

    public void noEsVIP(View view) {
    }
}