#include <stdio.h>
#include <math.h>

int main(){

    float n1, n2, n3, delta, raiz1, raiz2;

    printf ("\nCoeficientes (a, b, c): ");
    scanf ("%f %f %f", &n1, &n2, &n3);
    
    delta = pow (n2, 2) - 4 * n1 * n3;
    raiz1 = ( (- n2 + sqrt (delta) ) / (2 * n1) );
    raiz2 = ( (- n2 - sqrt (delta) ) / (2 * n1) );
   
    printf ("\nRaízes = %.1f %.1f", raiz1, raiz2);


    printf ("\n\n");
    return 0;

}   //gcc 01.c -o 01 -lm