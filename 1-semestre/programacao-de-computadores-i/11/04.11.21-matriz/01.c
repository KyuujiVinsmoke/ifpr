#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

int main(){
    system ("clear");
    srand(time(NULL));

    int matriz[5][5], c, l, aux;

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

    printf ("\n\nMatriz Transposta: ");

    for (l = 0; l < 5; l++)	
	{
		printf ("\n");
		for (c = 0; c < 5; c++)
		{ 
			printf ("%i ", matriz[c][l]);	 
		}	 
	}	  

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm