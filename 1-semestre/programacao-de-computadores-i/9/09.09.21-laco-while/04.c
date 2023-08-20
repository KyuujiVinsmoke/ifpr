#include <stdio.h>
#include <math.h>

int main(){

    int n, cont, div;
    div = 0;
    cont = 0;

    printf ("Digite um número: ");
    scanf ("%i", &n);

    for (; div <= n; div++);
    {
       
        if (n % div == 0) { cont++; }
        else {}

    }

    if (cont == 2) { printf ("- [PRIMO]"); }
    
    else { printf ("- [NÃO PRIMO]"); } 


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm