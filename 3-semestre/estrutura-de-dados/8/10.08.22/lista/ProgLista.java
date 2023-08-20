package lista;

class Nodo 
{
    private String _value;
    private Nodo _proximo;

    public String get_value() 
    {
        return _value;
    }

    public void set_value(String _value) 
    {
        this._value = _value;
    }

    public Nodo get_proximo() 
    {
        return _proximo;
    }

    public void set_proximo(Nodo _proximo) 
    {
        this._proximo = _proximo;
    }
}

class Lista 
{
    private Nodo _inicio;

    Lista() 
    {
        _inicio = null;
    }

    void adicionar(String nome) 
    {
        Nodo novo = new Nodo();
        novo.set_value(nome);
        if (_inicio == null) 
        {
            _inicio = novo;
        } 
        
        else
        {
            Nodo aux = new Nodo();

            for (Nodo no = _inicio; no != null; no = no.get_proximo()) 
            {
                aux = no;
            }

            aux.set_proximo(novo);
        }
    }

    void listar() 
    {
        for (Nodo no = _inicio; no != null; no = no.get_proximo()) 
        {
            System.out.println(no.get_value());
        }
    }
}

public class ProgLista
{
    public static void main(String[] args) 
    {
        Lista lista = new Lista();

        lista.adicionar("Andre");
        lista.adicionar("Gusta");
        lista.adicionar("Pedro");

        lista.listar();
    }
}