#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define TAM 10

int main(){
    system ("clear");

    srand(time(NULL));

    int v, p, rep;
    char vetor[TAM], pala[TAM], cont;

    printf ("Vetor aleatório:");

    for (v = 0; v < TAM; v++)
    {
        if (rand() % 2 == 0) { vetor[v] = 65 + (rand()%26); }
        else { vetor[v] = 97 + (rand()%26); }
        
        for (cont = 0, rep = 0; rep != v; rep++)
        {
            if (vetor[v] != vetor[rep]) { cont++; }
        }
        if (cont == rep) { printf (" %c", vetor[v]); }
        else { v--;}
    }
    vetor[v] = '\0';

    printf ("\nPalavra: ");
    gets (pala);
    
    for (p = 0, v = 0; v < TAM; v++)
    {
        if (pala[p] == '\0') { break; }
        else if (vetor[v] == pala[p]) { p++; }
        else { p = 0; }
    }

    if (pala[p] == '\0') { printf ("\n [É possível]"); }
    else { printf ("\n [NÂO É possível]"); }


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm