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

#define TAM 5

int primo();

int main(){
    system ("clear");
    srand(time(NULL));

    primo();

    printf ("\n\n");
    return 0;
}


int primo(int n, int cont, int div){

    printf ("Digite um valor: ");
    scanf ("%i", &n);

    for (div = 1, cont = 0; div <= n; div++)
    {
       
        if (n % div == 0) { cont++; }

    }

    if (cont == 2) { printf ("- PRIMO"); }
    
    else { printf ("- NÃO PRIMO"); } 

    return 0;            
} 
