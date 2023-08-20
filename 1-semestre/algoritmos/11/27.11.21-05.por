programa
{
	inclua biblioteca Util--> u
	funcao inicio()
	{

	inteiro vetor[12], a, aux, cont

	para(a=0;a<12;a++){
		vetor[a] = u.sorteia(1, 20)
	}
	escreva("Vetor aleatorio: ")
	para(a=0;a<12;a++){
		escreva(vetor[a]," ")
	}
	escreva("\n")
	para(cont=0;cont<12;cont++){
		para(a=0;a<12;a++){
			se(a==11){
				pare
			}
			se(vetor[a]<vetor[a+1]){
				aux = vetor[a+1]
				vetor[a+1] = vetor[a]
				vetor[a] = aux
			}

		}
	}
	escreva("Vetor ordenado: ")
	para(a=0;a<12;a++){
		escreva(vetor[a]," ")
	}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 182; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 7, 10, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */