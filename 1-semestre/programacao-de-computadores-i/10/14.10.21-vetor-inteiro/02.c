#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int main(){

	srand(time(NULL));

	int n, vetor[12], nmenor, pmenor, nmaior, pmaior, cont;
	nmenor = 100;
	nmaior = 0;
	

	printf ("\nVetor Aleatório: ");

	for (n = 0; n < 12; n++)

	{
		vetor[n] = 10 + rand() % 90;
		printf("%i ", vetor[n]);

		if (vetor[n] > nmaior) { nmaior = vetor[n], pmaior = n; }

		if (vetor[n] < nmenor) { nmenor = vetor[n], pmenor = n; }
	}

		printf ("\n - Maior elemento: %i / Posição: %i", nmaior, pmaior);
		printf ("\n - Menor elemento: %i / Posição: %i", nmenor, pmenor);

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm