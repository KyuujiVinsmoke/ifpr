package trem;

public class Trem 
{
    private Nodo locomotiva;

    Trem()
    {
        locomotiva = new Nodo();
    }

    void adicionarVagao(String item, int qtdeItem) 
    {
        Nodo novoVagao = new Nodo();
        novoVagao.setItem(item);
        novoVagao.setQtdeItem(qtdeItem);

        if (locomotiva.getProximo() == null) 
        {
            locomotiva.setProximo(novoVagao);
        } 
        
        else 
        {
            Nodo aux = new Nodo();

            for (Nodo vagao = locomotiva; vagao != null; vagao = vagao.getProximo()) 
            {
                aux = vagao;
            }

            aux.setProximo(novoVagao);
        }
    }

    void removerVagao() 
    {
        for (Nodo vagao = locomotiva; vagao != null; vagao = vagao.getProximo()) 
        {
            if (vagao.getProximo().getProximo() == null) 
            {
                vagao.setProximo(null);
                break;
            }
        }
    }

    String mostrarTrem() 
    {
        String str = "";

        for (Nodo trem = locomotiva; trem != null; trem = trem.getProximo()) 
        {
            if (trem == locomotiva) 
            {
                str += "🚂";
            } 
            
            else {
                str += "-[" + trem.getItem() + "|" + trem.getQtdeItem() + "]";
            }
        }

        return str;
    }

    int quantidadeVagoes() 
    {
        int i = 0;
        
        for (Nodo trem = locomotiva.getProximo(); trem != null; trem = trem.getProximo(), i++) {}
        
        return i;
    }
}