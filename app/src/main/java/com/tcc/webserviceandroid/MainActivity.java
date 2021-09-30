package com.tcc.webserviceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button buscarTodos = findViewById(R.id.buscarTodos);
        buscarTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Caminho da API (URL do webservice)
                String url = "http://10.87.106.26/Thalis/api/Produto";
                
                //Iniciar a requisição ao webservice
                RequestQueue requisicao = Volley.newRequestQueue(MainActivity.this);
                
                //Configurar a requisicao com a URl, o método (Get, Post, Pur ou Delete)
                //Como o método do webservice retorna um Array, devemos fazer a chamada
                //usando a classe JsonArrayRequest
                JsonArrayRequest config = new JsonArrayRequest(
                        Request.Method.GET, //Método que será usado
                        url, //Caminho da API do webservice
                        null, //Não haverá parâmetros a serem passados
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                //Percorrer cada posicao do Array
                                for(int i=0 ; i< response.length() ; i++){
                                    try {
                                        //Recuperar cada objeto do vetor
                                        JSONObject obj = response.getJSONObject(i);
                                        //exibir os dados no LogCat
                                        Log.d("TESTEWS", "ID: " + obj.getString("id"));
                                        Log.d("TESTEWS", "Nome: " + obj.getString("nome"));
                                        Log.d("TESTEWS", "Preço: " + obj.getString("preco"));
                                        Log.d("TESTEWS", "Categoria: " + obj.getString("categoria"));
                                        Log.d("TESTEWS", "----------------------------------------");
                                    }catch (JSONException e) {
                                        e.printStackTrace();

                                }
                            }
                        }


                );
                requisicao.add(config); // executa a requisicao no webservice

        });

        Button cadastrar = findViewById(R.id.cadastrar);
        cadastrar.setOnClickListiner(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://10.87.106.26/thalis/api/Produto";
                RequestQueue requisicao = Volley.newRequestQueue(MainActivity.this);

                StringRequest config = new StringRequest(
                        Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ){
                    @Override //Configura o Body para usar JSON
                    public String getBodyContentType(){
                        return "application/json; charset=utf-8";
                    }
                    @Override //Configura os dados a serem enviados
                    public byte[] getBody(){
                        try {
                            //Criar um objeto do tipo JSON para enviar
                            JSONObject obj = new JSONObject();
                            obj.put("id", 9991);
                            obj.put("nome", "android teste");
                            obj.put("preco", 99.99);
                            obj.put("categoria", "cat teste android");
                            return obj.toString().getBytes(StandardCharsets.UTF_8);
                        }catch (Exception exc){
                            exc.printStackTrace();
                            return null;
                        }
                    }

                }
            }

            }
        })
    }
