import java.util.Random;

public class Pivo {

    public static void main (String[] args) {

        int TAM = 10;
        int[] vetor = new int[TAM];
        Random sort = new Random();

        for (int i = 0; i < vetor.length; i++) 
        {
            vetor[i] = sort.nextInt(100);
        }

        System.out.print ("Quick sort inicio: ");
        quickSortMeio (vetor, 0, vetor.length - 1);

        for (int i = 0; i < vetor.length; i++) 
        {
            System.out.print (vetor[i] + " ");
        }

        for (int i = 0; i < vetor.length; i++) 
        {
            vetor[i] = sort.nextInt(100);
        }

        System.out.print ("\nQuick sort meio: ");
        quickSortMeio (vetor, 0, vetor.length - 1);

        for (int i = 0; i < vetor.length; i++) 
        {
            System.out.print (vetor[i] + " ");
        }
    }

    private static void quickSort (int[] vetor, int ini, int fim) 
    {
        if (ini < fim) 
        {
            int pivo = separar (vetor, ini, fim);
            quickSort (vetor, ini, pivo - 1);
            quickSort (vetor, pivo + 1, fim);
        }
    }

    private static int separar (int[] vetor, int ini, int fim) 
    {
        int pivo = vetor[ini];
        int i = ini + 1;
        while (i <= fim) 
        {
            if (vetor[i] <= pivo)
            {
                i++;
            }

            else if (pivo < vetor[fim])
            {
                fim--;
            }

            else 
            {
                int swap = vetor[i];
                vetor[i] = vetor[fim];
                vetor[fim] = swap;
                i++;
                fim--;
            }
        }

        vetor[ini] = vetor[fim];
        vetor[fim] = pivo;
        return fim;
    }

    private static void quickSortMeio (int[] vetor, int ini, int fim) 
    {
        if (ini < fim) 
        {
            int pivo = separarMeio (vetor, ini, fim);
            quickSort (vetor, ini, pivo - 1);
            quickSort (vetor, pivo + 1, fim);
        }
    }

    private static int separarMeio (int[] vetor, int ini, int fim) 
    {
        int pivo = vetor[ini + fim / 2];
        int i = ini;
        while (i <= fim) 
        {
            if (vetor[i] <= pivo)
            {
                i++;
            }

            else if (pivo < vetor[fim])
            {
                fim--;
            }

            else 
            {
                int swap = vetor[i];
                vetor[i] = vetor[fim];
                vetor[fim] = swap;
                i++;
                fim--;
            }
        }

        vetor[ini] = vetor[fim];
        vetor[fim] = pivo;
        return fim;
    }
}