#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2, n3, cont;
    n1 = 1;
    n2 = 1;

    printf ("\nNúmero de termos: ");
    scanf ("%i", &cont);

    printf ("\n- Série de Fibonacci(%i):", cont);


    for (; cont > 0; cont--) {

        printf (" %i", n1);

        n3 = n1 + n2;
        n1 = n2;
        n2 = n3;
    }
    

    printf ("\n\n");
    return 0;            

}  //gcc 01.c -o 01 -lm