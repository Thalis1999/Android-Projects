package com.example.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.R;
import com.example.fragments.fragments.ContatosFragment;
import com.example.fragments.fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {
    private Button buttonConversas,buttonContatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // referencias dos botoes
        buttonContatos = findViewById(R.id.buttonContatos);
        buttonContatos = findViewById(R.id.buttonConversas);
        // vou instanciar a classe ConversasFragment (criar um objeto)
        conversasFragment = new ConversasFragment();
        // configurar objeto para uma transação com a classe FrameLayout
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo,conversasFragment);
        transaction.commit(); // finalizando a transação
        // evento do botao contatos
        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,contatosFragment);
                transaction1.commit();
            }
        });
        // evento para o botao conversas
        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frameConteudo,conversasFragment);
                transaction1.commit();
            }
        });
    }
}