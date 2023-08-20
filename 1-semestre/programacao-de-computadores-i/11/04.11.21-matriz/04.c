#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

int main(){
    system ("clear");
	srand(time(NULL));

    int matriz[5][5], c, l, linha, valor;

	for (c = 0; c < 5; c++) 
	{
		for (l = 0; l < 5; l++)	
		{ 
			matriz[c][l] = 10 + rand() % 40;		
		}	 
	}		

    printf ("\nMatriz Aleatória: ")  ; 
	for (c = 0; c < 5; c++) 
	{
		printf ("\n")	 ;
		for (l = 0; l < 5; l++)	
		{ 
			printf ("%i ", matriz[c][l]);	 
		}	 
	}	  

	printf ("\n\n - Escolha uma linha: ");
	scanf ("%i", &linha);
	
	printf (" - Escolha um valor: ");
	scanf ("%i", &valor);

	for (c = 0; c < 5; c++)
	{
		for (l = 0; l < 5; l++)
		{
			if (c != linha) { matriz[c][l] = valor; }
		}
	}

	printf ("\nMatriz Modificada: ");
	
	for (c = 0; c < 5; c++) 
	{
		printf ("\n");
		for (l = 0; l < 5; l++)	
		{ 
		printf ("%i ", matriz[c][l]);	 
		}	 
	}	

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm