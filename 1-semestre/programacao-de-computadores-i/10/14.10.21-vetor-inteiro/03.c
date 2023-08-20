#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int main(){

	srand(time(NULL));

	int n, vetor[4], vmedio;
	vmedio = 0;
	

	printf ("\nVetor Aleatório: ");

	for (n = 0; n < 4; n++)

	{
		vetor[n] = 10 + rand() % 90;
		
		printf("%i ", vetor[n]);

		vmedio = vetor[n] + vmedio;

	}

		vmedio = vmedio / 4;
		printf ("\n - Valor médio: %i", vmedio);
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm