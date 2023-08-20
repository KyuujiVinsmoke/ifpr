#include <stdio.h>

int main()
{
    int n, resu1, res1, resu2, resu3, total;
		
	printf ("\nDigite um número com apenas 3 digitos: ");
	scanf ("%i", &n);

	resu1 = n / 100;
	res1 = n % 100;
	resu2 = res1 / 10;
	resu3 = res1 % 10;
		
	total = resu1 + resu2 + resu3;

	printf ("\nTotal: %i + %i + %i: %i", resu1, resu2, resu3, total);

    printf ("\n\n");
    return 0;
}