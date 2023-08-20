package ifpr.pgua.eic.tvs.atividade09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
    
    private ArrayList<ContaBancaria> contas;
    private ArrayList<Pessoa> clientes;

    private String nome;


    public Banco(String nome){
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String criarCliente(String nome, String cpf, int idade, double salario) {
        for (Pessoa cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return "Já existe um cliente cadastrado com este CPF.";
            }
        }
        
        Pessoa pessoa = new Pessoa(nome, cpf, idade, salario);
        clientes.add(pessoa);
        return "Cliente cadastrado!";
    }

    public Pessoa buscarCliente(String cpf){
        
        for(Pessoa cliente:clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public List<Pessoa> listarClientes(){
        return Collections.unmodifiableList(clientes);
    }


    public String criarConta(String numero, String agencia, Pessoa cliente) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero().equals(numero) && conta.getAgencia().equals(agencia)) {
                return "Já existe uma conta cadastrada com este número e agência.";
            }
        }
        
        if (!clientes.contains(cliente)) {
            return "Este cliente não está cadastrado.";
        }
        
        ContaBancaria conta = new ContaBancaria(agencia, numero, cliente);
        contas.add(conta);
        return "Conta cadastrada!";
    }

    public ContaBancaria buscarConta(String numero, String agencia){
        for(ContaBancaria conta:contas){
            if(conta.getNumero().equals(numero) && conta.getAgencia().equals(agencia)){
                return conta;
            }
        }
        return null;
    }

    public List<ContaBancaria> listarContas(){
        return Collections.unmodifiableList(contas);
    }

    public String sacar(String numero, String agencia, double valor){

        
        for(ContaBancaria aux:contas){
            if(aux.getNumero().equals(numero) && 
               aux.getAgencia().equals(agencia)){
                return aux.sacar(valor);
            }
        }

        return "Conta não encontrada!!";

    }

    public String depositar(String numero, String agencia, double valor){

        
        for(ContaBancaria aux:contas){
            if(aux.getNumero().equals(numero) && 
               aux.getAgencia().equals(agencia)){
                return aux.depositar(valor);
            }
        }

        return "Conta não encontrada!!";

    }





}
