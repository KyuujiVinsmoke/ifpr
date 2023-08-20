#include <stdio.h>
#include <math.h>

int main(){

    int n1, n2, n3, n4, n5, n6, n7, cont;

    printf ("\nDigite 7 números: ");
    scanf ("%i %i %i %i %i %i %i", &n1, &n2, &n3, &n4, &n5, &n6, &n7);

    printf ("\n- Ordenado crescente ");

        if (n1 > n2 && n1 > n3 && n1 > n4 && n1 > n5 && n1 > n6 && n1 > n7) { cont = n1; }

        else if (n2 > n1 && n2 > n3 && n2 > n4 && n2 > n5 && n2 > n6 && n2 > n7) { cont = n2; }

        else if (n3 > n1 && n3 > n2 && n3 > n4 && n3 > n5 && n3 > n6 && n3 > n7) { cont = n3; }

        else if (n4 > n1 && n4 > n2 && n4 > n3 && n4 > n5 && n4 > n6 && n4 > n7) { cont = n4; }

        else if (n5 > n1 && n5 > n2 && n5 > n3 && n5 > n4 && n5 > n6 && n5 > n7) { cont = n5; }

        else if (n6 > n1 && n6 > n2 && n6 > n3 && n6 > n4 && n6 > n5 && n6 > n7) { cont = n6; }

        else if (n7 > n1 && n7 > n2 && n7 > n3 && n7 > n4 && n7 > n5 && n7 > n6) { cont = n7; }

        
        for ( cont++; n1 < cont || n2 < cont || n3 < cont || n4 < cont || n5 < cont || n6 < cont || n7 < cont;) {

            if (n1 < n2 && n1 < n3 && n1 < n4 && n1 < n5 && n1 < n6 && n1 < n7 && n1 < cont) { printf ("%i ", n1), (n1 = cont); }

            else if (n2 < n1 && n2 < n3 && n2 < n4 && n2 < n5 && n2 < n6 && n2 < n7 && n2 < cont) { printf ("%i ", n2), (n2 = cont); }

            else if (n3 < n1 && n3 < n2 && n3 < n4 && n3 < n5 && n3 < n6 && n3 < n7 && n3 < cont) { printf ("%i ", n3), (n3 = cont); }

            else if (n4 < n1 && n4 < n2 && n4 < n3 && n4 < n5 && n4 < n6 && n4 < n7 && n4 < cont) { printf ("%i ", n4), (n4 = cont); }

            else if (n5 < n1 && n5 < n2 && n5 < n3 && n5 < n4 && n5 < n6 && n5 < n7 && n5 < cont) { printf ("%i ", n5), (n5 = cont); }

            else if (n6 < n1 && n6 < n2 && n6 < n3 && n6 < n4 && n6 < n5 && n6 < n7 && n6 < cont) { printf ("%i ", n6), (n6 = cont); }

            else if (n7 < n1 && n7 < n2 && n7 < n3 && n7 < n4 && n7 < n5 && n7 < n6 && n7 < cont) { printf ("%i ", n7), (n7 = cont); }

        }
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm