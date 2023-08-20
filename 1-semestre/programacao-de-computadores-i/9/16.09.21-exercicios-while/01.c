#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2, div, cont;

    printf ("\nDigite dois números: ");
    scanf ("%i %i", &n1, &n2);

    printf ("Números primos entre (%i) e (%i): ", n1, n2);

    while (n1 <= n2) {
        cont = 0;
        div = 1;

        while (div <= n1) {
            if (n1 % div == 0) { cont++; }

            div++;

        }

    if (cont == 2) { printf ("%i ", n1); }

    n1++;

    }
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm