programa
{
	inclua biblioteca Util--> u	
	funcao inicio()
	{
	inteiro a, i, n, soma_i=0, p=0, k=0, media, j=0

	para(a=0;a<20;a++){
		i = u.sorteia(14, 99)
		n = u.sorteia(1, 3)
		se(n==3){
			j++
			soma_i = soma_i + i
		}
		senao se(n==1){
			p++
		}
		senao{
			k++
		}
	}
	media = (100*k)/20

	escreva("A média das idades das pessoas que responderam excelente: ",soma_i/j)
	escreva("\nA quantidade de pessoas de responderam regular: ", p)
	escreva("\nA percentagem de pessoas que responderam bom entre todos os expectadores analisados ", media,"%")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 564; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */