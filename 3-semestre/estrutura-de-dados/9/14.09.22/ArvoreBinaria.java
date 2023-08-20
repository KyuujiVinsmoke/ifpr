public class ArvoreBinaria 
{
    private No inicio;

    public void inserir(Aluno aluno) 
    {
        No novo = new No();
        novo.setAluno(aluno);
        novo.setEsq(null);
        novo.setDir(null);

        if(inicio == null) 
        {
            inicio = novo;
        } 
        
        else 
        {
            No atual = inicio;
            No anterior;

            while(true) 
            {
                anterior = atual;
                if(tranformaMatricula(aluno.getMatricula()) <= tranformaMatricula(atual.getAluno().getMatricula())) 
                {
                    atual = atual.getEsq();
                    if(atual == null) 
                    {
                        anterior.setEsq(novo);
                        return;
                    }
                } 
                
                else 
                {
                    atual = atual.getDir();

                    if(atual == null) 
                    {
                        anterior.setDir(novo);
                        return;
                    }
                }
            }
        }
    }

    public boolean excluir(String matricula) 
    {
        if(inicio == null) 
        {
            return false;
        }

        No atual = inicio;
        No pai = inicio;
        boolean filho_esq = true;

        while(!atual.getAluno().getMatricula().equals(matricula)) 
        {
            pai = atual;
            if(tranformaMatricula(matricula) < tranformaMatricula(atual.getAluno().getMatricula())) 
            {
                atual = atual.getEsq();
                filho_esq = true;
            } 
            
            else 
            {
                atual = atual.getDir();
                filho_esq = false;
            }

            if(atual == null) 
            {
                return false;
            }
        }

        if(atual.getEsq() == null && atual.getDir() == null) 
        {
            if(atual == inicio) 
            {
                inicio = null;
            } 
            
            else if(filho_esq) 
            {
                pai.setEsq(null);
            } 
            
            else 
            {
                pai.setDir(atual.getEsq());
            }
        } 
        
        else if(atual.getDir() == null) 
        {
            if(atual == inicio) 
            {
                inicio = atual.getEsq();
            } 
            
            else if (filho_esq) 
            {
                pai.setEsq(atual.getEsq());
            } 
            
            else 
            {
                pai.setDir(atual.getEsq());
            }
        } 
        
        else if(atual.getEsq() == null) 
        {
            if(atual == inicio) 
            {
                inicio = atual.getDir();
            } 
            
            else if (filho_esq) 
            {
                pai.setEsq(atual.getDir());
            }
            
            else 
            {
                pai.setDir(atual.getDir());
            }
        } 
        
        else 
        {
            No prox = noProx(atual);
            
            if(atual == inicio) 
            {
                inicio = prox;
            } 
            
            else if (filho_esq) 
            {
                pai.setEsq(prox);
            } 
            
            else 
            {
                pai.setDir(prox);
            }

            prox.setEsq(atual.getEsq());
        }

        return true;
    }

    public No noProx(No delete) 
    {
        No paiProx = delete;
        No prox = delete;
        No atual = delete.getDir();

        while(atual != null) 
        {
            paiProx = prox;
            prox = atual;
            atual = atual.getEsq();
        }

        if(prox != delete.getDir()) 
        {
            paiProx.setEsq(prox.getDir());
            prox.setDir(delete.getDir());
        }

        return prox;
    }

    public Aluno buscar(String matricula) 
    {
        if(inicio == null)
        {
            return null;
        }

        No atual = inicio;

        while(!atual.getAluno().getMatricula().equals(matricula)) 
        {
            if(tranformaMatricula(matricula) < tranformaMatricula(atual.getAluno().getMatricula())) 
            {
                atual = atual.getEsq();
            } 
            
            else 
            {
                atual = atual.getDir();
            }

            if(atual == null) 
            {
                return null;
            }
        }

        return atual.getAluno();
    }

    public void listar() 
    {
        ordenado(inicio);
    }
    
    public void ordenado(No atual) 
    {
        if (atual != null) 
        {
            ordenado(atual.getEsq());
            System.out.print(atual.getAluno().toString());
            ordenado(atual.getDir());
        }
    }

    public int tranformaMatricula(String matricula) 
    {
        int matriculaInt = Integer.parseInt(matricula);
        return matriculaInt;
    }
}