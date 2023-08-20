#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define preto		"\33[30m"
#define vermelho    "\33[31m"
#define verde		"\33[32m"
#define amarelo	   	"\33[33m"
#define azulescuro	"\33[34m"
#define roxo		"\33[35m"
#define azulclaro	"\33[36m"
#define branco      "\33[37m"

#define TAM 20

int main(){
    system ("clear");
    srand(time(NULL));

    int l, cont;
    char *pont_p1, *pont_p2;

    pont_p1 = malloc(TAM * sizeof(char));
    pont_p2 = malloc(TAM * sizeof(char));

    printf ("Primeira palavra: ");
    __fpurge(stdin);
    gets (pont_p1);
    
    printf ("Segunda palavra: ");
    __fpurge(stdin);
    gets (pont_p2);

    for (l = 0, cont = 0; pont_p1[l] != '\0' || pont_p2[l] != '\0'; l++)
    {
        if (pont_p1[l] != pont_p2[l]) { printf ("\n - Diferentes, posição %i: '%c' != '%c'", l, pont_p1[l], pont_p2[l]), cont++; }
    }

    if (cont == 0) { printf (" - Palavras Iguais"); }


    printf ("\n\n");
    return 0;  
}          