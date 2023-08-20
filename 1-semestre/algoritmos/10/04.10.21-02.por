programa
{
	inclua biblioteca Util --> u
	funcao inicio()
	{
		inteiro n, vetor [12], nmenor, pmenor, nmaior, pmaior, cont
		nmenor = 100
		pmenor = 0
		nmaior = 0
		pmaior = 0


		escreva ("Vetor Aleatório:")
		
		para (n = 0; n < 12; n++) 
		
		{
		vetor [n] = u.sorteia (10, 99)

		escreva (" ",vetor[n])
		
		se (vetor [n] > nmaior) { nmaior = vetor [n] pmaior = n }
			
		se (vetor [n] < nmenor) { nmenor = vetor [n] pmenor = n }
		}

			escreva ("\n - Maior elemento: ",nmaior," / Posição: ",pmaior)
			escreva ("\n - Menor elemento: ",nmenor," / Posição: ",pmenor)


	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 529; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */