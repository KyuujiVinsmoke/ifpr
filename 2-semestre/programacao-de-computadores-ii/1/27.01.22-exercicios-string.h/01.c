#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>
#include <string.h>

#define preto		"\33[30m"
#define vermelho    "\33[31m"
#define verde		"\33[32m"
#define amarelo	   	"\33[33m"
#define azulescuro	"\33[34m"
#define roxo		"\33[35m"
#define azulclaro	"\33[36m"
#define branco      "\33[37m"

#define TAM 20

int letras_iguais (char p1[TAM], char p2[TAM]);

int main()
{
    system ("clear");
    srand(time(NULL));

    char *p1 = malloc(TAM * sizeof(char));
    char *p2 = malloc(TAM * sizeof(char));

	printf ("Digite duas palavras:\n");
	__fpurge(stdin);
    gets(p1);
    __fpurge(stdin);
    gets(p2);

    letras_iguais (p1, p2);
    
    printf ("\n\n");
    return 0;            
}

int letras_iguais (char p1[TAM], char p2[TAM])
{
    int n, cont;

    for (cont = 0, n = 0; p1[n] != '\0' && p2[n] != '\0'; n++)
    {
        cont = strncmp (p1, p2, n);
    }

    printf ("- Letras iguais: %i / ", n);

    for (cont = n, n = 0; n < cont; n++)
    {
        printf ("%c", p1[n]);
    }

    return 0;
}