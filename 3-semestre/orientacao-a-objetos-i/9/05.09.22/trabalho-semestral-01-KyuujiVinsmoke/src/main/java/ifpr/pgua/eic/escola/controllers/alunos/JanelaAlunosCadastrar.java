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
    private TextField tfCpf;

    @FXML
    private TextField tfNome;

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
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
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

        String msg = "Cadastro realizado!";
        if(!escola.cadastrarAluno(cpf, nome, email, telefone, dataMatricula))
        {
            msg = "Cadastro não realizado!";
        }
        
        else
        {
            limpa();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();
    }

    @FXML
    private void limpar(ActionEvent evento)
    {
        limpa();
    }

    private void limpa()
    {
        tfCpf.clear();
        tfNome.clear();
        tfEmail.clear();
        tfTelefone.clear();
    }
}