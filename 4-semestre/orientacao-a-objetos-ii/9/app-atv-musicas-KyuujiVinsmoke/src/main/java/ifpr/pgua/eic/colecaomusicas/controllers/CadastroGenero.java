package ifpr.pgua.eic.colecaomusicas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioGeneros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroGenero {

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNome;

    private RepositorioGeneros repositorio;

    public CadastroGenero(RepositorioGeneros repositorio) {
        this.repositorio = repositorio;
    }

    @FXML
    void cadastrar(ActionEvent event) {
        String nome = tfNome.getText();
        Resultado resultado = repositorio.cadastrarGenero(nome);
        Alert alert;

        if(resultado.foiErro()) {
            alert = new Alert(AlertType.ERROR, resultado.getMsg());
        } else {
            alert = new Alert(AlertType.INFORMATION, resultado.getMsg());
        }

        alert.showAndWait();
        cancelar(event);
    }

    @FXML
    void cancelar(ActionEvent event) {
        App.popScreen();
    }
}