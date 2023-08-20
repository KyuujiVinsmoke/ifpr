package ifpr.pgua.eic.escola.controllers.professores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    private TextField tfNome;

    @FXML
    private TextField tfCpf;

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
        try
        {
            String nome = tfNome.getText();
            String cpf = tfCpf.getText();
            String email = tfEmail.getText();
            String telefone = tfTelefone.getText();
            Double salario = Double.parseDouble(tfSalario.getText());

            if(!email.contains("@"))
            {   
                tfSalario.getStyleClass().remove("erro-textfield");
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
    
            else if(!escola.cadastrarProfessor(nome, cpf, email, telefone, salario))
            {
                Alert alert = new Alert(AlertType.WARNING, "Professor Já Cadastrado!");
                alert.showAndWait();
                return;
            }
            
            Alert alert = new Alert(AlertType.INFORMATION, "Cadastro Realizado!");
            alert.showAndWait();
            limpa();
        }

        catch (RuntimeException e)
        {   
            tfEmail.getStyleClass().remove("erro-textfield");
            tfSalario.getStyleClass().add("erro-textfield");
            Alert alert = new Alert(AlertType.WARNING, "Preencha Os Campos Corretamente!");
            alert.showAndWait();
            return;
        }
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
        tfSalario.clear();
        tfSalario.getStyleClass().remove("erro-textfield");
    }
}