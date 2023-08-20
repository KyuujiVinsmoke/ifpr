package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Alert.AlertType;

public class JanelaCadastro
{
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    private ListaTelefonica listaTelefonica;

    public JanelaCadastro(ListaTelefonica listaTelefonica)
    {
        this.listaTelefonica = listaTelefonica;
    }

    @FXML
    private void cadastrar(ActionEvent evento)
    {
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();

        if(listaTelefonica.adicionarContato(nome, telefone, email))
        {
            Alert alert = new Alert(AlertType.INFORMATION,"Cadastro realizado");
            alert.showAndWait();
            limpar();
        }

        else
        {
            Alert alert = new Alert(AlertType.WARNING,"Cadastro não realizado");
            alert.showAndWait();  
        }
    }

    @FXML
    private void cancelar()
    {
        App.popScreen();
    }

    private void limpar()
    {
        tfNome.clear();
        tfTelefone.clear();
        tfEmail.clear();
    }
}