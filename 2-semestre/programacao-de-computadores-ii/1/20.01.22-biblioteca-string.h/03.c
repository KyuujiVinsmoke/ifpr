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

#define TAM 5

int main(){
    system ("clear");
    srand(time(NULL));

    char *n1 = malloc(20 * sizeof(char));
    char *n2 = malloc(20 * sizeof(char));
    char *n3 = malloc(20 * sizeof(char));
    char *conc = malloc(60 * sizeof(char));

    printf ("Digite três palavras:\n");
    __fpurge(stdin);
    gets(n1);
    __fpurge(stdin);
    gets(n2);
    __fpurge(stdin);
    gets(n3);

    strcpy(conc, n1);
    strcat(conc, n2);
    strcat(conc, n3);

    printf ("\n - Concatenado: %s", conc);

    
    printf ("\n\n");
    return 0;            
}  