#include <stdio.h>

int main(){

	int valor, quad, cub;
	
	printf("\nDigite um número: ");
	scanf ("%i", &valor);

	quad = valor * valor;
	cub = valor * valor * valor;
	
	printf ("\nO quadrado do número %i é: %i", valor, quad);
	printf ("\nO cubo do número %i é: %i", valor, cub);

	
	printf ("\n\n");
	return 0;
		
}