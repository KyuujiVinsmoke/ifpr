#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2, n3, n4, n5, n6, cont, resul;

    printf ("\nNúmeros: ");
    scanf ("%i %i %i %i %i %i", &n1, &n2, &n3, &n4, &n5, &n6);

    printf ("- Ordenado ");

        if (n1 > n2 && n1 > n3 && n1 > n4 && n1 > n5 && n1 > n6) { cont = n1; }

        if (n2 > n1 && n2 > n3 && n2 > n4 && n2 > n5 && n2 > n6) { cont = n2; }

        if (n3 > n1 && n3 > n2 && n3 > n4 && n3 > n5 && n3 > n6) { cont = n3; }

        if (n4 > n1 && n4 > n2 && n4 > n3 && n4 > n5 && n4 > n6) { cont = n4; }

        if (n5 > n1 && n5 > n2 && n5 > n3 && n5 > n4 && n5 > n6) { cont = n5; }

        if (n6 > n1 && n6 > n2 && n6 > n3 && n6 > n4 && n6 > n5) { cont = n6; }

        cont++;

        do {
            if (n1 < n2 && n1 < n3 && n1 < n4 && n1 < n5 && n1 < n6 && n1 < cont) { printf ("%i ", n1), (n1 = cont); }

            if (n2 < n1 && n2 < n3 && n2 < n4 && n2 < n5 && n2 < n6 && n2 < cont) { printf ("%i ", n2), (n2 = cont); }

            if (n3 < n1 && n3 < n2 && n3 < n4 && n3 < n5 && n3 < n6 && n3 < cont) { printf ("%i ", n3), (n3 = cont); }

            if (n4 < n1 && n4 < n2 && n4 < n3 && n4 < n5 && n4 < n6 && n4 < cont) { printf ("%i ", n4), (n4 = cont); }

            if (n5 < n1 && n5 < n2 && n5 < n3 && n5 < n4 && n5 < n6 && n5 < cont) { printf ("%i ", n5), (n5 = cont); }

            if (n6 < n1 && n6 < n2 && n6 < n3 && n6 < n4 && n6 < n5 && n6 < cont) { printf ("%i ", n6), (n6 = cont); }

            if (n1 == cont && n2 == cont && n3 == cont && n4 == cont && n5 == cont && n6 == cont) { resul = cont; }

         }  while (resul != cont);

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm