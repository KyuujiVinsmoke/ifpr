programa
{
	funcao inicio()
	{
	
		inteiro n1, n2, n3, resul, cont

    escreva ("\n\tDigite 2 valores inteiros: ")
    leia (n1)
    limpa ()
    escreva ("\n\tDigite 2 valores inteiros: ", n1," ")
    leia (n2)

    se (n1 < n2) {

        se (n1 % 2 == 1) { n1 = n1 + 1 escreva ("\n\tSomando valores pares: ", n1) }

        senao se (n1 % 2 == 0) { n1 = n1 + 2 escreva ("\n\tSomando valores pares: ", n1) }

        n3 = n1
        n1 = n1 + 2
                    
        faca {

            escreva (" + ", n1)

            resul = n1 + n3
            n3 = resul
            n1 = n1 + 2
           
        } enquanto (n1 < n2)

        escreva (" = ", resul)
    
    }

    senao se (n1 >= n2) { escreva ("\n\tValores incorretos") }















		
			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 233; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */