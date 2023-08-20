package ifpr.pgua.eic.escola.controllers.cursos;

import java.lang.ref.Cleaner;
import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Curso;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.models.pessoas.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaCursosCadastrar implements Initializable 
{
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfCargaHoraria;

    @FXML
    private ComboBox<Professor> cbProfessor;

    private Escola escola;

    public JanelaCursosCadastrar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        cbProfessor.getItems().addAll(escola.listarProfessores());
    }

    @FXML
    private void cadastrarCurso(ActionEvent evento)
    {
        try
        {
            int codigo = 0;
            String nome = tfNome.getText();
            String descricao = tfDescricao.getText();
            int cargaHoraria = Integer.valueOf(tfCargaHoraria.getText());
            Professor professor = cbProfessor.getValue();

            if(!escola.cadastrarCurso(codigo, nome, descricao, cargaHoraria, professor))
            {
                Alert alert = new Alert(AlertType.WARNING, "Curso Já Cadastrado!");
                alert.showAndWait();
                limpa();
                return;
            }
            
            else
            {
                Alert alert = new Alert(AlertType.INFORMATION, "Cadastro Realizado!");
                alert.showAndWait();
                limpa();
            }
        }

        catch (RuntimeException e)
        {   
            tfCargaHoraria.getStyleClass().add("erro-textfield");
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
        tfDescricao.clear();
        tfCargaHoraria.clear();
        tfCargaHoraria.getStyleClass().remove("erro-textfield");
        cbProfessor.getSelectionModel().clearSelection();
    }
}