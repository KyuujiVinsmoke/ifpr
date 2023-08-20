#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2;
    float pot;

    printf ("\nDigite dois valores inteiros: ");
    scanf ("%i %i", &n1, &n2);

    pot = pow (n1, n2);

    printf ("\nPotência = %.1f", pot);
    
    
    printf ("\n\n");
    return 0;

}   //gcc 01.c -o 01 -lm