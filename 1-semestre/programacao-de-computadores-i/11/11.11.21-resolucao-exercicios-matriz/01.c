#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define branco		printf("\33[37m");
#define laranja 	printf("\33[33m");
#define roxo		printf("\33[35m");
#define verde		printf("\33[32m");

int main(){
    system ("clear");
	srand(time(NULL));

    int matriz[5][5], l, c, aux, baixo = 0, ver = 0, diag = 0, lar = 0, cima = 0, rox = 0;

	for (l = 0; l < 5; l++) 
	{
	    for (c = 0; c < 5; c++)	
		{ 
			matriz[l][c] = 10 + rand() % 41;			
		}	 
	}		

	for (l = 0, aux = 0; l < 4; l++)
	{
		for (c = l + 1; c < 5; c++)
		{
			if (matriz[l][c] > aux) { aux = matriz[l][c], rox = l, cima = c; }
		}
	}
	
	for (l = 0, c = 0, aux = 0; l < 5; c++, l++)
	{
		if (matriz[l][c] > aux) { aux = matriz[l][c], lar = l, diag = c; }
	}
	
	for (l = 1, aux = 0; l < 5; l++)
	{
		for (c = 0; c < l; c++)
		{
			if (matriz[l][c] > aux) { aux = matriz[l][c], ver = l, baixo = c; }
		}
	}

	printf ("Matriz Aleatória: ");  
		
	for (l = 0; l < 5; l++) 
	{
		printf ("\n");
		for (c = 0; c < 5; c++)	
		{ 
			branco;
			if (l == rox && cima == c) { roxo; }
			else if (l == lar && diag == c) { laranja; }
			else if (l == ver && baixo == c) { verde; }
		
			printf ("%i ", matriz[l][c]); 
		}	 
	}	  


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm