import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Busca
{
    public static int Binaria (int[] vetorOrdenado, int numero, int quantidade)
    {      
        int fim = vetorOrdenado.length - 1;

        if (numero < 0 || numero > 100000) { return 0; }
  
        for (int inicio = 0, meio = 0; inicio <= fim;) 
        {
            meio = (fim + inicio) / 2; 
          
            if (vetorOrdenado[meio] == numero) 
            {
                return meio;
            }
          
            else if (vetorOrdenado[meio] < numero) 
            {
                inicio = meio + 1;
            } 
          
            else if (vetorOrdenado[meio] > numero) 
            {
                fim = meio - 1;
            }
        }

        return 0;
    }

    public static int Sequencia (int[] vetor, int numero, int quantidade)
    {   
        int a = 0;

        if (numero < 0 || numero > 100000) { return 0; }
        
        for(; a < quantidade; a++)
        {
            if (vetor[a] == numero) { return a; }
        }

        return 0;
    }

    public static int Repetido (int vetor[], int a)
    {
        int repetido = 0;

        for (int b = 0; b < a; b++)
        {
            if (vetor[b] == vetor[a]) { repetido++; }
        }

        return repetido;
    }

    public static void main(String[] args)
    {
        System.out.println ("");

        Scanner scan = new Scanner(System.in);
        Random aleatorios = new Random();
        int numero, a, resul, repetido, quantidade, comeco, fim;
        int[] vetor = new int [100000];
        int[] vetorOrdenado = new int [100000];

        System.out.print ("\nCriando um vetor com numeros aleatorios...");
        for (a = 0; a < 100000; a++)
        {
            vetor[a] = aleatorios.nextInt (100000) +0;

            repetido = Repetido(vetor, a);

            if (repetido != 0) { a--; }
        }

        for (int op = 1; op != 0;)
        {
            System.out.print ("\nEscolha o metodo de ordenacao:");
            System.out.print ("\n1) Binario");
            System.out.print ("\n2) Sequencial");
            System.out.print ("\n0) Sair");
            System.out.print ("\n> ");
            op = scan.nextInt();

            if (op == 0) { return; }
            else if (op != 1 && op != 2) { System.out.print ("\n[Opcao invalida]\n");}
            else
            {
                for (quantidade = 0; quantidade < 1 || quantidade > 5;)
                {
                    System.out.print ("\nEscolha a quantidade de leitura:");
                    System.out.print ("\n1) 10");
                    System.out.print ("\n2) 100");
                    System.out.print ("\n3) 1000");
                    System.out.print ("\n4) 10000");
                    System.out.print ("\n5) 100000");
                    System.out.print ("\n> ");
                    quantidade = scan.nextInt();

                    if (quantidade < 1 || quantidade > 5) { System.out.print ("\n[Opcao invalida]\n");}
                }

                if (quantidade == 1) { quantidade = 10; }
                else if (quantidade == 2) { quantidade = 100; }
                else if (quantidade == 3) { quantidade = 1000; }
                else if (quantidade == 4) { quantidade = 10000; }
                else if (quantidade == 5) { quantidade = 100000; }

                System.out.print ("\nEscolha um numero para ser feita a busca:");
                System.out.print ("\n> ");
                numero = scan.nextInt();
                
                if (op == 1) 
                { 
                    vetorOrdenado = vetor;
                    Arrays.sort(vetorOrdenado);

                    long tempoInicial = System.currentTimeMillis();
                    resul = Binaria(vetorOrdenado, numero, quantidade);
                    long tempo = System.currentTimeMillis() - tempoInicial;

                    System.out.print ("\nTempo percorrido: " +tempo+ " milesimos");

                    if (resul != 0) { System.out.print ("\nO numero escolhido esta na posicao: " +resul+ "\n"); }
                    else { System.out.print ("\n[O numero escolhido nao foi encontrado]\n");}
                }
                  
                else if (op == 2) 
                { 
                    long tempoInicial = System.currentTimeMillis();
                    resul = Sequencia (vetor, numero, quantidade);
                    long tempo = System.currentTimeMillis() - tempoInicial;

                    System.out.print ("\nTempo percorrido: " +tempo+ " milesimos");

                    if (resul != 0) { System.out.print ("\nO numero escolhido esta na posicao: " +resul+ "\n"); }
                    else { System.out.print ("\n[O numero escolhido nao foi encontrado]\n");}
                }
            }
        }

        System.out.println ("");
    }
}