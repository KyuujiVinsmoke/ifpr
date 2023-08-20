public class No 
{
    private Aluno aluno;
    private No dir;
    private No esq;

    public Aluno getAluno() 
    {
        return aluno;
    }

    public void setAluno(Aluno aluno) 
    {
        this.aluno = aluno;
    }

    public No getDir() 
    {
        return dir;
    }

    public void setDir(No dir) 
    {
        this.dir = dir;
    }
    
    public No getEsq() 
    {
        return esq;
    }

    public void setEsq(No esq) 
    {
        this.esq = esq;
    }
}