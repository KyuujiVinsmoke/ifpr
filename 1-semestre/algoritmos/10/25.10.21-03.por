programa
{
	inclua biblioteca Util --> u
	funcao inicio() 
	{
		inteiro dados[5][5], c, l, linha, valor

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

		escreva ("\n\n - Escolha uma linha: ")
		leia (linha)
		escreva (" - Escolha um valor: ")
		leia (valor)

		para (c = 0; c < 5; c++)
		{
		   para (l = 0; l < 5; l++)
		   {
		    se (c == linha) { }

		    senao { dados[c][l] = valor }
		   }
		}

		escreva ("\nMatriz Modificada: ")
		para (c = 0; c < 5; c++) 
		{
		  escreva ("\n")	 
		  para (l = 0; l < 5; l++)	
		    { 
			 escreva(dados[c][l])
			 escreva(" ")	 
		    }	 
		}	
		  
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 799; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */