#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

int main(){
    system ("clear");

    int n, ast, espaco;

    	printf ("Número ímpar: ");
        scanf ("%i", &n);

        for (ast = n; ast != 0; ast--)
        {
            printf ("* ");
        }
        
        for (ast = n - 2; ast != 0; ast--)
        {
            printf ("\n*");
            for (espaco = n - 2; espaco != 0; espaco--)
            {
            if (ast == n / 2 && espaco == n / 2) { printf (" *"); }
            else { printf ("  "); }
            }
            printf (" *");
        }
        
            printf ("\n");
        for (ast = n; ast != 0; ast--)
        {
            printf ("* ");
        }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm