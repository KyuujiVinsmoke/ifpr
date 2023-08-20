programa
{
	inclua biblioteca Util--> u
	funcao inicio()
	{
		inteiro a, i, p, v, soma=0
		inteiro soma_c=0, soma_j=0,soma_a=0,soma_i=0
		inteiro crianca=0, joven=0, adulto=0, idoso=0

		para(a=0;a<20;a++){
			 i = u.sorteia(1, 40)
			 p = u.sorteia(9, 100)
			 se(i<=10){
			 	crianca ++
			 	soma_c = soma_c + p
			 }
			 senao se(i>10 e i<=20){
			 	joven ++
			 	soma_j = soma_j + p
			 }
			 senao se(i>20 e i<=30){
			 	adulto ++
			 	soma_a = soma_a + p
			 }
			 senao{
			 	idoso ++
			 	soma_i = soma_i + p
			 }
		}
		escreva("Quantidade na faixa etaria de 01 a 10 anos: ",crianca,"   |Média de peso: ",soma_c/crianca)
		escreva("\nQuantidade na faixa etária de 11 a 20 anos: ",joven,"   |Média de peso: ",soma_j/joven)
		escreva("\nQuantidade na faixa etária de 21 a 30 anos: ",adulto,"   |Média de peso: ",soma_a/adulto)
		escreva("\nQuantidade na faixa etátia de 30 a 99 anos: ",idoso,"   |Média de peso: ",soma_i/idoso)
		escreva("\nTotal de pessoas = ", crianca + joven + adulto + idoso)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 482; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */