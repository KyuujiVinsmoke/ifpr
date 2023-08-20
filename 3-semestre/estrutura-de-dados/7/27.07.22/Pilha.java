import java.util.Scanner;

public class Pilha 
{
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        int TAM = 100;
        int vetor[] = new int[TAM];
        int pilha = 0;
        int i = -1;

        for(int op = 9; op != 0;) 
        {
            System.out.print (menu());
            op = scan.nextInt();
            
            if (op == 1)
            {
                System.out.print ("\nDigite o valor que deseja empilhar: \n> ");
                pilha = scan.nextInt();
                i = empilhar (vetor, i, pilha);
            }
                  
            else if (op == 2)
            {
                i = desempilhar(vetor, i);
            }
                   
            else if (op == 3)
            {
                System.out.print ("\nDigite o valor que deseja buscar: \n> ");
                int busca = scan.nextInt();

                buscar(vetor, i, busca, TAM);
            }

            else if (op == 4)
            {
                mostrarPilha(vetor, i);  
            }
        }
    }

    public static String menu() 
    {
        String str = "";
        str += "\n1) Empilhar Valor";
        str += "\n2) Desempilhar Valor";
        str += "\n3) Buscar Valor";
        str += "\n4) Mostrar Pilha";
        str += "\n0) Sair";
        str += "\n> ";

        return str;
    }

    public static int empilhar (int vetor[], int i, int valor) 
    {
        i++;
        vetor[i] = valor;
        System.out.print ("\n[O valor " +vetor[i]+ " foi empilhado na posicao " +i+ " ]\n");

        return i;
    }

    public static int desempilhar (int vetor[], int i) 
    {
        if (i > -1)
        {
            System.out.print ("\n[O valor " +vetor[i]+ " foi desempilhado na posicao " +i+ " ]\n");
            i--;
        }

        else 
        {
            System.out.print ("\n[Nenhum valor para ser desempilhado]\n");
        }

        return i;
    }

    public static void buscar (int vetor[], int i, int busca, int TAM) 
    {
        int pos = TAM + 9;

        for (int a = 0; a <= i; a++) 
        {
            if (vetor[a] == busca) 
            {
                pos = a;
            }
        }

        if (pos <= TAM)
        {
            System.out.print ("\n[O valor " +busca+ " foi encontrado na posição " +pos+ "]\n");
        }

        else
        {
            System.out.print ("\n[O valor " +busca+ " não foi encontrado]\n");
        }
    }

    public static void mostrarPilha (int vetor[], int i) 
    {
        System.out.print ("\n");

        for (int a = i; a >= 0; a--) 
        {
            System.out.print ("[ " +vetor[a]+ " ]\n");
        }

        if (i == -1)
        {
            System.out.print ("[A pilha esta vazia]\n");
        }
    }
}