#include <stdio.h>
#include <math.h>

int main()
{
    int n, resu1, res1, resu2, resu3;
		
    printf ("\nDigite três números inteiros aonde cada número representa o tamanho em metros do triângulo: ");
    scanf ("%i", &n);

    resu1 = n / 100;
    res1 = n % 100;
    resu2 = res1 / 10;
    resu3 = res1 % 10;


    if (n < 100 || n > 999) { printf ("\nEntrada inválida"); }
		
    else if (resu1 == resu2 && resu1 == resu3) { printf ("\nO triângulo é equilátero"); }
			
    else if (resu1 == resu2 || resu1 == resu3 || resu2 == resu3) { printf ("\nO triângulo é isóceles"); }

    else { printf ("\nO triângulo é escaleno"); }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm