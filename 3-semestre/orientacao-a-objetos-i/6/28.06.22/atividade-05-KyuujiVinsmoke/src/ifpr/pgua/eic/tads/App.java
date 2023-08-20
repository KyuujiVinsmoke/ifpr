package ifpr.pgua.eic.tads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ifpr.pgua.eic.tads.modelos.Banco;
import ifpr.pgua.eic.tads.modelos.ContaCorrente;
import ifpr.pgua.eic.tads.modelos.Pessoa;

public class App 
{
    public static String menuGeral() 
    {
        String str = "";

        str += "\n1 - Conta\n";
        str += "2 - Pessoa\n";
        str += "3 - Banco\n";
        str += "0 - Sair\n";
        str += "> ";

        return str;
    }

    public static String menuBanco() 
    {
        String str = "";

        str += "\n1 - Listar as pessoas\n";
        str += "2 - Listar as contas\n";
        str += "0 - Sair\n";
        str += "> ";

        return str;
    }

    public static String menuConta() 
    {
        String str = "";

        str += "\n1 - Criar conta\n";
        str += "2 - Depositar\n";
        str += "3 - Sacar\n";
        str += "4 - Ver dados\n";
        str += "0 - Sair\n";
        str += "> ";

        return str;
    }

    public static String menuPessoa() 
    {
        String str = "";
        str += "\n1 - Cadastrar\n";
        str += "2 - Mostrar\n";
        str += "0 - Sair\n";
        str += "> ";

        return str;
    }

