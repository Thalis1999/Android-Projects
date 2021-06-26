package com.example.listacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTotal;
    private EditText editTextQuant;
    private ListView listViewProduto;
    private float total = 0; //somador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ref

        textViewTotal = findViewById(R.id.textViewTotal);
        editTextQuant = findViewById(R.id.editTextQuant);
        listViewProduto = findViewById(R.id.listviewProduto);

        // criar o evento

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                if (!editTextQuant.getText().toString().isEmpty()) {
                    int quantidade = Integer.parseInt(editTextQuant.getText().toString());

                    String produto = ((TextView) view).getText().toString();
                    //if(produto.equals("Arroz"))total = (float) (total + (quantidade *13.00));
                    if (produto.equals("Arroz")) total += quantidade * 13.00;
                    if (produto.equals("Feijão")) total += quantidade * 7.00;
                    if (produto.equals("Leite")) total += quantidade * 2.69;
                    if (produto.equals("Macarrão")) total += quantidade * 2.20;
                    if (produto.equals("Oleo")) total += quantidade * 2.99;
                    if (produto.equals("Açucar")) total += quantidade * 2.25;

                    textViewTotal.setText("TOTAL:\nR$" + total);
                    editTextQuant.setText("");//Apagar o campo Quantidade
                } else {
                    Toast.makeText(MainActivity.this, "Insira um Valor no campo quantidade!", Toast.LENGTH_SHORT).show();
                }
            }

        };
            listViewProduto.setOnItemClickListener(itemClickListener);
    }
    public void OnNovaCompra(View view){
        textViewTotal.setText("TOTAL: ");
    }
}
