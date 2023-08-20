package com.example;
   
public class ParseSoma 
{
    public int parseSoma(String expressao) 
    { 
        if(expressao.isEmpty())
        {
            return 0;
        }
        
        else
        {
            int soma=0;
            String[] numeros = expressao.split(",");

            for(String s:numeros)
            {
                soma += Integer.valueOf(s);
            }

            return soma;
        }
    }
} 