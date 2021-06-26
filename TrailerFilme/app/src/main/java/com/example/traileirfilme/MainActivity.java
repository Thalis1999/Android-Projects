package com.example.traileirfilme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView  textViewdata, textViewSinopse;
    private Spinner spinnerCine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reff

        textViewdata = findViewById(R.id.textViewData);
        textViewSinopse = findViewById(R.id.textViewSinopse);
        spinnerCine = findViewById(R.id.spinnerCine);

        // criando evento
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {

                String cine = ((TextView)view).getText().toString();

                if(cine.equals("Cine do Zé"))textViewdata.setText("23/05/2021");
                if(cine.equals("Cine AnnaBelle"))textViewdata.setText("03/06/2021");
                if(cine.equals("Cine Aberração"))textViewdata.setText("30/05/2021");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };


        spinnerCine.setOnItemSelectedListener(itemSelectedListener);
        //spinnerCine.OnItemSelectedListener(itemSelectedListener);


    }
    //metodo sinopse
    public void OnSinopse(View view){
        textViewSinopse.setText("Professor faz rinha de aluno pra ver quem fica com o Presencial Automação vs DS ");

    }
}
