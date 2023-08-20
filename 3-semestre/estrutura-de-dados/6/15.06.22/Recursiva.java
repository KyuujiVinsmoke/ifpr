import java.util.Scanner;

public class Recursiva
{
    public static void NumerosInvertidos (int numeros)
    {
        int ultimoNumero;

        ultimoNumero = numeros % 10;
        numeros = numeros / 10;

        System.out.print ("" +ultimoNumero);
        
        if (numeros != 0) { NumerosInvertidos (numeros); }
    }

    public static void main(String[] args)
    {
        System.out.println ("");

        Scanner scan = new Scanner (System.in);
        int numeros;
       
        System.out.print ("Digite um numero inteiro: ");
        numeros = scan.nextInt();

        System.out.print ("Numeros invertidos: ");
        NumerosInvertidos (numeros);

        System.out.println ("\n");
    }
}