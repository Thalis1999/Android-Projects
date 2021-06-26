package com.example.oquarto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup groupLampada, groupPorta;
    private Button buttonAceitar;
    private TextView textViewMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Referencias
        groupLampada = findViewById(R.id.groupLampada);
        groupPorta = findViewById(R.id.groupPorta);
        buttonAceitar = findViewById(R.id.buttonAceitar);
        textViewMostrar = findViewById(R.id.textViewMostrar);

        // evento do botão aceitar
        buttonAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String statusLampada = null;
                String statusPorta = null;
                int idLampada = groupLampada.getCheckedRadioButtonId();
                int idPorta = groupPorta.getCheckedRadioButtonId();
                if (idLampada ==R.id.radioButtonAcesa) statusLampada = "Acesa";
                else statusLampada = "Apagada";

                if (idPorta == R.id.radioButtonAberta) statusPorta = "Aberta";
                if (idPorta == R.id.radioButtonTrancada)statusPorta = "Trancada";
                if (idPorta == R.id.radioButtonFechada)statusPorta = "Fechada";
                //objeto da classe Quarto
                Quarto quarto = new Quarto(statusLampada, statusPorta);
                // mostrar os estados da lampada e da porta
                textViewMostrar.setText("Mostrar: \n" +quarto.mostrarDados());


            }
        });

    }
}