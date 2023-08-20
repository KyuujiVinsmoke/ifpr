#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define TAM 15

int main(){
    system ("clear");

    srand(time(NULL));

    int v, cont, rep;
    char vetor[TAM], a;
    a = 64;

    printf ("Vetor aleatório:");

    for (v = 0; v < TAM; v++)
    {
        vetor[v] = 65 + (rand()%26);
        printf (" %c", vetor[v]);
    }

    printf ("\n- Vetor aleatório:");

    for (v = 0; v != TAM; v++)
    {
        for (cont = 0, rep = 0; rep != v; rep++)
        {
            if (vetor[v] == vetor[rep]) { cont++;}
        }
        if (cont == 0) { printf (" %c", vetor[v]); }
        else { printf (" %c", a); }
    }


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm