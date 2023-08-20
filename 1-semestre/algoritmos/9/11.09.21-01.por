programa
{
	funcao inicio()
	{
		inteiro n1, n2, n3
		
		escreva ("Digite o 1° número inteiro:")
		leia (n1)
		
		escreva ("Digite o 2° número inteiro:")
		leia (n2)
		
		escreva ("Digite o 3° número inteiro:")
		leia (n3)

		
		se (n1 < n2 e n1 < n3)
		escreva ("\nNúmero Menor:" , n1)

			senao se (n2 < n1 e n2 < n3)
			escreva ("\nNúmero Menor:" , n2)

				senao se (n3 < n1 e n3 < n2)
				escreva ("\nNúmero Menor:" , n3)


		se (n1 > n2 e n1 > n3)
			escreva ("\nNúmero Maior:" , n1)

			senao se (n2 > n1 e n2 > n3)
			escreva ("\nNúmero Maior:" , n2)

				senao se (n3 > n1 e n3 > n2)
				escreva ("\nNúmero Maior:" , n3)

			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 385; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */