package ifpr.pgua.eic.escola.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ifpr.pgua.eic.escola.models.pessoas.Aluno;
import ifpr.pgua.eic.escola.models.pessoas.Professor;

public class Escola 
{
    private String nome;
    private String telefone;
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Curso> cursos;
   
    public Escola(String nome, String telefone) 
    {
        this.nome = nome;
        this.telefone = telefone;
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
    } //

    public boolean cadastrarAluno(String cpf, String nome, String email, String telefone, LocalDate dataMatricula)
    {
        this.alunos.add (new Aluno(cpf, nome, email, telefone, dataMatricula));
        return true;
    } //

    public boolean cadastrarProfessor(String cpf, String nome, String email, String telefone, double salario)
    {
        if (buscarProfessorCpf(cpf) == null) 
        {
            Professor professor = new Professor(cpf, nome, email, telefone, salario);

            professores.add(professor);

            return true;
        }

        return false;
    } 

    public boolean cadastrarCurso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor)
    {
        if (buscarCurso(nome) == null)
        {
            Curso curso = new Curso(codigo, nome, descricao, cargaHoraria, professor);

            cursos.add(curso);

            return true;
        }

        return false;
    } 

    public boolean matricularAluno(Aluno aluno, Curso curso)
    {   
        return false;
    }

    public boolean desmatricularAluno(Aluno aluno, Curso curso)
    {
        return false;
    }

    public ArrayList<Aluno> listarAlunos()
    { 
        return alunos;
    }

    public ArrayList<Professor> listarProfessores()
    {
        return professores;
    } 

    public ArrayList<Curso> listarCursos()
    {
        return cursos;
    } 

    public ArrayList<Aluno> listarAlunosMatriculados(Curso curso)
    {
        return alunos;
    }

    public List<Aluno> buscarAlunoCpf(String cpf)
    {
        return alunos.stream().filter((alunos)->alunos.getCpf().startsWith(cpf)).collect(Collectors.toList());
    } 

    public List<Professor> buscarProfessorCpf(String cpf)
    {
        return professores.stream().filter((professores)->professores.getCpf().startsWith(cpf)).collect(Collectors.toList());
    } 

    public List<Curso> buscarCurso(String nome)
    {
        return cursos.stream().filter((cursos)->cursos.getNome().startsWith(nome)).collect(Collectors.toList());
    } 

    ////////////////////////////////////////////
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }

    public ArrayList<Professor> getProfessores()
    {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores)
    {
        this.professores = professores;
    }

    public ArrayList<Aluno> getAlunos() 
    {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) 
    {
        this.alunos = alunos;
    }

    public ArrayList<Curso> getCursos() 
    {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) 
    {
        this.cursos = cursos;
    }

    public String toString ()
    {
        String str = "";

        str +="--------------------------------------------------\n";
        str += "Nome: " +nome+ "\n";
        str += "Telefone: " +telefone+ "\n";
        str +="--------------------------------------------------\n";

        return str;
    }
}