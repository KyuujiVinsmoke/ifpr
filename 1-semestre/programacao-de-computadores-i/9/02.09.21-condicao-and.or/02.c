#include <stdio.h>
#include <math.h>

int main(){

    int id;
		
	printf ("\nDigite a idade: ");
	scanf ("%i", &id);

	if (id <= -1) { printf ("\nIdade invalida"); }

	else if (id >= 0 && id <= 11) { printf ("\nCriança"); }

	else if (id >= 12 && id <= 17) { printf ("\nAdolescente"); }

	else if (id >= 18 && id <= 59) { printf ("\nAdulto"); }
    
    else if (id <= 60 || id > 60) { printf ("\nIdoso"); }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm