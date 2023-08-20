package ifpr.pgua.eic.escola.controllers.cursos;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaCursosCadastrar implements Initializable 
{
    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfCargaHoraria;

    private Escola escola;

    public JanelaCursosCadastrar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        
    }

    @FXML
    private void cadastrarCurso(ActionEvent evento)
    {
        // int codigo = Integer.valueOf(tfCodigo.getText());
        // String nome = tfNome.getText();
        // String descricao = tfNome.getText();
        // int cargaHoraria = Integer.valueOf(tfCargaHoraria.getText());
        // Professor professor = Integer.valueOf(tfProfessor.getText());

        // String msg = "Cadastro realizado!";
        // if(!escola.cadastrarCurso(codigo, nome, descricao, cargaHoraria, professor))
        // {
        //     msg = "Cadastro não realizado!";
        // }
        
        // else
        // {
        //     limpa();
        // }

        // Alert alert = new Alert(AlertType.INFORMATION,msg);
        // alert.showAndWait();
    }

    @FXML
    private void limpar(ActionEvent evento)
    {
        limpa();
    }

    private void limpa()
    {
        tfCodigo.clear();
        tfNome.clear();
        tfDescricao.clear();
        tfCargaHoraria.clear();
    }
}