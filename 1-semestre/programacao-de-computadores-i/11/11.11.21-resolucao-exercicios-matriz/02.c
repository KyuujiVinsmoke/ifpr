#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define TAM 3

int main(){
    system ("clear");
    srand(time(NULL));

    int matriz1[TAM][TAM], matriz2[TAM][TAM], resul[TAM][TAM], l1, c1, l2, c2, l, c;

	for (l = 0, l1 = 0, l2 = 0; l < TAM; l++, l1++, l2++) 
	{
	    for (c = 0, c1 = 0, c2 = 0; c < TAM; c++, c1++, c2++)
		{ 
			matriz1[l1][c1] = 2 + rand() % 4;
			matriz2[l2][c2] = 2 + rand() % 4;
			resul[l][c] = 0;		
		}	 
	}		

	for (l = 0, c = 0, l1 = 0; l1 < TAM; l1++)
	{
		for (c2 = 0; c2 < TAM; c++, c2++)
		{
			for (c1 = 0, l2 = 0; l2 < TAM; c1++, l2++)
			{
				resul[l][c] = resul[l][c] + matriz1[l1][c1] * matriz2[l2][c2];
			}
		}
	}

    for (l1 = 0, l2 = 0, l = 0; l < TAM; l1++, l2++, l++) 
	{
	    for (c1 = 0; c1 < TAM; c1++)	
		{ 
			printf ("%i ", matriz1[l1][c1]);
		}	 

		if (l1 == 1) { printf ("  X   "); }
		else { printf ("      "); }

		for (c2 = 0; c2 < TAM; c2++)	
		{ 
			printf ("%i ", matriz2[l2][c2]);
		}	 

		if (l1 == 1) { printf ("  =   "); }
		else { printf ("      "); }

		for (c = 0; c < TAM; c++)	
		{ 
			printf ("%i ", resul[l][c]);
		}	 

		printf ("\n");
	
	}		
		
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm