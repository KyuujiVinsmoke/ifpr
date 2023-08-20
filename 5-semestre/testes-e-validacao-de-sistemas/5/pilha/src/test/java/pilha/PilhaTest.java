package pilha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PilhaTest {

    private Pilha p;

    @BeforeEach
    public void criarPilha() {
        p = new Pilha();
    }

    @Test
    public void verificaPilhaVazia() {

        //acao + verificacao
        assertTrue(p.estaVazia());
        assertEquals(0, p.tamanho());
    }

    @Test
    public void empilhaUmElemento() {

        //acao
        p.empilhar("primeiro");

        //verificacao
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
    }

    @Test
    public void empilharDoisDesempilharUm() {

        //cenario
        Pilha p = new Pilha();
        p.empilhar("primeiro");
        p.empilhar("segundo");
        
        //verificacao
        assertFalse(p.estaVazia());
        assertEquals(2, p.tamanho());
        assertEquals("segundo", p.topo());
        
        //acao
        Object retorno = p.desempilhar();

        //verificacao
        assertEquals(1, p.tamanho());
        assertEquals("segundo", retorno);
        assertEquals("primeiro", p.topo());
    }
}