#include <stdio.h>
#include <stdio_ext.h>
#include <stdlib.h>

#define TAM 99

void covid (char *sequencia, int *cont);

int main ()
{
    system ("clear");

    char *sequencia = malloc (TAM * sizeof(char));
    int cont = 0;

    printf ("---------------------------------\n");
    printf ("- Bases Nitrogenadas => A U C G -\n");
    printf ("---------------------------------\n");
    printf ("- Digite a sequência: ");
    __fpurge (stdin);
    gets (sequencia);
    covid (sequencia, &cont);
    printf ("- Buscando(%s)...\n", sequencia);
    printf ("- Total de ocorrências [%s] = %i", sequencia, cont);

    printf ("\n\n");
    return 0;
}

void covid (char *sequencia, int *cont)
{
    int a, b, c, letras, x;
    FILE *fp;

    fp = fopen ("linux.txt", "a+");

    for (a = 0, letras = -1; sequencia[a] != '\0'; a++)
    {   
        if (sequencia[a] > 96 && sequencia[a] < 123) { sequencia[a] = sequencia[a] - 32; }
        letras++;
    }

    char *teste = malloc (letras * sizeof (char));
    char *vetor = malloc (1 * sizeof (char));

    for (a = 0; a <= letras; a++)
    {
        teste[a] = fgetc (fp);
    }  

    for (c = 0, x = -1; teste[a] != EOF; a = letras, x = -1)
    {
        vetor[c] = fgetc (fp);
        if (vetor[c] != 'A' && vetor[c] != 'U' && vetor[c] != 'C' && vetor[c] != 'G') { vetor[c] = fgetc (fp); }
        if (vetor[c] != 'A' && vetor[c] != 'U' && vetor[c] != 'C' && vetor[c] != 'G') { vetor[c] = fgetc (fp); }
        
        for (a = 0, b = 1; a <= letras; a++, b++)
        {
            if (sequencia[a] == teste[a]) { x++; }

            if (a < letras) { teste[a] = teste[b]; }
            else if (a == letras) { teste[a] = vetor[c]; }
        }
        if (x == letras) { *cont++; }
    }

    fclose (fp);
}