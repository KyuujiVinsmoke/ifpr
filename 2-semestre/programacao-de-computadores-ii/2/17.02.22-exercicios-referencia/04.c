#include <stdio.h>
#include <stdlib.h>

void piramide (char **pir, int l, int c);

int main ()
{
    system ("clear");

    int l, c, cont;

    printf ("Altura da pirâmide: ");
    scanf ("%i", &l);

    char **pir = malloc (l * sizeof (char*));
    
    for (c = 0; c < l; c++)
    {
        pir[c] = malloc (l * sizeof (char));
    }

    l--;

    piramide (pir, l, c);

    cont = l;

    for (l; l >= 0; l--)
    {
        for (c = 0; c <= cont; c++)
        {
            printf ("%c", pir[l][c]);
            printf (" ");
        }
        
        printf ("\n");
    }
    
    printf("\n\n");
    return 0;
} 

void piramide (char **pir, int l, int c)
{
    int cont = l;

    for (; l >= 0; l--)
    {
        for (c = 0; c <= cont; c++)
        {
            if (c >= l) { pir[l][c] = '*'; }
        }
    }
}