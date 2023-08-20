programa
{
	inclua biblioteca Util --> u
	funcao inicio()
	{
		inteiro matriz[5][5]
		inteiro l, c,  t, cont=0

	escreva("Matriz aleatória: \n\n")
		
		para(l=0;l<5;l++){
			para(c=0;c<5;c++){
				matriz[l][c] = u.sorteia(10, 20)
			}
		}
		para(l=0;l<5;l++){
			para(c=0;c<5;c++){
				escreva(matriz[l][c]," ")
			}
			escreva("\n")
		}
		para(l=0;l<5;l++){
			para(c=0;c<5;c++){
				se(l==c){
					t  = matriz[l][c]%2
					se(t==0){
						cont = cont + matriz[l][c]
					}
				}
			}
		}
		escreva("\nSoma dos  numero  pares da diagonal principal: ",cont,"\n")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 147; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */