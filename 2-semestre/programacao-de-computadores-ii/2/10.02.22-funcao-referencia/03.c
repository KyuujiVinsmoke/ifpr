#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>

#define TAM 3

void transposta (int **matriz);

int main ()
{
    system ("clear");
    srand(time(NULL));

    int l, c;
    int **matriz = malloc (TAM * sizeof (int*));
    
    for (l = 0; l < TAM; l++)
    {
        matriz[l] = malloc (TAM * sizeof (int));
    }

    printf ("Matriz:");

    for (l = 0; l < TAM; l++)
    {
        printf ("\n");

        for (c = 0; c < TAM; c++)
        {
            matriz[l][c] = 10 + (rand () % 90);
            printf ("%i ", matriz[l][c]);
        }
    }

    transposta (matriz);

    printf ("\n\nTransposta:");

    for (l = 0; l < TAM; l++)
    {
        printf ("\n");

        for (c = 0; c < TAM; c++)
        {
            printf ("%i ", matriz[l][c]);
        }
    }


    printf ("\n\n");
    return 0;
}

void transposta (int **matriz)
{
    int aux[TAM][TAM], l, c;

      for (l = 0; l < TAM; l++)
    {
        for (c = 0; c < TAM; c++)
        {
           aux[c][l] = matriz[l][c];
        }
    }

    for (l = 0; l < TAM; l++)
    {
        for (c = 0; c < TAM; c++)
        {
           matriz[l][c] = aux[l][c];
        }
    }

}