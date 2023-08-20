#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>
#include <stdlib.h>
#include <string.h>

#define preto		"\33[30m"
#define vermelho    "\33[31m"
#define verde		"\33[32m"
#define amarelo	   	"\33[33m"
#define azulescuro	"\33[34m"
#define roxo		"\33[35m"
#define azulclaro	"\33[36m"
#define branco      "\33[37m"

#define TAM 9

double baskhara ();

int main()
{
    system ("clear");
    srand(time(NULL));

    int a, b, c;
    double x1, x2;

    printf ("\nDigite os coeficientes (a), (b) e (c): ");
    scanf ("%i %i %i", &a, &b, &c);
    
    baskhara (a, b, c, &x1, &x2);

    printf ("- Raízes: %.1lf %.1lf", x1, x2);

    printf ("\n\n");
    return 0;            
} 

double baskhara (int a, int b, int c, double *x1, double *x2)
{

    *x1 = (-b + sqrt(b * b - (4 * a * c))) / 2 * a;
    *x2 = (-b - sqrt(b * b - (4 * a * c))) / 2 * a;
    
    return 0;
}