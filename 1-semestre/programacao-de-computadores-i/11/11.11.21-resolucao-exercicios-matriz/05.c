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

    int l, c, cont;
    char matriz[TAM][TAM], p1[TAM], p2[TAM], esp[TAM][TAM];
   
    for (l = 0; l < TAM; l++)
    {
        for (c = 0; c < TAM; c++)
        {
            matriz[l][c] = 65 + (rand()%26);
            esp[l][c] = 0;
        }
    }
    
    printf ("Palavra: ");
    scanf ("%s %s", p1, p2);

   	l = rand()%TAM;
    for (c = 0; p1[c] != '\0'; c++)
    {
        matriz[l][c] = p1[c];
        esp[l][c] = 1;
    }
   
    c = rand()%TAM;
    for (l = 0; p2[l] != '\0'; l++)
    {
        matriz[l][c] = p2[l];
        esp[l][c] = 1;
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