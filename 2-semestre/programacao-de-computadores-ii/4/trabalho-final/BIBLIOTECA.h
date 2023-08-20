#include <stdio.h>
#include <stdio_ext.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <termios.h>
#include <unistd.h>

#define preto		printf ("\33[30m");
#define vermelho    printf ("\33[31m");
#define verde		printf ("\33[32m");
#define amarelo	   	printf ("\33[33m");
#define azulescuro	printf ("\33[34m");
#define roxo		printf ("\33[35m");
#define azulclaro	printf ("\33[36m");
#define branco      printf ("\33[37m");

#define TAM         30
#define LAR 		62
#define ALT 		18
#define CAMINHO 	0
#define PAREDE 		1
#define INICIO 		2
#define ANIMAL		3

// ESTRUTURA BINÁRIO
typedef struct
{
    int save[ALT][LAR];
}                       Saves;

int getch(void) {

    struct termios oldattr, newattr;
    int ch;

    tcgetattr( STDIN_FILENO, &oldattr);
    newattr = oldattr;
    newattr.c_lflag &= ~( ICANON | ECHO);
    tcsetattr( STDIN_FILENO, TCSANOW, &newattr);
    ch = getchar();
    tcsetattr( STDIN_FILENO, TCSANOW, &oldattr);

    return ch;
}