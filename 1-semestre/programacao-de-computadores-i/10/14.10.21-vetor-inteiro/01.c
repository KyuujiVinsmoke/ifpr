#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int main(){

	srand(time(NULL));

	int n, vetor[12], entre, pares, nmaior;
    entre = 0;
    nmaior = 0;
    pares = 0;
	
    printf ("\nVetor Aleatório: ");

	for (n = 0; n < 12; n++)
	{
		vetor[n] = 10 + rand() % 40;
		printf("%i ", vetor[n]);

		if (vetor[n] > 20 && vetor[n] < 40) { entre++; }

		if (vetor[n] > 35) { nmaior++; }
	}
        
        printf ("\n - Qtde de números entre 20 e 40: %i", entre);
        printf ("\n - Números pares:");
      
        for (n = 0; n < 12; n++)

        {
        if (vetor[n] % 2 == 0) { pares = vetor[n], printf (" %i", pares); }
        }
        
        printf ("\n - Qtde de números maiores que 35: %i", nmaior);

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm