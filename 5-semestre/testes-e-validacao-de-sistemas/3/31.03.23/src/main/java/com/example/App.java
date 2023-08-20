package com.example;

public class App 
{
    public static void main( String[] args )
    {
        ParseSoma parseSoma = new ParseSoma();

        int resultado = parseSoma.parseSoma("1,1");

        System.out.println("O resultado foi "+resultado);
    }
}