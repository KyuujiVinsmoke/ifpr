package ifpr.pgua.eic.colecaomusicas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.App;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.model.entities.PlaylistMusica;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioMusicas;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylist;
import ifpr.pgua.eic.colecaomusicas.model.repositories.RepositorioPlaylistMusica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ListarPlaylist implements Initializable {

    @FXML
    private ListView<Playlist> ltvPlaylist;

    @FXML
    private TextArea taDetalhes;

    private RepositorioPlaylist repositorioPlaylist;
    private RepositorioMusicas repositorioMusicas;
    private RepositorioPlaylistMusica repositorioPlaylistMusica;
    
    public ListarPlaylist(RepositorioMusicas repositorioMusicas, RepositorioPlaylist repositorioPlaylist, RepositorioPlaylistMusica repositorioPlaylistMusica) {
        this.repositorioPlaylist = repositorioPlaylist;
        this.repositorioMusicas = repositorioMusicas;
        this.repositorioPlaylistMusica = repositorioPlaylistMusica;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ltvPlaylist.getItems().clear();
        Resultado resultado = repositorioPlaylist.listarPlaylist();

        if(resultado.foiErro()) {
            Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
            alert.showAndWait();
        } else {
            List lista = (List)resultado.comoSucesso().getObj();
            ltvPlaylist.getItems().addAll(lista);
        }
    }

    @FXML
    private void mostraDetalhesPlaylist(MouseEvent evento) {
        taDetalhes.clear();
        Playlist playlist = ltvPlaylist.getSelectionModel().getSelectedItem();
        Resultado resultadoPlaylistMusica = repositorioPlaylistMusica.listarPlaylistMusicas(playlist);
        PlaylistMusica playlistMusica = (PlaylistMusica)resultadoPlaylistMusica.comoSucesso().getObj();
        Resultado resultadoMusica = repositorioMusicas.listarMusicasId(playlistMusica.getMusica().getId());
        


        List<Musica> lista = (List<Musica>)resultadoMusica.comoSucesso().getObj();
        
        for(Musica musica : lista) {
            taDetalhes.appendText(musica.getNome() + "\n");
        }
    
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}