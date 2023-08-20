programa
{
	
	funcao inicio()
	{
		inteiro a1, a2, a3, a4, a5, T
		
		escreva ("Digite um número com apenas 3 digitos:")
		leia (a1)

		a2 = a1/100
		a3 = a1%100
		a4 = a3/10 
		a5 = a3%10
		
		T = a2 + a4 + a5

		escreva ("\nTotal: ", a2, "+", a4, "+", a5, ":", T)
		
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 274; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */