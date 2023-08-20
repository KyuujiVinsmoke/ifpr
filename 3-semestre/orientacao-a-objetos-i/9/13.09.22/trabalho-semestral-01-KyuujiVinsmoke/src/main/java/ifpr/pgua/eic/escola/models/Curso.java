package ifpr.pgua.eic.escola.models;

import java.util.ArrayList;

import ifpr.pgua.eic.escola.models.pessoas.Aluno;
import ifpr.pgua.eic.escola.models.pessoas.Professor;

public class Curso 
{
    private int codigo;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private Professor professor;
    private ArrayList<Aluno> alunos;
    
    public Curso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor) 
    {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }
    
    public int getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    public int getCargaHoraria() 
    {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) 
    {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() 
    {
        return professor;
    }

    public void setProfessor(Professor professor) 
    {
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() 
    {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) 
    {
        this.alunos = alunos;
    }

    public String toString ()
    {
        String str = "";
        
        str += "Codigo: " +codigo; 
        str += "\nNome: " +nome;
        
        return str;
    }
}