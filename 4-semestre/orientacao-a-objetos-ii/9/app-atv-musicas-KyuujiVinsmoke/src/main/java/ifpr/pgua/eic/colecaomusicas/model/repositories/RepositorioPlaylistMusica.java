package ifpr.pgua.eic.colecaomusicas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.daos.MusicaDAO;
import ifpr.pgua.eic.colecaomusicas.model.daos.PlaylistDAO;
import ifpr.pgua.eic.colecaomusicas.model.daos.PlaylistMusicaDAO;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.model.entities.PlaylistMusica;


public class RepositorioPlaylistMusica {
    private MusicaDAO musicaDAO;
    private PlaylistDAO playlistDAO;
    private PlaylistMusicaDAO playlistMusicaDAO;

    public RepositorioPlaylistMusica(MusicaDAO musicaDAO, PlaylistDAO playlistDAO, PlaylistMusicaDAO playlistMusicaDAO) {
        this.musicaDAO = musicaDAO;
        this.playlistDAO = playlistDAO;
        this.playlistMusicaDAO = playlistMusicaDAO;
    }

    public Resultado cadastrarPlaylistMusicas(Musica musica, Playlist playlist) {
        PlaylistMusica playlistMusica = new PlaylistMusica(musica, playlist);
        return playlistMusicaDAO.salvar(playlistMusica);
    }

    public Resultado listarPlaylistMusicas(Playlist playlist) {
        return playlistMusicaDAO.buscarPorPlaylist(playlist);
    }
}