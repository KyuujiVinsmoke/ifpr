public class Lista
{
    No inicio;
    No fim;
    int tamanho;

    public void inserirPessoa(Pessoa pessoa)
    {
        No no = new No();
        no.pessoa = pessoa;
        no.proximo = null;
        no.anterior = fim;
        
        if (inicio != null)
        {
            fim.proximo = no;
        }

        fim = no;
        if (tamanho == 0)
        {
            inicio = fim;
        }

        tamanho++;
        pessoa.setQuantidadePessoas(tamanho + 1);
    }

    public No pessoaCadastrada(String nome)
    {
        No posicao = inicio;
        
        for (; posicao != null; posicao = posicao.proximo)
        {
            if ((posicao.pessoa.getNome().equals(nome)))
            {
                return posicao;
            }
        }
        
        return null;
    }

    public void editarPessoa(Pessoa pessoa, No posicao)
    {
        No lista = posicao;
        lista.pessoa = pessoa;
    }

    public void apagarPessoa(String Nome, No posicao)
    {
        No lista = posicao;
        No mudar = posicao;
        Pessoa pessoa = mudar.pessoa;
        
        if (posicao.proximo != null)
        {
            mudar = posicao.proximo;
            pessoa = mudar.pessoa;
        }

        else
        {
            mudar = null;
        }

        for(; mudar != null; lista = lista.proximo, mudar = mudar.proximo)
        {
            pessoa = mudar.pessoa;
            lista.pessoa = pessoa;
        }

        fim = fim.anterior;

        if (fim != null)
        {
            fim.proximo = null;
        }

        else 
        {
            inicio = null;
        }
        
        tamanho--;
        pessoa.setQuantidadePessoas(tamanho + 1);
    }

    public void apagarTodasPessoas()
    {
        inicio = null;
        fim = null;
        tamanho = 0;

        No no = new No();
        no.anterior = null;
        no.proximo = null;
        no.pessoa = null;
    }

    public String toString()
    {
        String str = "";
        No lista = inicio;
        
        if (tamanho != 0)
        {
            for (int i = 1; lista != null; lista = lista.proximo, i++)
            {
                str += "\n--------------------------------------------------\n";
                str += "\n\t\t\t[" +i+ "]\n";
                str += lista.pessoa;
                str += lista.pessoa.endereco +"\n";
            }
        }

        else 
        {
            str += "\n--------------------------------------------------\n";
            str += "\n\tNenhuma pessoa na lista" +"\n";
        }

        return str;
    }
}