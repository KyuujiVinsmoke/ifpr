package ifpr.pgua.eic.tvs.atividade09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ContaBancariaTest {
    
    @Test
    public void verificarDocumentoRepetido() {

        //cenario
        Banco banco = new Banco("Andre");
        String entrada = "9";
        String resultadoEsperado = "Já existe um cliente cadastrado com este CPF.";

        //açao
        banco.criarCliente(entrada, entrada, 9, 9);
        String resultadoObtido = banco.criarCliente(entrada, entrada, 9, 9);

        //verificaçao
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void buscarClienteCPF() {

        //cenario
        Banco banco = new Banco("Andre");
        String entrada = "9";
        Pessoa resultadoEsperado = null;

        //açao
        Pessoa resultadoObtido = banco.buscarCliente(entrada);

        //verificaçao
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}