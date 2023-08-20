#include <stdio.h>
#include <math.h>

int main(){

    double n1, n2, hipot;

    printf ("\nCatetos (CO CA): ");
    scanf ("%lf %lf", &n1, &n2);
    
    hipot = sqrt (pow (n1, 2) + pow (n2, 2) );

    printf ("\nHipotenusa = %.1lf", hipot);


    printf ("\n\n");
    return 0;

}   //gcc 01.c -o 01 -lm