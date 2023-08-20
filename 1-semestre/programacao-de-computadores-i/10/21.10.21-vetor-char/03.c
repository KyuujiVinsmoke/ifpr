#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define TAM 100

int main(){
    system ("clear");

    int c, b, rep;
    char conteu[TAM], bus[TAM], cont;

    printf ("String conteúdo: ");
    gets (conteu);

    printf ("String busca: ");
    gets (bus);
    
    for (b = 0, c = 0, cont = 0; c < TAM; c++)
    {
        if (bus[b] == '\0') { break; }
        else if (conteu[c] == bus[b]) { b++, cont++; }
        else { b = 0, c = c - cont, cont = 0; }
    }

    if (bus[b] == '\0') { printf ("- Achou!"); }
    else { printf ("- NÃO achou!"); }


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm