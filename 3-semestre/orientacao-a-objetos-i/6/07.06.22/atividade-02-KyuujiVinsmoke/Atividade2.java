import java.util.Scanner;

public class Atividade2
{
    public static boolean Repetido (int n, int[] numeros)
    {
        for(int a = 0; a < numeros.length; a++)
        {
            if(numeros[a] == n)
            {
                System.out.printf ("[Numero Repetido]\n");
                return true;
            }
        }

        return false;
    }

    public static int Maior (int[] numeros, int maiores)
    {
        for (int a = 0; a < numeros.length; a++)
        {
            if (numeros[a] > maiores)
            {
                maiores = numeros[a];
            }
        }
        
        return maiores;
    }

    public static int Menor (int[] numeros, int menores)
    {
        for (int a = 0; a < numeros.length; a++)
        {
            if (numeros[a] < menores && numeros[a] > 0)
            {
                menores = numeros[a];
            }
        }
        
        return menores;
    }

    public static int Soma (int[] numeros, int total)
    {
        for (int a = 0; a < numeros.length; a++)
        {
            total = total + numeros[a];
        }

        return total;
    }

    public static int Subtraido (int[] numeros, int maiores)
    {
        System.out.printf ("\nNumeros Subtraidos Do Maior: ");

        for (int a = 0; a < numeros.length; a++)
        {   
            if (numeros[a] > 0)
            {
                System.out.printf ("%d ", (numeros[a] - maiores));
            }
        }
        
        return 0;
    }

    public static int Somado (int[] numeros, int menores)
    {   
        System.out.printf ("\nNumeros Somados Com O Menor: ");

        for (int a = 0; a < numeros.length; a++)
        {   
            if (numeros[a] > 0)
            {
                
                System.out.printf ("%d ", (numeros[a] + menores));
            }
        }

        return 0;
    }
    
    public static void main(String[] args)
    {
        System.out.println("\n\n");

        Scanner scan = new Scanner(System.in);
        int n = 0;
        int[] numeros = new int [101];

        for (int a = 0; n != -1;)
        {
            System.out.printf ("Digite Um Numero Entre 1 E 100 Ou -1 Para Obter O Resultado:");
            System.out.printf ("\n> ");
            n = scan.nextInt();
            System.out.printf ("\n");

            if (n > 0 && n < 101)
            {
                if (Repetido (n, numeros) == false)
                {
                    numeros[a] = n;
                    a++;
                }
            }
            
            else if (n < -1 || n == 0 || n > 100)
            {
                System.out.printf ("[Numero Diferente Do Proposto]\n");
            }
        }

        int maiores = 0, menores = 101, total = 0;

        System.out.printf ("O Maior Numero Digitado: ");
        maiores = Maior (numeros, maiores);
        System.out.printf ("%d", maiores);

        System.out.printf ("\nO Menor Numero Digitado: ");
        menores = Menor (numeros, menores);
        System.out.printf ("%d", menores);

        System.out.printf ("\nSoma De Todos Os Numeros: ");
        total = Soma (numeros, total);
        System.out.printf ("%d", total);

        Subtraido (numeros, maiores);
        Somado (numeros, menores);

        System.out.println("\n\n");
    }
}