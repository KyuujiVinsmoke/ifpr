package trem;

public class Nodo 
{
    private String item;
    private int qtdeItem;
    private Nodo proximo;

    public String getItem() 
    {
        return item;
    }

    public void setItem(String item) 
    {
        this.item = item;
    }

    public int getQtdeItem() 
    {
        return qtdeItem;
    }

    public void setQtdeItem(int qtdeItem) 
    {
        this.qtdeItem = qtdeItem;
    }

    public Nodo getProximo() 
    {
        return proximo;
    }

    public void setProximo(Nodo proximo) 
    {
        this.proximo = proximo;
    }
}