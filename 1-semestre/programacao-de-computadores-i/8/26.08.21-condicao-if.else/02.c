#include <stdio.h>
#include <math.h>

int main(){

	int n1, n2, n3;
		
	printf ("\nDigite três números inteiro: ");
	scanf ("%i %i %i", &n1, &n2, &n3);
		
	if (n1 < n2 && n1 < n3) { printf ("\nO número menor é: %i", n1); }

	else if (n2 < n1 && n2 < n3) { printf ("\nO número menor é: %i", n2); }
	
	else if (n3 < n1 && n3 < n2) { printf ("\nO número menor é: %i", n3); }

	if (n1 > n2 && n1 > n3) { printf ("\nO número maior é: %i", n1); }

	else if (n2 > n1 && n2 > n3) { printf ("\nO número maior é: %i", n2); }

	else if (n3 > n1 && n3 > n2) { printf ("\nO número maior é: %i", n3); }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm