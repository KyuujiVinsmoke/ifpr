package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioMusicas;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylist;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylistMusica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class CadastroPlaylist implements Initializable {

    @FXML
    private ListView<Musica> ltvMusica;

    @FXML
    private ListView<Musica> ltvPlaylist;

    @FXML
    private TextField tfNome;

    private RepositorioMusicas repositorioMusicas;
    private RepositorioPlaylist repositorioPlaylist;
    private RepositorioPlaylistMusica repositorioPlaylistMusica;

    private List<Musica> musicas = new ArrayList<Musica>();

    public CadastroPlaylist(RepositorioMusicas repositorioMusicas, RepositorioPlaylist repositorioPlaylist, RepositorioPlaylistMusica repositorioPlaylistMusica) {
        this.repositorioMusicas = repositorioMusicas;
        this.repositorioPlaylist = repositorioPlaylist;
        this.repositorioPlaylistMusica = repositorioPlaylistMusica;
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Resultado resultado = repositorioMusicas.listarMusicas();

        if(resultado.foiErro()) {
            Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
            alert.showAndWait();
        } else {
            List<Musica> list = (List)resultado.comoSucesso().getObj();
            ltvMusica.getItems().addAll(list);
        }
    }

    @FXML
    void adicionar(MouseEvent evento) {
        if(ltvMusica.getSelectionModel().getSelectedItem() != null) {
            ltvPlaylist.getItems().clear();
            musicas.add(ltvMusica.getSelectionModel().getSelectedItem());
            ltvPlaylist.getItems().addAll(musicas);
            ltvMusica.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void remover(MouseEvent evento) {
        if(ltvPlaylist.getSelectionModel().getSelectedItem() != null) {
            musicas.remove(ltvPlaylist.getSelectionModel().getSelectedItem());
            ltvPlaylist.getItems().clear();
            ltvPlaylist.getItems().addAll(musicas);
        }
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
        String nome = tfNome.getText();
        Resultado resultadoPlaylist = repositorioPlaylist.cadastrarPlaylist(nome);
        Alert alert;
        
        if(resultadoPlaylist.foiErro()) {
            alert = new Alert(AlertType.ERROR, resultadoPlaylist.getMsg());
        } else {
            alert = new Alert(AlertType.INFORMATION, resultadoPlaylist.getMsg());
        }
        
        Playlist playlist = (Playlist)resultadoPlaylist.comoSucesso().getObj();

        for(Musica musica : musicas) {
            repositorioPlaylistMusica.cadastrarPlaylistMusicas(musica, playlist);
        }

        alert.showAndWait();
        cancelar(event);
    }

    @FXML
    void cancelar(ActionEvent event) {
        App.popScreen();
    }
}