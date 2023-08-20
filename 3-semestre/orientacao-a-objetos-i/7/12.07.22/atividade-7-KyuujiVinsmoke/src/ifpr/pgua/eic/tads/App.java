package ifpr.pgua.eic.tads;

import java.util.ArrayList;
import java.util.Scanner;

import ifpr.pgua.eic.tads.modelos.Banco;
import ifpr.pgua.eic.tads.modelos.ContaCorrente;
import ifpr.pgua.eic.tads.modelos.ContaCorrenteEspecial;
import ifpr.pgua.eic.tads.modelos.ContaPoupanca;
import ifpr.pgua.eic.tads.modelos.Pessoa;
import ifpr.pgua.eic.tads.modelos.PessoaFisica;
import ifpr.pgua.eic.tads.modelos.PessoaJuridica;

public class App {

    public static String menuGeral() {
        String str = "";

        str += "1 - Conta\n";
        str += "2 - Pessoa\n";
        str += "3 - Banco\n";
        str += "0 - Voltar\n";

        return str;
    }

    public static String menuBanco() {
        String str = "";

        str += "1 - Listar as pessoas\n";
        str += "2 - Listar as contas\n";
        str += "0 - Voltar\n";

        return str;
    }

    public static String menuConta() {
        String str = "";

        str += "1 - Criar conta\n";
        str += "2 - Depositar\n";
        str += "3 - Sacar\n";
        str += "4 - Ver dados\n";
        str += "0 - Sair\n";

        return str;
    }

    public static String menuPessoa() {
        String str = "";
        str += "1 - Cadastrar\n";
        str += "2 - Mostrar\n";
        str += "0 - Voltar\n";

        return str;
    }

