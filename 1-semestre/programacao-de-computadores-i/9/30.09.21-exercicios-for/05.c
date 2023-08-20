#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2, cont, resul, flag;

    printf ("\nDigite dois números inteiros: ");
    scanf ("%i %i", &n1, &n2);

    printf ("%i = %i", n1, n1);

    for (cont = n1 + 1; cont <= n2; cont++) {

        resul = n1 + cont;

        printf ("\n%i + %i = %i", n1, cont, resul);

        n1 = resul;

    }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm