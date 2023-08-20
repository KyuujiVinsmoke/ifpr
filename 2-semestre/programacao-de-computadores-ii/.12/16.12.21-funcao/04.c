#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define preto		"\33[30m"
#define vermelho    "\33[31m"
#define verde		"\33[32m"
#define amarelo	   	"\33[33m"
#define azulescuro	"\33[34m"
#define roxo		"\33[35m"
#define azulclaro	"\33[36m"
#define branco      "\33[37m"

int ordenar();

int main(){
    system ("clear");
    srand(time(NULL));

    ordenar();

    printf ("\n\n");
    return 0;            
}  


int ordenar(char l[5], int aux, int TAM1, int TAM2){

    printf ("Digite cinco letras: ");
    scanf ("%c %c %c %c %c", &l[0], &l[1], &l[2], &l[3], &l[4]);

    printf (" - Ordenado: ");

    for (TAM1 = 0; TAM1 < 5; TAM1++)
	{
	
		for (TAM2 = TAM1 + 1; TAM2 < 5; TAM2++)
		{

            if (l[TAM1] > 91) { l[TAM1] = l[TAM1] - 32; }
            if (l[TAM2] > 91) { l[TAM2] = l[TAM2] - 32; }

		    if (l[TAM1] > l[TAM2]) { 
            aux = l[TAM1], 
            l[TAM1] = l[TAM2], 
            l[TAM2] = aux; }
		
        }
	
        printf ("%c ", l[TAM1]);
    
    }

    return 0;            
}  