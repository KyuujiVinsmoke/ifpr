programa
{
	funcao inicio()
	{
		inteiro n, nmenor, nmaior

		nmenor = 999999999
		nmaior = 0

		faca {
		
		escreva ("Digite um número inteiro: ")
		leia (n)

			se (n < 0) 
			{ pare }

				se (n < nmenor)
				{ nmenor = n }
		
					se (n > nmaior)
					{ nmaior = n }
				
			}

		enquanto (n > -1)

		se (nmenor == 999999999 e nmaior == 0)
		escreva ("\nTente Novamente")
			
		senao
			{ escreva ("\nO menor número é: ", nmenor)
			  escreva ("\nO maior número é: ", nmaior) }
			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 143; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */