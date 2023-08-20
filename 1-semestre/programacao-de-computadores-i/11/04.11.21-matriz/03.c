#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define TAM 5

int main(){
    system ("clear");
    srand(time(NULL));

    int matriz[TAM][TAM], c, l, t, cont, pos1, pos2, todos[TAM*TAM];

	for (c = 0; c < 5; c++) 
	{
	    for (l = 0; l < 5; l++)	
		{ 
			matriz[c][l] = 10 + rand() % 41;			
		}	 
	}		

    printf ("\nMatriz Aleatória: ");  
		
	for (c = 0; c < 5; c++) 
	{
		printf ("\n");
		for (l = 0; l < 5; l++)	
		{ 
			printf ("%i ", matriz[c][l]);	 
		}	 
	}	  

	for (c = 0, t = 0; c < 5; c++) 
	{
		for (l = 0; l < 5; l++, t++)	
		{ 
			todos[t] = matriz[c][l];
		}	 
	}	  
	
	for (pos1 = 0; pos1 < 25; pos1++)
	{

		for (pos2 = pos1 + 1; pos2 < 25; pos2++)
		{
			if (todos[pos1] > todos[pos2]) {
				t = todos[pos1],
				todos[pos1] = todos[pos2],
				todos[pos2] = t;
			}
		}
	}

	printf ("\n\nMatriz Ordenada: ");

	for (t = 0; t != 25;)
	{
		printf ("\n");
		for (cont = 0; cont != 5; cont++, t++)
		{
			printf ("%i ", todos[t]);
		}
	}
    
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm