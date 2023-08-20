#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2;
    double raiz;

    printf ("\nDigite dois valores inteiros: ");
    scanf ("%i %i", &n1, &n2);

    raiz = sqrt (pow (n1, n2) );

    printf ("\nRaiz = %.1lf", raiz);
    

    printf ("\n\n");
    return 0;

}   //gcc 01.c -o 01 -lm