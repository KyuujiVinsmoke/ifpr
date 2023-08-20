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

    int cont1, cont2, cont3;
    char aux;
    char *n1 = malloc(20 * sizeof(char));
    char *n2 = malloc(20 * sizeof(char));
    char *n3 = malloc(20 * sizeof(char));

    printf ("Digite três palavras:\n");
    __fpurge(stdin);
    gets(n1);
    __fpurge(stdin);
    gets(n2);
    __fpurge(stdin);
    gets(n3);

    cont1 = strcmp(n1, n2);
    aux = strcmp(n1, n3);
    cont1 = cont1 + aux;

    cont2 = strcmp(n2, n1);
    aux = strcmp(n2, n3);
    cont2 = cont2 + aux;

    cont3 = strcmp(n3, n1);
    aux = strcmp(n3, n2);
    cont3 = cont3 + aux;
   
    printf (" - Ordem Alfabética: ");

    if (cont1 < cont2 && cont1 < cont3) { printf ("%s", n1); }
    else if (cont2 < cont1 && cont2 < cont3) { printf ("%s", n2); }
    else if (cont3 < cont1 && cont3 < cont2) { printf ("%s", n3); }

    printf ("-");

    if (cont1 > cont2 && cont1 < cont3 || cont1 < cont2 && cont1 > cont3) { printf ("%s", n1); }
    else if (cont2 > cont1 && cont2 < cont3 || cont2 < cont1 && cont2 > cont3) { printf ("%s", n2); }
    else if (cont3 > cont1 && cont3 < cont2 || cont3 < cont1 && cont3 > cont2) { printf ("%s", n3); }

    printf ("-");

    if (cont1 > cont2 && cont1 > cont3) { printf ("%s", n1); }
    else if (cont2 > cont1 && cont2 > cont3) { printf ("%s", n2); }
    else if (cont3 > cont1 && cont3 > cont2) { printf ("%s", n3); }
    
    printf ("\n\n");
    return 0;            
}  