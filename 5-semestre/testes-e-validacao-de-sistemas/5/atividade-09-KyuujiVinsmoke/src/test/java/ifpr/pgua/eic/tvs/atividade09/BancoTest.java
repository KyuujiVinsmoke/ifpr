package ifpr.pgua.eic.tvs.atividade09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BancoTest {
    
    @Test
    public void verificarNumeroAgenciaRepetido() {

        //cenario
        Banco banco = new Banco("Andre");
        String entrada = "9";
        String resultadoEsperado = "Já existe uma conta cadastrada com este número e agência.";

        //açao
        banco.criarCliente(entrada, entrada, 9, 9);
        Pessoa cliente = banco.buscarCliente(entrada);
        banco.criarConta(entrada, entrada, cliente);
        String resultadoObtido = banco.criarConta(entrada, entrada, cliente);

        //verificaçao
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void verificarContaSemCliente() {

        //cenario
        Banco banco = new Banco("Andre");
        String entrada = "9";
        String resultadoEsperado = "Este cliente não está cadastrado.";

        //açao
        String resultadoObtido = banco.criarConta(entrada, entrada, null);

        //verificaçao
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test 
    public void buscarContaNumeroAgencia() {
        
        //cenario
        Banco banco = new Banco("Andre");
        String entrada = "9";
        Pessoa resultadoEsperado = null;

        //açao
        ContaBancaria resultadoObtido = banco.buscarConta(entrada, entrada);

        //verificaçao
        assertEquals(resultadoEsperado, resultadoObtido);
    } 

    @Test
    public void realizarSaqueNumeroAgenciaValor() {

        //cenario
        Banco banco = new Banco("Andre");
        String entrada = "9";
        String resultadoEsperado = "Conta não encontrada!!";

        //açao
        String resultadoObtido = banco.sacar(entrada, entrada, 9);

        //verificaçao
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void realizarDepositoNumeroAgenciaValor() {

        //cenario
        Banco banco = new Banco("Andre");
        String entrada = "9";
        String resultadoEsperado = "Conta não encontrada!!";

        //açao
        String resultadoObtido = banco.depositar(entrada, entrada, 9);

        //verificaçao
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}