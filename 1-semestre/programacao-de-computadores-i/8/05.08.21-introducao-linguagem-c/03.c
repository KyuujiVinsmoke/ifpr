#include <stdio.h>
#include <math.h>

int main(){

    int a, b, c, d;
    
    a = 5;
    d = 10;
    b = (a + a) + (d * d);
    c = (d * d) / b;

    printf ("\n> Valor de (a) = %i", a);
    printf ("\n> Valor de (b) = %i", b);
    printf ("\n> Valor de (c) = %i", c);
    printf ("\n> Valor de (d) = %i", d);

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm