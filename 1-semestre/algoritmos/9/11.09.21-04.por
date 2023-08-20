programa
{
	funcao inicio()
	{

	inteiro n, resu1, res1, resu2, resu3
		
		escreva ("Digite três números inteiros aonde cada número representa o tamanho em metros do triângulo:")
		leia (n)

		resu1 = n / 100
		res1 = n % 100
		resu2 = res1 / 10
		resu3 = res1 % 10


		se (n < 100 ou n > 999)
		escreva ("Entrada inválida")
		
			senao se(resu1 == resu2 e resu1 == resu3)
			escreva ("O triângulo é equilátero")
			
				senao se (resu1 == resu2 ou resu1 == resu3 ou resu2 == resu3)
				escreva ("O triângulo é isóceles")

				senao
				escreva ("O triângulo é escaleno")

	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 572; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */