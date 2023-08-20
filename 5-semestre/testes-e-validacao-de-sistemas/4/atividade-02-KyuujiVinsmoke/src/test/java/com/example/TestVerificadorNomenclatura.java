package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestVerificadorNomenclatura {
    
    @Test
    public void somenteLetrasNumeros() {

        //cenário
        VerificadorNomenclatura verificadorNomenclatura = new VerificadorNomenclatura();
        String entrada = "Teste@";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = verificadorNomenclatura.verificar(entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void sempreComecarLetra() {

        //cenário
        VerificadorNomenclatura verificadorNomenclatura = new VerificadorNomenclatura();
        String entrada = "7estes";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = verificadorNomenclatura.verificar(entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void seisLetrasMax() {

        //cenário
        VerificadorNomenclatura verificadorNomenclatura = new VerificadorNomenclatura();
        String entrada = "Testes7";
        int resultadoEsperado = 0;

        //ação
        int resultadoObtido = verificadorNomenclatura.verificar(entrada);

        //verificação
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}