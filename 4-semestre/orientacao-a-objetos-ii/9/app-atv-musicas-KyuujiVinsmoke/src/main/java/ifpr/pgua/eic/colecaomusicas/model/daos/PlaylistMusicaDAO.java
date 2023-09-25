package ifpr.pgua.eic.colecaomusicas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.model.entities.PlaylistMusica;

public interface PlaylistMusicaDAO {
    Resultado salvar(PlaylistMusica entidade);
    Resultado buscarPorPlaylist(Playlist playlist);
    Resultado deletar(PlaylistMusica entidade);
}