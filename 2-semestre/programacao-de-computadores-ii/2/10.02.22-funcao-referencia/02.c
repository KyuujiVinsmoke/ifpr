#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define TAM 10

void ordenar (int *vetor);

int main ()
{
    system ("clear");
    srand (time(NULL));

    int x;
    int *vetor = malloc (TAM * sizeof(int));

    printf ("Vetor Aleatorio");
    
    for (x = 0; x < TAM; x++)
    {
        vetor[x] = 10 + (rand()%90);
        printf (" %i", vetor[x]);
    }

    ordenar (vetor);

    printf ("\nVetor Ordenado");
    
    for (x = 0; x < TAM; x++)
    {
        printf (" %i", vetor[x]);
    }

    printf ("\n\n");
    return 0;
}

void ordenar (int *vetor)
{
    int n1, n2, aux;

    for (n1 = 0; n1 < TAM; n1++)
    {
        for (n2 = n1; n2 < TAM; n2++)
        {
            if (vetor[n1] > vetor[n2])
            {
                aux = vetor[n1],
                vetor[n1] = vetor[n2],
                vetor[n2] = aux;
            }
        }
    }
}