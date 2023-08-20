#include <stdio.h>
#include <math.h>

int main(){

    double nota;
		
	printf ("\nDigite a nota média: ");
	scanf ("%lf", &nota);

	if (nota >= 6.0 && nota <= 10 ) { printf ("\nAprovado"); }

	else if (nota >= 4.0 && nota <= 5.9 ) { printf ("\nRecuperação"); }

    else if (nota >= 0 && nota <= 3.9 ) { printf ("\nReprovado"); }

    else { printf ("\nNota Invalida"); }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm