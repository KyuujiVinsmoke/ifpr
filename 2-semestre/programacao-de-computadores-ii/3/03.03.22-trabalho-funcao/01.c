#define TAM 9

#include <stdlib.h>
#include <stdio_ext.h>
#include <stdio.h>
#include "pilha.h"
#include "fila.h"

void Opcao(int *op);

int main ()
{
    system ("clear");
    
    int op;
    InicioPilha ();
    InicioFila ();

    for (op = 9; op > 0;)
    {
        Opcao(&op);

        if (op == 1) { Push (&p); }
        else if (op == 2) { Enqueue(&f); }
        else if (op == 3) { Pop(&p); }
        else if (op == 4) { Dequeue(&f); }
        else if (op == 5) { Lifo(&p); }
        else if (op == 6) { Fifo(&f); }
        else if (op == 0) { break; }
    }

    printf ("\n[THE END]");

    printf ("\n\n");
    return 0;
}

void Opcao (int *op)
{
    printf ("---------------------------------------\n");
    printf ("(1) - Inserir dado na pilha\n");
    printf ("(2) - Inserir dado na fila\n");
    printf ("(3) - Remover dado da pilha\n");
    printf ("(4) - Remover dado da fila\n");
    printf ("(5) - Visualizar os dados da pilha\n");
    printf ("(6) - Visualizar os dados da fila\n");
    printf ("(0) - Sair\n");
    printf ("---------------------------------------\n");
    printf ("> ");
    scanf ("%i", op);
    printf ("---------------------------------------\n");
}