#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define amarelo 	printf("\33[33m");
#define branco		printf("\33[37m");
#define roxo		printf("\33[35m");
#define verde		printf("\33[32m");

#define TAM 5

int main(){
    system ("clear");
    srand(time(NULL));

    int n, l, c;
    char matriz[TAM][TAM], pala[TAM], esp[TAM][TAM];
   
    for (l = 0; l < TAM; l++)
    {
        for (c = 0; c < TAM; c++)
        {
            matriz[l][c] = 65 + (rand()%26);
            esp[l][c] = 0;
        }
    }
    
    printf ("Palavra: ");
    scanf ("%s", pala);

    printf ("Direção (1-Horizontal / 2-Vertical): ");
    scanf ("%i", &n);

    if (n == 1) { l = rand()%TAM;

        for (c = 0; pala[c] != '\0'; c++)
        {
            matriz[l][c] = pala[c];
            esp[l][c] = 1;
        }
    }

    else  { c = rand()%TAM;

        for (l = 0; pala[l] != '\0'; l++)
        {
            matriz[l][c] = pala[l];
            esp[l][c] = 1;
        }
    }
    
    for (l = 0; l < TAM; l++)
    {
        for (c = 0; c < TAM; c++)
        {
            if (esp[l][c] == 1) { verde; }
            else { branco; }
            printf ("%c ", matriz[l][c]);
        }
        printf ("\n");
    }
    	
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm