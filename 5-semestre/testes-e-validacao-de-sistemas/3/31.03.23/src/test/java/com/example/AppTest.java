package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest 
{       
    @Test
    public void verificaSomaDoisInteiros()
    {
        //cenário
        ParseSoma parseSoma = new ParseSoma();
        String entrada = "1,1";
        int resultadoEsperado = 2;

        //ação
        int resultadoObtido = parseSoma.parseSoma(entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void verificaResultadoZeroStringVazia()
    {
        //cenário
        ParseSoma parseSoma = new ParseSoma();
        String entrada = "";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = parseSoma.parseSoma(entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}