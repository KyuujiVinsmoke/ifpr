package ifpr.pgua.eic.colecaomusicas.controllers;

import ifpr.pgua.eic.colecaomusicas.App;
import javafx.fxml.FXML;

public class Principal {

    @FXML
    private void cadastrarGenero() {
        App.pushScreen("CADASTRARGENERO");
    }

    @FXML
    private void cadastrarArtista() {
        App.pushScreen("CADASTRARARTISTA");
    }

    @FXML
    private void listarGeneros() {
        App.pushScreen("LISTARGENEROS");
    }

    @FXML
    private void listarArtistas() {
        App.pushScreen("LISTARARTISTAS");
    }

    @FXML
    private void cadastrarMusica() {
        App.pushScreen("CADASTRARMUSICA");
    }

    @FXML
    private void listarMusicas() {
        App.pushScreen("LISTARMUSICAS");
    }

    @FXML
    private void cadastrarPlaylist() {
        App.pushScreen("CADASTRARPLAYLIST");
    }

    @FXML
    private void listarPlaylist() {
        App.pushScreen("LISTARPLAYLIST");
    }
}