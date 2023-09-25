package ifpr.pgua.eic.colecaomusicas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;

public interface PlaylistDAO {
    Resultado salvar(Playlist entidade);
    Resultado listarTodos();
    Resultado buscarPorId(int id);
    Resultado atualizar(int id, Playlist entidade);
    Resultado deletar(int entidade);
}