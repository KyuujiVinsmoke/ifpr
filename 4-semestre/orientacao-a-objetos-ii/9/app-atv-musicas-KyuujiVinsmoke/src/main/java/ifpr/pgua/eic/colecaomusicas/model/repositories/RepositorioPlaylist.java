package ifpr.pgua.eic.colecaomusicas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.daos.PlaylistDAO;

import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;


public class RepositorioPlaylist {
    private PlaylistDAO playlistDAO;

    public RepositorioPlaylist(PlaylistDAO playlistDAO) {
        this.playlistDAO = playlistDAO;
    }

    public Resultado cadastrarPlaylist(String nome) {
        if(nome.isBlank() || nome.isEmpty()) {
            return Resultado.erro("Nome inválido!");
        }

        Playlist playlist = new Playlist(nome);
        return playlistDAO.salvar(playlist);
    }

    public Resultado listarPlaylist() {
        return playlistDAO.listarTodos();
    }
}