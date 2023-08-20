#include <stdio.h>
#include <math.h>

int main(){

    int n, cont, resul;
    resul = 0;

    printf ("\nDigite um valor inteiro: ");
    scanf ("%i", &n);

    printf ("\n- Fatorial(%i) = %i ", n, n);

    for (cont = n; cont > 2; ) {

        cont--;
        resul = n * cont;
        n = resul;

        printf ("x %i ", cont);

    }
    
    printf ("= %i", n);

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm