#include <stdio.h>

int main(){

    float c, f;
    
    printf ("\nDigite a temperatura em Celcius (ºC): ");
    scanf ("%f", &c);

    f = ((9 * c) + 160) / 5;

    printf ("\nTemperatura em Fahrenheit = %.1f", f);


    printf ("\n\n");
    return 0;

}