    public static void main (String[] args) throws Exception 
    {
        ContaCorrente conta = null;
        Pessoa pessoa = null;
        Banco banco = new Banco("Bamerindus", "009-0099", "001001/00-9");

        Scanner scan = new Scanner(System.in);
        int opcao, cont = 0;

        int numeroDaConta = 0;
        int agencia = 0;
        String senha;
        boolean ativa;
        double saldo, valor;

        String nome, cpf = "";
        int idade;
        double salario;

        do {
            System.out.print(menuGeral());
            opcao = scan.nextInt();
            scan.nextLine();
            
            if (opcao == 2) 
            { 
                System.out.print(menuPessoa());
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) 
                {
                    case 1:
                    System.out.print ("Digite o nome: \n> ");
                    nome = scan.nextLine();

                    ArrayList<Pessoa> documento = banco.getPessoas();
                    for (opcao = 0, cont = 0; opcao == 0; cont = 0)
                    {
                        System.out.print ("Digite o cpf: \n> ");
                        cpf = scan.nextLine();
                        
                        for (int i = 0; i < documento.size(); i++)
                        {
                            Pessoa cliente = documento.get(i);
                            
                            if (cpf == cliente.getCpf()) { cont++; }
                        }

                        if (cont > 0) { System.out.print ("Documento ja cadastrado\n"); }
                        else { opcao = 1; }
                    }

                    System.out.print ("Digite a idade: \n> ");
                    idade = scan.nextInt();
                    System.out.print ("Digite o salario: \n> ");
                    salario = scan.nextDouble();

                    pessoa = new Pessoa(nome, cpf, idade, salario);
                    banco.cadastrarPessoa(pessoa);

                    System.out.println("Cadastrada!");
                    break;
                    
                    case 2:
                    System.out.println("Detalhes da pessoa");
                    if (pessoa != null) { System.out.println(pessoa); } 
                    else { System.out.println("Pessoa não criada!"); }
                    break;
                }
            } 
            
            else if(opcao == 1)
            {
                System.out.print(menuConta());
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) 
                {
                    case 1:
                    if (pessoa != null) 
                    {   
                        ArrayList<Pessoa> usuario = banco.getPessoas();
                        System.out.print ("\nEscolha uma pessoa:");
                        for (int i = 0; i < usuario.size(); i++)
                        {
                            System.out.print ("\n(" +i+ ") ");
                            System.out.print (usuario.get(i));
                        }
                        System.out.print ("\n> ");
                        opcao = scan.nextInt();
                        pessoa = usuario.get(opcao);
                        
                        ArrayList<ContaCorrente> numero = banco.getContasCorrentes();

                        for (opcao = 0, cont = 0; opcao == 0; cont = 0)
                        {
                            System.out.print ("\nDigite o número da conta: \n> ");
                            numeroDaConta = scan.nextInt();
                            scan.nextLine();
                            
                            for (int i = 0; i < numero.size(); i++)
                            {
                                ContaCorrente corrente = numero.get(i);
                                
                                if (numeroDaConta == corrente.getNumeroDaConta()) { cont++; }
                            }

                            System.out.print ("Digite a agência: \n> ");
                            agencia = scan.nextInt();
                            scan.nextLine();

                            for (int i = 0; i < numero.size(); i++)
                            {
                                ContaCorrente corrente = numero.get(i);
                                
                                if (agencia == corrente.getAgencia()) { cont++; }
                            }
                            
                            if (cont > 0) { System.out.print ("Conta ou Agencia ja cadastrada\n"); }
                            else { opcao = 1; }
                        }
                       
                        System.out.print ("Digite a senha: \n> ");
                        senha = scan.nextLine();
                        System.out.print ("Está ativa (1-sim; 0-não) \n> ");
                        opcao = scan.nextInt();
                        ativa = opcao == 1;
                        System.out.print ("Quer informa o saldo? (1-sim; 0-não) \n> ");
                        opcao = scan.nextInt();
                        
                        if (opcao == 1) 
                        {
                            System.out.print ("Digite o saldo: \n> ");
                            saldo = scan.nextDouble();
                            conta = new ContaCorrente(numeroDaConta, agencia, pessoa, senha, ativa, saldo);
                        } 
                            
                        else 
                        {
                            conta = new ContaCorrente(numeroDaConta, agencia, pessoa, senha, ativa);
                        }
                            
                        pessoa.setContaCorrente(conta);
                        banco.cadastarConta(conta);
                        System.out.println("Conta criada!!");
                        opcao = 1;
                    }
                    
                    else
                    {
                        System.out.println("Necessário uma pessoa!");
                    } 
                    break;
                    
                    case 2:
                    System.out.println("Depositar!");
                    if (conta != null) 
                    {
                        System.out.print ("Digite um valor: \n> ");
                        valor = scan.nextDouble();
                        if (conta.depositar(valor)) 
                        {
                            System.out.println("Realizado!");
                        } 
                        
                        else 
                        {
                            System.out.println("Não Realizado! Valor insuficiente!");
                        }

                    } 
                    
                    else 
                    {
                        System.out.println("Não permitido! Crie uma conta!");
                    }   
                    break;

                    case 3:
                    System.out.println("Sacar!");
                    if (conta != null) 
                    {
                        System.out.print ("Digite um valor: \n> ");
                        valor = scan.nextDouble();
                        if (conta.sacar(valor)) 
                        {
                            System.out.println("Realizado!");
                        } 
                            
                        else
                        {
                            System.out.println("Não realizado! Valor inválido ou insuficiente!");
                        }

                    } 
                    
                    else 
                    {
                        System.out.println("Não permitido! Crie uma conta!");
                    }
                    break;

                    case 4:
                    System.out.println("Extrato!");
                    if (conta != null) 
                    {
                        System.out.println(conta);
                    } 
                    
                    else 
                    {
                        System.out.println("Não existe conta criada!");
                    }

                    break;
                }

            }
            
            else if(opcao == 3)
            {
                System.out.print(menuBanco());
                opcao = scan.nextInt();
                switch(opcao)
                {
                    case 1:
                    System.out.println("Listar pessoas!");
                    System.out.println(banco.getPessoas());
                    break;

                    case 2:
                    System.out.println("Listar contas!");
                    System.out.println(banco.getContasCorrentes());
                    break;
                } 
            }
        } while (opcao != 0);
    }
}