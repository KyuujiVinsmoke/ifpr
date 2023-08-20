package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestRepresentaRetangulo 
{       
    @Test
    public void verificaLadoMenorZeroArea() {
        
        //cenário
        RepresentaRetangulo representaRetangulo = new RepresentaRetangulo();
        String entrada = "0";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = representaRetangulo.calcularArea(entrada, entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void verificaLadoMenorZeroPerimetro() {
        
        //cenário
        RepresentaRetangulo representaRetangulo = new RepresentaRetangulo();
        String entrada = "0";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = representaRetangulo.calcularPerimetro(entrada, entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void verificaStringVaziaArea() {
       
        //cenário
        RepresentaRetangulo representaRetangulo = new RepresentaRetangulo();
        String entrada = "";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = representaRetangulo.calcularArea(entrada, entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void verificaStringVaziaPerimetro() {
        
        //cenário
        RepresentaRetangulo representaRetangulo = new RepresentaRetangulo();
        String entrada = "";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = representaRetangulo.calcularPerimetro(entrada, entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}