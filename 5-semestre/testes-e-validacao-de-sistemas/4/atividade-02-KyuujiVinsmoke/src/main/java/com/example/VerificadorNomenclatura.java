package com.example;

public class VerificadorNomenclatura {
    
    public int verificar(String palavra) {
       
        if(palavra.length() > 6) {
            return 0;
        }

        if(!Character.isLetter(palavra.charAt(0))) {
            return 0;
        }

        for(int i = 1; i < palavra.length(); i++) {
            
            char teste = palavra.charAt(i);
            
            if (!Character.isLetterOrDigit(teste)) {
                return 0;
            }
        }

        return 1;
    }
}