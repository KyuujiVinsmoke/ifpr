package trem;

public class App
{
    public static void main(String[] args) 
    {
        Trem trem = new Trem();

        trem.adicionarVagao ("André", 1999);
        trem.adicionarVagao ("Gustavo", 2001);
        trem.adicionarVagao ("Pedro", 2004);

        System.out.println ("\n");
        System.out.println (trem.mostrarTrem());
        System.out.println (trem.quantidadeVagoes() + " Vagoes\n");

        trem.removerVagao();

        System.out.println (trem.mostrarTrem());
        System.out.println (trem.quantidadeVagoes() + " Vagoes\n");

        trem.adicionarVagao ("Choriscreuda", 2022);

        System.out.println (trem.mostrarTrem());
        System.out.println (trem.quantidadeVagoes() + " Vagoes\n");

        System.out.println ("\n");
    }
}