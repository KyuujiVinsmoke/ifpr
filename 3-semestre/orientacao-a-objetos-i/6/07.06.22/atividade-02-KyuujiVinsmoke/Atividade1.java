public class Atividade1
{
    public static int Pares (int[] numeros)
    {
        System.out.printf ("Numeros Pares:");

        for (int a = 0; a < numeros.length; a++)
        {
            if (0 == (numeros[a] % 2))
            {
                System.out.printf (" %d", numeros[a]);
            }
        }

        return 0;
    }

    public static int Impares (int[] numeros)
    {
        System.out.printf ("\n\nNumeros Impares:");

        for (int a = 0; a < numeros.length; a++)
        {
            if (0 != (numeros[a] % 2))
            {
                System.out.printf (" %d",numeros[a]);
            }
        }

        return 0;
    }

    public static int Primos (int[] numeros)
    {
        int cont = 0;

        System.out.printf ("\n\nNumeros Primos:");

        for (int a = 0; a < numeros.length; a++, cont = 0)
        {
            for (int b = 0; b <= a; b++)
            {
                if (0 == numeros[a] % numeros[b])
                {
                    cont++;
                }
            }
            
            if (cont == 2) 
            {
                System.out.printf (" %d", numeros[a]);
            }
        }

        return 0;
    }
    
    public static void main(String[] args)
    {
        System.out.println("\n\n");

        int[] numeros = new int [2500];

        for (int a = 0; a < numeros.length; a++)
        {
            numeros[a] = a + 1;
        }

        Pares (numeros);
        Impares (numeros);
        Primos (numeros);

        System.out.println("\n\n");
    }
}