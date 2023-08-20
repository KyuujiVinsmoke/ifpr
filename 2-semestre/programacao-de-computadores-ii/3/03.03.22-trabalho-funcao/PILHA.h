#ifndef _PILHA_
#define _PILHA_

int *pilha, p;

int InicioPilha ();
int Push (int *p);
int Pop (int *p);
int Lifo (int *p);

int InicioPilha ()
{
    pilha = malloc (TAM * sizeof (int));
    p = 0;
    
    return 0;
}

int Push (int *p)
{
    int x = *p;

    printf ("[INSERIR - PILHA]\n");
    printf ("Valor: ");
    __fpurge(stdin);
    scanf ("%i", &pilha[x]);
    
    x++;
    *p = x;

    return 0;
}

int Pop (int *p)
{
    int x = *p;

    printf ("[REMOVER - PILHA]\n");
    
    x--;
    *p = x;

    printf ("Dado (%i) Removido\n", pilha[x]);

    return 0;
}

int Lifo (int *p)
{
    int x = *p;

    printf ("[VISUALIZAR - PILHA]\n");
    printf ("PILHA:\n");

    for (x--; x >= 0; x--)
    {
        printf ("%i \n", pilha[x]);
    }

    return 0;
}

#endif