    public static void main(String[] args) throws Exception {
        ContaCorrente conta = null;
        Pessoa pessoa = null;
        Banco banco = new Banco("Moacir", "num sei");
        PessoaFisica pessoaFisica = null; 
        PessoaJuridica pessoaJuridica = null;

        Scanner scan = new Scanner(System.in);
        int opcao;

        int numeroDaConta;
        int agencia;
        String documento;
        String senha;
        boolean ativa;
        double saldo, valor;

        String nome, cpf, cnpj;
        int idade;
        double salario;

        do {
            System.out.println(menuGeral());
            opcao = scan.nextInt();
            scan.nextLine();
            if (opcao == 2) { // Menu da pessoa
                System.out.println(menuPessoa());
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("1 - Pessoa fisica");
                        System.out.println("2 - Pessoa juridica");
                        opcao = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Digite o nome:");
                        nome = scan.nextLine();
                        System.out.println("Digite a idade:");
                        idade = scan.nextInt();
                        System.out.println("Digite o salario:");
                        salario = scan.nextDouble();
                        scan.nextLine();
                    
                        if (opcao == 1) 
                        { 
                            System.out.println("Digite o cpf:"); 
                            cpf = scan.nextLine();

                            pessoaFisica = new PessoaFisica(nome, idade, salario, cpf);

                            if(banco.cadastrarPessoaFisica(pessoaFisica)){
                                System.out.println("Cadastrada!");
                            }else{
                                System.out.println("Erro ao cadastrar. Documento repetido!");
                            }
                        }
                        
                        else if (opcao == 2) 
                        {
                            System.out.println("Digite o cnpj:"); 
                            cnpj = scan.nextLine();

                            pessoaJuridica = new PessoaJuridica(nome, idade, salario, cnpj);

                            if(banco.cadastrarPessoaJuridica(pessoaJuridica)){
                                System.out.println("Cadastrada!");
                            }else{
                                System.out.println("Erro ao cadastrar. Documento repetido!");
                            }
                        }
                        
                        break;
                    case 2:
                        System.out.println("Detalhes da pessoa");
                        if (pessoa != null) {
                            System.out.println(pessoa);
                        } else {
                            System.out.println("Pessoa não criada!");
                        }
                        break;
                }
            } else if (opcao == 1) {

                System.out.println(menuConta());
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:

                        System.out.println("Digite o documento da pessoa:");
                        documento = scan.nextLine();

                        pessoa = banco.buscarPessoa(documento);

                        if (pessoa != null) {

                            System.out.println ("Escolha o tipo de conta:");
                            System.out.println("1 - Conta corrente");
                            System.out.println("2 - Conta corrente especial");
                            System.out.println("3 - Conta poupanca");
                            int tipo = scan.nextInt();
                            scan.nextLine();

                            System.out.println("Digite o número da conta:");
                            numeroDaConta = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a agência:");
                            agencia = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Digite a senha:");
                            senha = scan.nextLine();

                            System.out.println("Está ativa (1-sim;0-não)");
                            opcao = scan.nextInt();
                            ativa = opcao == 1;
                            System.out.println("Quer informa o saldo? (1-sim;0-não)");
                            opcao = scan.nextInt();

                            if (tipo == 1) 
                            {
                                if (opcao == 1)
                                {
                                    System.out.println("Digite o saldo:");
                                    saldo = scan.nextDouble();
                                    conta = new ContaCorrente(numeroDaConta, agencia, pessoa, senha, ativa, saldo);
                                }

                                else 
                                {
                                    conta = new ContaCorrente(numeroDaConta, agencia, pessoa, senha, ativa);
                                }
                            } 

                            else if (tipo == 2) 
                            {
                                if (opcao == 1)
                                {
                                    System.out.println("Digite o saldo:");
                                    saldo = scan.nextDouble();
                                    double limite = saldo / 10;
                                    conta = new ContaCorrenteEspecial(numeroDaConta, agencia, pessoa, senha, ativa, saldo, limite);
                                }

                                else 
                                {
                                    double limite = 0;
                                    conta = new ContaCorrenteEspecial(numeroDaConta, agencia, pessoa, senha, ativa, limite);
                                }
                            } 

                            else if (tipo == 3) 
                            {
                                if (opcao == 1)
                                {
                                    System.out.println("Digite o saldo:");
                                    saldo = scan.nextDouble();
                                    double taxaRendimento = saldo / 10;
                                    conta = new ContaPoupanca(numeroDaConta, agencia, pessoa, senha, ativa, saldo, taxaRendimento);
                                }

                                else 
                                {
                                    double taxaRendimento = 0;
                                    conta = new ContaPoupanca(numeroDaConta, agencia, pessoa, senha, ativa, taxaRendimento);
                                }
                            } 
                            
                            if(banco.cadastarConta(conta)){
                                pessoa.setContaCorrente(conta);
                                System.out.println("Conta criada!!");
                            }else{
                                System.out.println("Conta não criada!!");
                            }


                        } else {
                            System.out.println("Pessoa não encontrada!!!");
                        }
                        break;
                    case 2:
                        System.out.println("Depositar!");
                        if (conta != null) {
                            System.out.println("Digite um valor:");
                            valor = scan.nextDouble();
                            if (conta.depositar(valor)) {
                                System.out.println("Realizado!");
                            } else {
                                System.out.println("Não Realizado! Valor insuficiente!");
                            }

                        } else {
                            System.out.println("Não permitido! Crie uma conta!");
                        }
                        break;

                    case 3:
                        System.out.println("Sacar!");
                        if (conta != null) {
                            System.out.println("Digite um valor:");
                            valor = scan.nextDouble();
                            if (conta.sacar(valor)) {
                                System.out.println("Realizado!");
                            } else {
                                System.out.println("Não realizado! Valor inválido ou insuficiente!");
                            }

                        } else {
                            System.out.println("Não permitido! Crie uma conta!");
                        }
                        break;
                    case 4:
                        System.out.println("Extrato!");
                        if (conta != null) {
                            System.out.println(conta);
                        } else {
                            System.out.println("Não existe conta criada!");
                        }

                        break;
                }
            } else if (opcao == 3) {
                System.out.println(menuBanco());
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Listar pessoas!");
                        ArrayList<Pessoa> lista = banco.getPessoas();
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i));
                        }
                        break;
                    case 2:
                        System.out.println("Listar contas!");
                        ArrayList<ContaCorrente> contas = banco.getContaCorrentes();
                        for (int i = 0; i < contas.size(); i++) {
                            System.out.println(contas.get(i));
                        }
                        break;
                }
            }

        } while (opcao != 0);

    }
}