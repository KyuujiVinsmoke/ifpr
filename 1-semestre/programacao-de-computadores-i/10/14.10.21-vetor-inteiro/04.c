#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int main(){

	srand(time(NULL));

	int n, vetor[12], cont1, cont2, aux;

	printf ("\n- Vetor Aleatório: ");

	for (n = 0; n < 12; n++)

	{
		vetor[n] = 10 + rand() % 90;
		
		printf("%i ", vetor[n]);

	}

	printf ("\n- Vetor Ordenando: ");

	for (cont1 = 0; cont1 < 12; cont1++)

	{
	
		for (cont2 = cont1 + 1; cont2 < 12; cont2++)
	
		{
		if (vetor[cont1] < vetor[cont2]) { aux = vetor[cont1], vetor[cont1] = vetor[cont2], vetor[cont2] = aux; }
		}
	}

		for (n = 0; n < 12; n++)
	
		{
		printf ("%i ", vetor[n]);
		}


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm