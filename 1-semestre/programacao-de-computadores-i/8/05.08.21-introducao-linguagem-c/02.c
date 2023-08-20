#include <stdio.h>
#include <math.h>

int main(){

    int v1, v2, v3, v4, v5, v6;
    
    v5 = 10;
    v6 = -200;
    v1 = v5 + v6;
    v2 = v5 - v6;
    v3 = v5 * v6;
    v4 = v6 / v5;

    printf ("\n> Valor de (v6) = %i", v6);
    printf ("\n> Valor de (v5) = %i", v5);
    printf ("\n> Soma: %i + %i = %i", v5, v6, v1);
    printf ("\n> Subtração: %i - %i = %i", v5, v6, v2);
    printf ("\n> Multiplicação: %i * %i = %i", v5, v6, v3);
    printf ("\n> Divisão: %i / %i = %i", v6, v5, v4);

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm