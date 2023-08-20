programa
{
	inclua biblioteca Util -->  u
	funcao inicio()
	{
		inteiro matriz_a[5][3], matriz_b[5][3], matriz_c[5][3]
		inteiro l, c

		para(l=0;l<5;l++){
			para(c=0;c<3;c++){
				matriz_a[l][c] = u.sorteia(10, 20)
				matriz_b[l][c] = u.sorteia(10, 20)
			}
		}
		para(l=0;l<5;l++){
			para(c=0;c<3;c++){
				matriz_c[l][c]= matriz_a[l][c] + matriz_b[l][c]
			}
		}

		para(l=0;l<5;l++){
			para(c=0;c<3;c++){
				escreva(matriz_a[l][c]," ")
			}
			se(l!=2){
				escreva("\t")
			}
			se(l==2){
				escreva("   +   ")
			}
			para(c=0;c<3;c++){
				escreva(matriz_b[l][c]," ")
			}
			se(l==2){
				escreva("   =   ")
			}
			se(l!=2){
				escreva("\t")
			}	
			para(c=0;c<3;c++){
				escreva(matriz_c[l][c]," ")
			}
			
			escreva("\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 752; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */