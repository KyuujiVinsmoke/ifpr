programa
{
	inclua biblioteca Util--> u
	funcao inicio()
	{
		inteiro vetor[12], a, atual=1, fatorial = 1, vet[12], b=0, aux, cont

		para(a=0;a<12;a++){
			vetor[a] = u.sorteia(1, 9)
		}
		escreva("Vetor aleatorio: ")
		para(a=0;a<12;a++){
			escreva(vetor[a]," ")
		}
		escreva("\n\n")
		para(a=0;a<12;a++){
			enquanto(atual<=vetor[a]){
				fatorial = fatorial*atual
				atual = atual + 1
				vet[b]=fatorial
			}
			fatorial = 1
			atual = 1
			b++
		}
		escreva("Fatorial dos valores do Vetor aleatorio: ")
		para(b=0;b<12;b++){
			escreva(vet[b]," ")
		}
		
		escreva("\n\n")
		para(cont=0;cont<12;cont++){
			para(b=0;b<12;b++){
				se(b==11){
					pare
					}
				se(vet[b]>vet[b+1]){
					aux = vet[b+1]
					vet[b+1] = vet[b]
					vet[b] = aux
					}
				}
		}
		escreva("Vetor ordenado do fatorial: ")
		para(b=0;b<12;b++){
			escreva(vet[b]," ")
			}
			escreva("\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 221; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {vetor, 6, 10, 5}-{atual, 6, 24, 5}-{fatorial, 6, 33, 8}-{vet, 6, 47, 3}-{b, 6, 56, 1};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */