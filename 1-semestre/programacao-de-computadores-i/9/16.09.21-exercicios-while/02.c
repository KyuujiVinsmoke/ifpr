#include <stdio.h>
#include <math.h>

int main(){

 int n, lar, alt;
 char ast;
 ast = 42;

 printf ("\nLargura e Altura: ");
 scanf ("%i %i", &lar, &alt);
 n = lar;

    do { (lar = n);

    do { if (lar > 0) { printf ("%c ", ast); }
    lar--;

    } while (lar > 0);

    if (alt > 0) { printf ("\n");
    alt--; }

    } while (n != 0 && alt != 0);


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm