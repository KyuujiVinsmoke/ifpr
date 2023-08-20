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

int main()
{
    system ("clear");
    srand(time(NULL));

    int n;
    char *p1 = malloc(20 * sizeof(char));
    char *p2 = malloc(20 * sizeof(char));
    char *p3 = malloc(20 * sizeof(char));

    printf ("Digite o valor inteiro: ");
    scanf ("%i", &n);

    char *conc = malloc((n*3) * sizeof(char));

	printf ("Digite três palavras:\n");
	__fpurge(stdin);
    gets(p1);
    __fpurge(stdin);
    gets(p2);
	__fpurge(stdin);
    gets(p3);

    strncat (conc, p1, n);
    strncat (conc, p2, n);
    strncat (conc, p3, n);

	printf ("- Concatenado: %s", conc);


    printf ("\n\n");
    return 0;            
}  