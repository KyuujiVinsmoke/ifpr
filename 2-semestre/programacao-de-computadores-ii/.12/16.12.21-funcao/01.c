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

int pitagoras();

int main(){
    system ("clear");
    srand(time(NULL));

    pitagoras();

    printf ("\n\n");
    return 0;
}


int pitagoras(double n1, double n2, double hipot){

    printf ("\nDigite o valor dos catetos: ");
    scanf ("%lf %lf", &n1, &n2);

    hipot = sqrt (pow (n1, 2) + pow (n2, 2) );

    printf (" - Hipotenusa: %.1lf", hipot);

    return 0;
}