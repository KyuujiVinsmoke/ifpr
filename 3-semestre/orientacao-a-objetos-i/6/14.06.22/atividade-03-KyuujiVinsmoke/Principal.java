import java.util.Scanner;
import java.util.Random;

public class Principal 
{
    public static void main(String[] args)
    {
        System.out.println ("");
        ContaCorrente conta = new ContaCorrente();
        ContaUsuario usuario = new ContaUsuario();
        double valor = 0;
        int op;
        
        Random numeros = new Random();
        Scanner scan = new Scanner(System.in);
        
        for (op = 0; op < 1 || op > 1;)
        {
            System.out.println ("1) Criar Conta");
            System.out.println ("2) Editar Conta");
            System.out.println ("0) Sair");
            System.out.print ("> ");
            op = scan.nextInt();

            if (op == 2) { System.out.println ("\nEste Recurso Ainda Nao Foi Implementado"); }
            else if (op == 0) { return; }
        }

        if (op == 1)
        {
            System.out.print ("\nDigite Seu Nome: \n> ");
            usuario.setNome (scan.next());
    
            System.out.print ("Digite Seu CPF: \n> ");
            usuario.setCpf (scan.next());

            System.out.print ("Digite Sua Idade: \n> ");
            usuario.setIdade (scan.nextInt());

            System.out.print ("Digite Seu Salario: \n> ");
            usuario.setSalario (scan.nextInt());

            conta.setDocumento (usuario.getCpf(""));

            conta.saldo = usuario.getSalario(0);

            System.out.println (conta);
            
            System.out.print ("Escolha Uma Senha Para Sua Conta: \n> ");
            conta.getSenha (scan.next());
        }
        
        for (int operacao = 9; operacao > 0;)
        {
            System.out.println ("\n1) Sacar Dinheiro Da Conta");
            System.out.println ("2) Depositar Dinheiro Na Conta");
            System.out.println ("0) Sair");
            System.out.println ("\n\t\t\t[O Saldo Da Sua Conta E: " +conta.saldo+ "]");
            System.out.print ("> ");
            operacao = scan.nextInt();

            if (operacao == 1) 
            { 
                System.out.print ("\nValor Do Saque \n> ");
                valor = scan.nextInt();
                if (valor < conta.saldo && valor > 0) { System.out.println ("[Saque Bem Sucedido]"); conta.Sacar (valor); }
                else if (valor <= 0) { System.out.println ("[Valor Invalido]"); }
                else if ( valor > conta.saldo) { System.out.println ("[Valor Superior ao saldo]"); }
            }

            else if (operacao == 2) 
            { 
                System.out.print ("\nValor Do Deposito \n> ");
                valor = scan.nextInt();
                if (valor > 0) { System.out.println ("[Deposito Bem Sucedido]"); conta.Depositar (valor); }
                else { System.out.println ("[Saque inferior a 0]");} 
            }

            else if (operacao != 0) { System.out.println ("[Operacao Invalida]"); }

            else if (op == 0) { return; }
        }

        System.out.println ("");
    }
}