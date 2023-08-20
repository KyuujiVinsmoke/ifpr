package ifpr.pgua.eic.escola.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ifpr.pgua.eic.escola.models.pessoas.Aluno;
import ifpr.pgua.eic.escola.models.pessoas.Professor;
import javafx.css.ParsedValue;

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
    }

    public boolean cadastrarAluno(String nome, String cpf, String email, String telefone, LocalDate dataMatricula)
    {
        if (buscarAluno(cpf) == null) 
        {
            try
            {
                File out = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/alunos.txt");
                FileWriter fwriter = new FileWriter(out,true);
                BufferedWriter bwriter = new BufferedWriter(fwriter);
    
                String conteudo = nome +";";
                conteudo += cpf +";";
                conteudo += email +";";
                conteudo += telefone +";";
                conteudo += dataMatricula;
                bwriter.write(conteudo);
                bwriter.newLine();
    
                bwriter.close();
                fwriter.close();
            }
    
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            return true;
        }

        return false;
    } 

    public String buscarAluno(String teste)
    {
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/alunos.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            File in = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/alunos.txt");

            Scanner leitor = new Scanner(in);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");

                String cpf = tokens[1];

                if (teste.equals(cpf))
                {
                    leitor.close();
                    return cpf;
                }
            }
            
            leitor.close();
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return null;
    } 

    public List<Aluno> listarAlunos()
    {
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/alunos.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            alunos.clear();
            File in = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/alunos.txt");
            Scanner leitor = new Scanner(in);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");

                String nome = tokens[0];
                String cpf = tokens[1];
                String email = tokens[2];
                String telefone = tokens[3];
                String data = tokens[4];
                LocalDate dataMatricula = LocalDate.parse(data);

                Aluno aluno = new Aluno(nome, cpf, email, telefone, dataMatricula);
                alunos.add(aluno);
            }
            
            leitor.close();
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return alunos;
    } 

    public List<Aluno> buscarAlunoCpf(String cpf)
    {
        return alunos.stream().filter((alunos)->alunos.getCpf().startsWith(cpf)).collect(Collectors.toList());
    } 

    public boolean cadastrarProfessor(String nome, String cpf, String email, String telefone, double salario)
    {
        if (buscarProfessor(cpf) == null) 
        {
            try
            {
                File out = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/professores.txt");
                FileWriter fwriter = new FileWriter(out,true);
                BufferedWriter bwriter = new BufferedWriter(fwriter);
    
                String conteudo = nome +";";
                conteudo += cpf +";";
                conteudo += email +";";
                conteudo += telefone +";";
                conteudo += salario;
                bwriter.write(conteudo);
                bwriter.newLine();
    
                bwriter.close();
                fwriter.close();
            }
    
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            return true;
        }

        return false;
    } 

    public String buscarProfessor(String teste)
    {
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/professores.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            File in = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/professores.txt");

            Scanner leitor = new Scanner(in);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");

                String cpf = tokens[1];

                if (teste.equals(cpf))
                {
                    leitor.close();
                    return cpf;
                }
            }
            
            leitor.close();
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return null;
    } 

    public List<Professor> listarProfessores()
    {
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/professores.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            professores.clear();
            File in = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/professores.txt");
            Scanner leitor = new Scanner(in);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");

                String nome = tokens[0];
                String cpf = tokens[1];
                String email = tokens[2];
                String telefone = tokens[3];
                String dinheiro = tokens[4];
                Double salario = Double.parseDouble(dinheiro);

                Professor professor = new Professor(nome, cpf, email, telefone, salario);
                professores.add(professor);
            }
            
            leitor.close();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        return professores;
    } 

    public List<Professor> buscarProfessorCpf(String cpf)
    {
        return professores.stream().filter((professores)->professores.getCpf().startsWith(cpf)).collect(Collectors.toList());
    } 

    public boolean cadastrarCurso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor)
    {
        int cod = buscarCurso(nome);
        codigo = cod;
        
        if (codigo != 0) 
        {
            try
            {
                File out = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/cursos.txt");
                FileWriter fwriter = new FileWriter(out,true);
                BufferedWriter bwriter = new BufferedWriter(fwriter);
                
                String conteudo = codigo +";";
                conteudo += nome +";";
                conteudo += descricao +";";
                conteudo += cargaHoraria +";";
                conteudo += professor.getNome() +";";
                conteudo += professor.getCpf() +";";
                conteudo += professor.getEmail() +";";
                conteudo += professor.getTelefone() +";";
                conteudo += professor.getSalario();
                bwriter.write(conteudo);
                bwriter.newLine();
    
                bwriter.close();
                fwriter.close();
            }
    
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            return true;
        }

        return false;
    } 

    public int buscarCurso(String teste)
    {
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/cursos.txt");
        int codigo = 0;
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            File in = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/cursos.txt");

            Scanner leitor = new Scanner(in);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");

                String cod = tokens[0];
                codigo = Integer.parseInt(cod);
                String nome = tokens[1];

                if (teste.equals(nome))
                {
                    leitor.close();
                    return codigo = 0;
                }
            }
            
            leitor.close();
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return codigo + 1;
    } 

    public List<Curso> listarCursos()
    {
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/cursos.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            cursos.clear();
            File in = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/cursos.txt");
            Scanner leitor = new Scanner(in);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");

                String cod = tokens[0];
                int codigo = Integer.parseInt(cod);
                String nomeC = tokens[1];
                String descricao = tokens[2];
                String carga = tokens[3];
                int cargaHoraria = Integer.parseInt(carga);
                String nomeP = tokens[4];
                String cpf = tokens[5];
                String email = tokens[6];
                String telefone = tokens[7];
                String dinheiro = tokens[8];
                Double salario = Double.parseDouble(dinheiro);
                
                Professor professor = new Professor(nomeP, cpf, email, telefone, salario);

                Curso curso = new Curso(codigo, nomeC, descricao, cargaHoraria, professor);
                cursos.add(curso);
            }
            
            leitor.close();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        return cursos;
    } 

    public List<Curso> buscarCursoNome(String nome)
    {
        return cursos.stream().filter((cursos)->cursos.getNome().startsWith(nome)).collect(Collectors.toList());
    } 

    public boolean matricularAluno(Curso curso, Aluno aluno)
    {   
        int codigoCurso = curso.getCodigo();
        String cpfAluno = aluno.getCpf();
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/matriculas.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            File out = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/matriculas.txt");
            FileWriter fwriter = new FileWriter(out,true);
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            Scanner leitor = new Scanner(out);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");
                
                String cod = tokens[0];
                int codigo = Integer.parseInt(cod);
                String cpf = tokens[2];

                if (codigo == codigoCurso && cpf.equals(cpfAluno))
                {
                    leitor.close();
                    bwriter.close();
                    fwriter.close();
                    return false;
                }
            }

            String conteudo = curso.getCodigo() +";";
            conteudo += aluno.getNome() +";";
            conteudo += aluno.getCpf() +";";
            conteudo += aluno.getEmail() +";";
            conteudo += aluno.getTelefone() +";";
            conteudo += aluno.getDataMatricula();
            bwriter.write(conteudo);
            bwriter.newLine();

            leitor.close();
            bwriter.close();
            fwriter.close();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        return true;
    }

    public boolean desmatricularAluno(Curso curso, Aluno aluno)
    {
        int codigoCurso = curso.getCodigo();
        String cpfAluno = aluno.getCpf();
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/matriculas.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            File in = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/matriculas.txt");
            Scanner leitor = new Scanner(in);

            File back = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/backup.txt");
            FileWriter fwriter = new FileWriter(back,true);
            BufferedWriter bwriter = new BufferedWriter(fwriter);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");
                
                String codigo = tokens[0];
                int cod = Integer.parseInt(codigo);
                String nome = tokens[1];
                String cpf = tokens[2];
                String email = tokens[3];
                String telefone = tokens[4];
                String dataMatricula = tokens[5];
                
                if (cod == codigoCurso && cpf.equals(cpfAluno))
                {
                   
                }

                else 
                {
                    String conteudo = codigo +";";
                    conteudo += nome +";";
                    conteudo += cpf +";";
                    conteudo += email +";";
                    conteudo += telefone +";";
                    conteudo += dataMatricula;
                    bwriter.write(conteudo);
                    bwriter.newLine();
                }
            }

            leitor.close();
            bwriter.close();
            fwriter.close();
            file.delete();
            back.renameTo(file);
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        return true;
    }

    public ArrayList<Aluno> listarAlunosMatriculados(Curso curso)
    {
        File file = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/matriculas.txt");
        
        if(!file.exists())
        {
            File pasta = new File("src/main/java/ifpr/pgua/eic/escola/arquivos");

            if(!pasta.exists())
            {
                pasta.mkdir();
            }
        }

        try
        {
            alunos.clear();
            int codigoCurso = curso.getCodigo();

            File out = new File("src/main/java/ifpr/pgua/eic/escola/arquivos/matriculas.txt");
            Scanner leitor = new Scanner(out);

            while(leitor.hasNextLine())
            {
                String linha = leitor.nextLine();

                String[] tokens = linha.split(";");
                
                String cod = tokens[0];
                int codigo = Integer.parseInt(cod);

                if (codigoCurso == codigo)
                {
                    String nome = tokens[1];
                    String cpf = tokens[2];
                    String email = tokens[3];
                    String telefone = tokens[4];
                    String data = tokens[5];
                    LocalDate dataMatricula = LocalDate.parse(data);

                    Aluno aluno = new Aluno(nome, cpf, email, telefone, dataMatricula);
                    alunos.add(aluno);
                }
            }

            leitor.close();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        return alunos;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getTelefone() 
    {
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

        str += nome;

        return str;
    }
}