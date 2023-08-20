package ifpr.pgua.eic.escola.controllers.matriculas;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Curso;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.models.pessoas.Aluno;
import ifpr.pgua.eic.escola.models.pessoas.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class JanelaMatriculasListar implements Initializable 
{
    @FXML
    private TextField tfBuscaCurso;

    @FXML
    private ListView<Curso> ltvCursos;

    @FXML
    private TextArea taDetalhesCursos;

    @FXML
    private TextField tfBuscaAluno;

    @FXML
    private ListView<Aluno> ltvAlunos;

    @FXML
    private TextArea taDetalhesAlunos;

    private Escola escola;

    public JanelaMatriculasListar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        ltvCursos.getItems().addAll(escola.listarCursos());
    }

    @FXML
    private void buscarCurso()
    {
        String nome = tfBuscaCurso.getText();

        ltvCursos.getItems().clear();
        ltvCursos.getItems().addAll(escola.buscarCursoNome(nome));
    }

    @FXML
    private void mostraDetalhesCursos(MouseEvent evento)
    {
       limpa();

        Curso curso = ltvCursos.getSelectionModel().getSelectedItem();
        ltvAlunos.getItems().addAll(escola.listarAlunosMatriculados(curso));

        if(curso != null)
        {
            taDetalhesCursos.appendText("Nome: "+curso.getNome()+"\n");
            taDetalhesCursos.appendText("Codigo: "+curso.getCodigo()+"\n");
            taDetalhesCursos.appendText("Descrição: "+curso.getDescricao()+"\n"); 
            taDetalhesCursos.appendText("Carga Horaria: "+curso.getCargaHoraria()+"\n"); 
            taDetalhesCursos.appendText("Professor: "+curso.getProfessor()+"\n");
        }
    }

    @FXML
    private void buscarAluno()
    {
        String cpf = tfBuscaAluno.getText();

        ltvAlunos.getItems().clear();
        ltvAlunos.getItems().addAll(escola.buscarAlunoCpf(cpf));
    }

    @FXML
    private void mostraDetalhesAlunos(MouseEvent evento)
    {
        taDetalhesAlunos.clear();
        
        Aluno aluno = ltvAlunos.getSelectionModel().getSelectedItem();

        if(aluno != null)
        {
            taDetalhesAlunos.appendText("Nome: "+aluno.getNome()+"\n");
            taDetalhesAlunos.appendText("CPF: "+aluno.getCpf()+"\n");
            taDetalhesAlunos.appendText("E-mail: "+aluno.getEmail()+"\n"); 
            taDetalhesAlunos.appendText("Telefone: "+aluno.getTelefone()+"\n");
            taDetalhesAlunos.appendText("Data de Matricula: "+aluno.getDataMatricula()+"\n"); 
        }
    }

    private void limpa()
    {
        taDetalhesCursos.clear();
        tfBuscaCurso.clear();
        taDetalhesAlunos.clear();
        ltvAlunos.getItems().clear();
        tfBuscaAluno.clear();
    }
}