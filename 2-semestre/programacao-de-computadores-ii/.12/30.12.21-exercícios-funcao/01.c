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

double fatorial(double fat);
double maiorprimo(int maior);

int main(){
    system ("clear");
    srand(time(NULL));

    double fat, maior, resul;
    
    printf ("\nFatorial: ");
    scanf ("%lf", &fat);
    printf ("Maior primo: ");
    scanf ("%lf", &maior);

    fat = fatorial(fat);
    maior = maiorprimo(maior);

    resul = fat * maior;

    printf (" - Resultado: %.0lf x %.0lf = %.0lf", fat, maior, resul);

    printf ("\n\n");
    return 0;
}


double fatorial(double fat)
{
    int cont, resul;

    for (resul = 0, cont = fat; cont > 2;) 
    {
        cont--;
        resul = fat * cont;
        fat = resul;
    }

    return fat;            
} 

double maiorprimo(int maior)
{

    int cont, div;

    for (cont = 0, div = 1; div <= maior; div++)
    {
        if (maior % div == 0) { cont++; }
        if (cont > 2) { cont = 0, div = 0, maior--; }
    }

    if (cont == 2) { return maior; }
}