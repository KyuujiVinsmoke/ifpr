package ifpr.pgua.eic.escola.controllers.professores;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaProfessoresCadastrar implements Initializable 
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
    private TextField tfSalario;

    private Escola escola;

    public JanelaProfessoresCadastrar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        
    }

    @FXML
    private void cadastrarProfessor(ActionEvent evento)
    {
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        int salario = Integer.valueOf(tfSalario.getText());
        
        if(!email.contains("@"))
        {
            tfEmail.getStyleClass().add("erro-textfield");
            Alert alert = new Alert(AlertType.WARNING, "Email Invalido!");
            alert.showAndWait();
            return;
        }

        String msg = "Cadastro realizado!";
        if(!escola.cadastrarProfessor(cpf, nome, email, telefone, salario))
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
        tfSalario.clear();
    }
}