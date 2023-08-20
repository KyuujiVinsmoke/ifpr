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

int main(){
    system ("clear");
    srand(time(NULL));

    int t1, t2, l, pos;
    char *pont_p1, *pont_p2, *resul;

    printf ("Digite os dois tamanhos: ");
    scanf ("%i %i", &t1, &t2);

    pont_p1 = malloc(t1 * sizeof(char));
    pont_p2 = malloc(t2 * sizeof(char));
    resul = malloc((t1+t2+1) * sizeof(char));

    printf ("Digite a primeira palavra: ");
    __fpurge(stdin);
    gets (pont_p1);
    
    printf ("Digite a segunda palavra: ");
    __fpurge(stdin);
    gets (pont_p2);

    for(l = 0, pos=0; pont_p1[l] != '\0'; l++, pos++) 
    {  
        resul[pos] = pont_p1[l];
    }
    
    resul[pos] = '-';

    for(pos++, l=0; pont_p2[l] != '\0'; l++, pos++) 
    {
        resul[pos] = pont_p2[l];
    }

    printf (" - Concatenadas = %s", resul);


    printf ("\n\n");
    return 0;            
}  