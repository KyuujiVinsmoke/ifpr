package ifpr.pgua.eic.escola.controllers.alunos;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaAlunosCadastrar implements Initializable 
{
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfTelefone;


    @FXML
    private LocalDate dataMatricula;

    private Escola escola;

    public JanelaAlunosCadastrar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        
    }

    @FXML
    private void cadastrarAluno(ActionEvent evento)
    {
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        LocalDate dataMatricula = LocalDate.now();

        if(!email.contains("@"))
        {
            tfEmail.getStyleClass().add("erro-textfield");
            Alert alert = new Alert(AlertType.WARNING, "Email Invalido!");
            alert.showAndWait();
            return;
        }

        else if (nome.contains(";") || cpf.contains(";") || email.contains(";") || telefone.contains(";"))
        {
            Alert alert = new Alert(AlertType.WARNING, "Nenhum Dos Campos Pode Conter [;]!");
            alert.showAndWait();
            return;
        }

        else if(!escola.cadastrarAluno(nome, cpf, email, telefone, dataMatricula))
        {
            Alert alert = new Alert(AlertType.WARNING, "Aluno Já Cadastrado!");
            alert.showAndWait();
            return;
        }
        
        Alert alert = new Alert(AlertType.INFORMATION, "Cadastro Realizado!");
        alert.showAndWait();
        limpa();
    }

    @FXML
    private void limpar(ActionEvent evento)
    {
        limpa();
    }

    private void limpa()
    {
        tfNome.clear();
        tfCpf.clear();
        tfEmail.clear();
        tfEmail.getStyleClass().remove("erro-textfield");
        tfTelefone.clear();
    }
}