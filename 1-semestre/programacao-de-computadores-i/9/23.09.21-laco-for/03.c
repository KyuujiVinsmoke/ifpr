#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2, n3, resul, cont;

    printf ("\n\tDigite 2 valores inteiros: ");
    scanf ("%i %i", &n1, &n2);

    if (n1 < n2) {

        if (n1 % 2 == 1) { (n1++), printf ("\n\tSomando valores pares: %i ", n1); }

        else if (n1 % 2 == 0) { (n1 = n1 + 2), printf ("\n\tSomando valores pares: %i ", n1); }

        n3 = n1;
                    
        for (n1 = n1 + 2; n1 < n2; n1 = n1 + 2) {

            printf ("+ %i ", n1);

            resul = n1 + n3;
            n3 = resul;
           
        }

        printf ("= %i", resul);
    
    }

    else if (n1 >= n2) { printf ("\n\tValores incorretos"); }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm