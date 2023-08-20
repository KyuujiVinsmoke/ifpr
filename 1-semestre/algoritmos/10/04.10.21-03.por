programa
{
	inclua biblioteca Util --> u
	funcao inicio()
	{
		inteiro n, vetor [4], vmedio
		vmedio = 0
		
	
		escreva ("Vetor Aleatório:")
		
		para (n = 0; n < 4; n++) 
		
		{
		vetor [n] = u.sorteia (10, 99)

		escreva (" ",vetor[n])

		vmedio = vetor [n] + vmedio
		}
		
		vmedio = vmedio / 4
		escreva ("\n - Valor médio: ",vmedio)

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 109; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */