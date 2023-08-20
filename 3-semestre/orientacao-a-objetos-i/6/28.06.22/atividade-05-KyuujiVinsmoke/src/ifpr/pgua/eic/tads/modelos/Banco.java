package ifpr.pgua.eic.tads.modelos;

import java.util.ArrayList;

public class Banco 
{
    private String nome;
    private String telefone;
    private String cnpj;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<ContaCorrente> contasCorrentes;
    private int qtdePessoas;
    private int qtdeContas;

    public Banco(String nome, String telefone, String cnpj) 
    {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        pessoas = new ArrayList<Pessoa>();
        qtdePessoas = 0;
        contasCorrentes = new ArrayList<ContaCorrente>();
        qtdeContas = 0;
    }

    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.pessoas.add(pessoa);
        qtdePessoas += 1;
    }

    public ArrayList<Pessoa> getPessoas()
    {
        return pessoas;
    }

    public void cadastarConta(ContaCorrente contaCorrente)
    {
        this.contasCorrentes.add(contaCorrente);
        qtdeContas += 1;
    }

    public ArrayList<ContaCorrente> getContasCorrentes()
    {
        return contasCorrentes;
    }
 
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getCnpj() 
    {
        return cnpj;
    }

    public void setCnpj(String cnpj) 
    {
        this.cnpj = cnpj;
    }

    public String getTelefone() 
    {
        return telefone;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }
}