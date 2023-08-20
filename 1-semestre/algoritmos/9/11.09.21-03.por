programa
{
	funcao inicio()
	{
		inteiro id, inv, cri, ado, adu, ido
		
		escreva ("Digite a idade:")
		leia (id)

		
		se (id <= 0)
		escreva ("Idade invalida")

			senao se (id >= 1 e id <= 11)
			escreva ("Criança")

				senao se (id >= 12 e id <= 17)
				escreva ("Adolescente")

					senao se (id >= 18 e id <= 59)
					escreva ("Adulto")

						senao se (id <= 60 ou id > 60)
						escreva ("Idoso")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 99; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */