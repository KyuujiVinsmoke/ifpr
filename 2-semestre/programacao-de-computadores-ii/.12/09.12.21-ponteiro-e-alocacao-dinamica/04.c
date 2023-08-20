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

#define TAM 5

int main(){
    system ("clear");
    srand(time(NULL));

    int t, l;
    char *pont_p;

    printf ("Digite o tamanho: ");
    scanf ("%i", &t);

    pont_p = malloc(t * sizeof(char));

    printf ("Digite a palavra: ");
    __fpurge(stdin);
    gets (pont_p);

    printf (" - Invertida = ");

    for (l = t; l >= 0; l--)
    {
        printf ("%c", pont_p[l]);
    }
    

    printf ("\n\n");
    return 0;            
}  