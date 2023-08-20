programa
{
	funcao inicio()
	{
		inteiro n
				
		escreva("Digite um Número: ")
		leia(n)

		escreva("O Fatorial de (", n, ") é: ", fatorial(n), "\n") 
	}
	
	funcao inteiro fatorial(inteiro n)
	{
		se (n == 1 ou n == 0)
		{
			retorne 1
		}
		
		retorne n * fatorial (n - 1)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 280; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */