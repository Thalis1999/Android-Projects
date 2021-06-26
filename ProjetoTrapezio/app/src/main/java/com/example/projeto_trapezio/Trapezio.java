package com.example.projeto_trapezio;



public class Trapezio {

    private float baseMenor, baseMaior, altura;

    public Trapezio(float BaseMenor, float BaseMaior, float altura) {

       this.baseMenor = baseMenor;
       this.baseMaior = baseMaior;
       this.altura = altura;
    }

    public float calculaArea() {

        return (this.baseMenor + this.baseMaior) * this.altura /2;
    }

}
