package com.example.escolalinguas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkEspanhou, checkIngles, checkAvista;

    private TextView editTextTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencias
        checkEspanhou = findViewById(R.id.checkEspanhol);
        checkIngles = findViewById(R.id.checkIngles);
        checkAvista = findViewById(R.id.checkAvista);
        editTextTotal = findViewById(R.id.editTextTotal);

        public void buttonCalc(View view){

            float total = 0;

            if (checkEspanhou.isChecked() && checkIngles.isChecked()) {
                if (checkAvista.isChecked()) {

                    total = (float) (2400 - (2400 * 0.1));
                } else {
                    total = (float) 2400.00;
                } else {
                    if (checkIngles.isChecked()) {
                        if (checkAvista.isChecked()) {
                            total = (float) (1614 - (1614 * 0.1));
                        } else {
                            total = (float) 1614.00;
                        }
                    } else {
                        if (checkEspanhou.isChecked()) {
                            if (checkAvista.isChecked()) {
                                total = (float) (1200 - (1200 * 0.1));
                            } else {
                                total = (float) 1200.00;

                            }

                        } else {
                            Toast.makeText(this, "Escolha pelo menos um curso", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
                if (checkIngles.isChecked() && checkEspanhou.isChecked()) {
                    total = (float) (2400 - (2400 * 0.1));
                } else {
                    total = (float) 2400.00;
                }


            }


        }

        TextViewTotal.setText("Total: " + total);
    }
}
