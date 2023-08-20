package ifpr.pgua.eic.tads.modelos;

import java.util.ArrayList;

public class Banco {
    
    private String nome;
    private String telefone;
    private ArrayList<Pessoa> pessoas;
    private ArrayList<PessoaFisica> pessoaFisica;
    private ArrayList<PessoaJuridica> pessoaJuridica;
    private ArrayList<ContaCorrente> contaCorrentes;
    private ArrayList<ContaCorrenteEspecial> contaCorrenteEspecials;
    private ArrayList<ContaPoupanca> contaPoupancas;
    private int qtdePessoas;
    private int qtdeContas;
  

    public Banco(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        pessoas = new ArrayList<Pessoa>();
        qtdePessoas = 0;
        contaCorrentes = new ArrayList<>();
        qtdeContas = 0;

    }


    public Pessoa buscarPessoa(String documento){
        for(int i=0;i<pessoas.size();i++){
            if(pessoas.get(i).getCpf().equals(documento)){
                return pessoas.get(i);
            }
        }

        return null;
    }

    public ContaCorrente buscarConta(int numero, int agencia){

        for(ContaCorrente conta:contaCorrentes){
            if(conta.getNumeroDaConta()==numero && conta.getAgencia()==agencia){
                return conta;
            }
        }

        return null;
    }


    public boolean cadastrarPessoaFisica(PessoaFisica pessoaFisica){
        if(buscarPessoa(pessoaFisica.getCpf())== null){
            this.pessoas.add(pessoaFisica);
            qtdePessoas += 1;
            return true;
        }

        return false;
    }

    public boolean cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica){
        if(buscarPessoa(pessoaJuridica.getCnpj())== null){
            this.pessoas.add(pessoaJuridica);
            qtdePessoas += 1;
            return true;
        }

        return false;
    }

    public ArrayList<Pessoa> getPessoas(){
        return pessoas;
    }

    public ArrayList<PessoaFisica> getPessoaFisica(){
        return pessoaFisica;
    }

    public ArrayList<PessoaJuridica> getPessoaJuridica(){
        return pessoaJuridica;
    }

    public boolean cadastarConta(ContaCorrente conta){
        if(buscarConta(conta.getNumeroDaConta(), conta.getAgencia())==null){
            this.contaCorrentes.add(conta);
            qtdeContas += 1;
            return true;
        }

        return false;
        
    }

    public ArrayList<ContaCorrente> getContaCorrentes(){
        return contaCorrentes;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}