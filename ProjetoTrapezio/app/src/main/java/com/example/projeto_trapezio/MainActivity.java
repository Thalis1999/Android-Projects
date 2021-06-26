package com.example.projeto_trapezio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //atributo
    private EditText editTextBaseMenor,editTextBaseMaior,editTextAltura;
    private TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //referencias

        editTextBaseMenor = findViewById(R.id.editTextBaseMenor);
        editTextBaseMenor = findViewById(R.id.editTextBaseMaior);
        View editTextAltura = findViewById(R.id.editTextAltura);
        View textViewResultado = findViewById(R.id.editTextResultado);



    }

public void onCalcular(View view){

        Trapezio trapezio = new Trapezio(Float.parseFloat(editTextBaseMenor.getText().toString()),
                                         Float.parseFloat(editTextBaseMaior.getText().toString()),
                                         Float.parseFloat(editTextBaseMenor.getText().toString()),
                                         Float.parseFloat(editTextAltura.getText().toString());

        textViewResultado.setText("resultado: " + trapezio.calculaArea());

    }

}
