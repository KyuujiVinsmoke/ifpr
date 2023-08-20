#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define TAM 50

int main(){
    system ("clear");

    int l;
    char frase[TAM], letra, cont;

    printf ("\nDigite a frase: ");
    gets (frase);

    printf ("Digite o Caractere: ");
    scanf ("%c", &letra);

    for (l = 0, cont = 0; frase[l] != '\0'; l++)
    {
        if (letra == frase[l]) { cont++; }
    }

    printf (" - O caractere (%c) foi encontrado (%i) veze(s)", letra, cont);

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm