#include <stdio.h>
#include <math.h>

int main(){

	int n;
		
	printf ("\nDigite um número inteiro:");
    scanf ("%i", &n);

	if (n % 2 == 0) { printf ("\nO Número %i é par", n); }

    else { printf ("\nO número %i é impar", n); }
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm