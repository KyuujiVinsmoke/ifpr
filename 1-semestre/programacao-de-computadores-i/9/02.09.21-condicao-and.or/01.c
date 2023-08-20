#include <stdio.h>
#include <math.h>

int main(){

	float n1, n2, n3;
		
	printf ("\nDigite os três tempos: ");
	scanf ("%f %f %f", &n1, &n2, &n3);
		
	
	if (n1 < n2 && n1 < n3 || n1 == n2 && n1 == n3 || n1 == n2 && n1 != n3 || n1 == n3 && n1 != n2) { printf ("\n- 1º lugar > %.2f", n1); }

	else if (n2 < n1 && n2 < n3 || n2 == n1 && n2 == n3 || n2 == n1 && n2 != n3 || n2 == n3 && n2 != n1) { printf ("\n- 1º lugar > %.2f", n2); }
	
	else { printf ("\n- 1º lugar > %.2f", n3); }

		
		if (n1 < n2 && n1 > n3 || n1 > n2 && n1 < n3 || n1 == n2 && n1 == n3 || n1 == n2 && n1 != n3 || n1 == n3 && n1 != n2) { printf ("\n- 2º lugar > %.2f", n1); }

		else if (n2 < n1 && n2 > n3 || n2 > n1 && n2 < n3 || n2 == n1 && n2 == n3 || n2 == n1 && n2 != n3 || n2 == n3 && n2 != n1) { printf ("\n- 2º lugar > %.2f", n2); }

		else { printf ("\n- 2º lugar > %.2f", n3); }
		
			
			if (n1 > n2 && n1 > n3 || n1 == n2 && n1 == n3) { printf ("\n- 3º lugar > %.2f", n1); }

			else if (n2 > n1 && n2 > n3 || n2 == n1 && n2 == n3) { printf ("\n- 3º lugar > %.2f", n2); }

			else { printf ("\n- 3º lugar > %.2f", n3); }

    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm