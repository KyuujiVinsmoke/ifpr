#include <stdio.h>

int main(){

	float CM, CD, DT;
		
	printf ("\nConsumo Médio:");
	scanf ("%f", &CM);

	printf ("Combustivel Disponivel:");
	scanf ("%f", &CD);

	DT = CM * CD;

	printf ("\nDistancia total: %.1f KM", DT);


    printf ("\n\n");
    return 0;

}