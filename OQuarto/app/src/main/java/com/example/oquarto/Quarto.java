package com.example.oquarto;

public class Quarto {
    private String statusLampada;
    private String statusPorta;
    //construtor

    public Quarto(String statusLampada, String statusPorta) {
        this.statusLampada = statusLampada;
        this.statusPorta = statusPorta;
    }
    // metodo para mostrar
    public String mostrarDados(){    //atributo usa-se "this"
        return "Lampada: "+this.statusLampada +"\nPorta: "+this.statusPorta; // "\n pula linha
    }
}
