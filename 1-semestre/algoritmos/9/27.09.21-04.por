programa
{
	funcao inicio()
	{
		inteiro n, cont, save

		escreva ("\tDigite 1 valor inteiro: ")
		leia (n)

		escreva ("\n")

		cont = n
		save = n
		
		faca {

			escreva ("* ")
			n = n - 1

			se (n == 0) { cont = cont - 1 escreva ("\n") }

			se (n == 0) { n = save }

		} enquanto (cont > 0) 
			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 137; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */