programa
{
	inclua biblioteca Util --> u
	funcao inicio() 
	{
		inteiro dados[5][5], c,l, aux
		aux = 0

		para (c = 0; c < 5; c++) 
		{
		  para (l = 0; l < 5; l++)	
		    { 
			 dados[c][l]=u.sorteia(10, 50)			
		    }	 
		}		

          escreva ("\nMatriz Aleatória: ")   
		
		para (c = 0; c < 5; c++) 
		{
		  escreva ("\n")	 
		  para (l = 0; l < 5; l++)	
		    { 
			 escreva(dados[c][l])
			 escreva(" ")	 
		    }	 
		}	  
		
		l = 0
		
		para (c = 0; c < 5; c++)
		{
		    se (dados[c][l] > aux) { aux = dados[c][l] }
		    l++
		}
		
 		escreva ("\nMaior Valor: ", aux)
		  
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 431; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */