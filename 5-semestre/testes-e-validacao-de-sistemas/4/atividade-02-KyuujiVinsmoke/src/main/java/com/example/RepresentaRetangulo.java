package com.example;

public class RepresentaRetangulo {

    public int calcularArea(String entrada1, String entrada2) {
        
        if(entrada1.isEmpty() || entrada2.isEmpty()) {
            
            return 0;
        } else {

            int lado1 = Integer.valueOf(entrada1);
            int lado2 = Integer.valueOf(entrada2);
            int area;
            
            if(lado1 >= 0 || lado2 >= 0) {
               
                return 0;
            } else {

                return area = lado1 * lado2;
            }
        }
    }

    public int calcularPerimetro(String entrada1, String entrada2) {

        if(entrada1.isEmpty() || entrada2.isEmpty()) {
           
            return 0;
        } else {

            int lado1 = Integer.valueOf(entrada1);
            int lado2 = Integer.valueOf(entrada2);
            int perimetro;
            
            if(lado1 >= 0 || lado2 >= 0) {
                
                return 0;
            } else {

                return perimetro = (lado1 + lado2) + (lado1 + lado2);
            }
        }
    }
}