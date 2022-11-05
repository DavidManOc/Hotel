package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_ADULTOS = "kjsdhfjksbhkchc";
    private static final String EXTRA_NIÑOS = "oucjihsjlchjdshc";
    private static final String EXTRA_TEMPORADA = "pasdjfiwcfjsdcj";
    private Spinner sp_temporada;
    private EditText edt_numAdultos;
    private EditText edt_numNiños;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //das memoria-------------------------
        sp_temporada = (Spinner) findViewById(R.id.sp_temporada);
        edt_numAdultos = (EditText) findViewById(R.id.edt_numAdultos);
        edt_numNiños = (EditText) findViewById(R.id.edt_numNiños);
        //defines el spinnner------------------
        if (sp_temporada != null){//si el spinner tiene algo..
            String[] temporada = {"Temporada Alta", "Temporada Media", "Temporada Baja"};//defines un array con las opciones del spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.estilosspinner, temporada);//adaptas el modelo del spinner a la clse que has creado de color azul
            sp_temporada.setAdapter(adapter);//cambias el valor del sipnner al adaptador
            sp_temporada.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);//porque me pide castearlo?

        }

    }

    public void siguiente(View view) {
        boolean errores = false;
        //--------------------------------------------
        String textoCantidadAdultos = String.valueOf(edt_numAdultos.getText());
        String textoCantidadNiños = String.valueOf(edt_numNiños.getText());
        //--------------------------------------------
        if (textoCantidadAdultos.isEmpty()){
            edt_numAdultos.setError("Debes introducir un dato");
            errores = true;
        }
        if (textoCantidadNiños.isEmpty()){
            edt_numNiños.setError("Debes introducir un dato");
            errores = true;
        }
        //--------------------------------------------
        int numAdultos = Integer.valueOf(textoCantidadAdultos);
        int numNiños = Integer.valueOf(textoCantidadNiños);
        //--------------------------------------------
        if (numAdultos >= 1 && numAdultos <= 10){
            Toast.makeText(this, "Has elegido "+numAdultos+" adultos", Toast.LENGTH_LONG).show();
        }
        else{
            edt_numAdultos.setError("El numero de adultos debe estar comprendido entre 1 y 10");
        }
        if (numNiños >= 1 && numNiños <= 10){
            Toast.makeText(this, "Has elegido "+numNiños+" niños", Toast.LENGTH_LONG).show();
        }
        else{
            edt_numNiños.setError("El numero de niños debe estar comprendido entre 1 y 10");
        }
        //--------------------------------------------
        if(errores){
            return;
        }
        //--------------------------------------------
        Intent intent = new Intent(this, MainActivity2.class);//tienes la intencion de ir de esta clase al main2
        intent.putExtra(EXTRA_TEMPORADA, String.valueOf(sp_temporada));
        intent.putExtra(EXTRA_ADULTOS, numAdultos);//EXTRA_ADULTOS contiene la informacion del numero de adultos que haya seleccionado
        intent.putExtra(EXTRA_NIÑOS, numNiños);//EXTRA_NIÑOS contiene la informacion del numero de niños que haya seleccionado
        startActivity(intent);
    }
}