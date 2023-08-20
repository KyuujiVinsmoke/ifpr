package com.example;

public class App 
{
    public static void main( String[] args ) {

        RepresentaRetangulo representaRetangulo = new RepresentaRetangulo();

        System.out.println("Area: " + representaRetangulo.calcularArea("1", "1"));
        System.out.println("Perimetro: " + representaRetangulo.calcularPerimetro("1", "1"));

        VerificadorNomenclatura verificadorNomenclatura = new VerificadorNomenclatura();

        System.out.println(verificadorNomenclatura.verificar("Testes"));
    }
}