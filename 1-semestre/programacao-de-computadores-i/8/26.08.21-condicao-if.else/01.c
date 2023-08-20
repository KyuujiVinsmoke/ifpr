#include <stdio.h>
#include <math.h>

int main(){

	int n;
		
	printf ("\nDigite um número inteiro: ");
	scanf ("%i", &n);

	if (n > 0) { printf ("\nO número é positivo"); }
	
	else if (n < 0) { printf ("\nO número é negativo"); }
	
	else if (n != 0) { printf ("\nO número é neutro"); }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm