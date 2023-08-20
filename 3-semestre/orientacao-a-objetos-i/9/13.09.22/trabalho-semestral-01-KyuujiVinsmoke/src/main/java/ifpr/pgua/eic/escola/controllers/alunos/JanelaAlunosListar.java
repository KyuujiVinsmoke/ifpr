package ifpr.pgua.eic.escola.controllers.alunos;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.models.pessoas.Aluno;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class JanelaAlunosListar implements Initializable 
{
    @FXML
    private ListView<Aluno> ltvAlunos;

    @FXML
    private TextField tfBusca;

    @FXML
    private TextArea taDetalhes;

    private Escola escola;

    public JanelaAlunosListar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        ltvAlunos.getItems().addAll(escola.listarAlunos());
    }

    @FXML
    private void mostraDetalhesAlunos(MouseEvent evento)
    {
        taDetalhes.clear();
        
        Aluno aluno = ltvAlunos.getSelectionModel().getSelectedItem();

        if(aluno != null)
        {
            taDetalhes.appendText("Nome: "+aluno.getNome()+"\n");
            taDetalhes.appendText("CPF: "+aluno.getCpf()+"\n");
            taDetalhes.appendText("E-mail: "+aluno.getEmail()+"\n"); 
            taDetalhes.appendText("Telefone: "+aluno.getTelefone()+"\n");
            taDetalhes.appendText("Data de Matricula: "+aluno.getDataMatricula()+"\n"); 
        }
    }

    @FXML
    private void buscarAlunoCpf()
    {
        String cpf = tfBusca.getText();

        taDetalhes.clear();
        ltvAlunos.getItems().clear();
        ltvAlunos.getItems().addAll(escola.buscarAlunoCpf(cpf));
    }
}