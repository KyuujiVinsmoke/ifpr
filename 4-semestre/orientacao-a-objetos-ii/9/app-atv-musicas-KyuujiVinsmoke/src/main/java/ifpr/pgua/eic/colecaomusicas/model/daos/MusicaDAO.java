package ifpr.pgua.eic.colecaomusicas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;

public interface MusicaDAO {
    Resultado salvar(Musica entidade);
    Resultado listarTodos();
    Resultado buscarPorId(int id);
    Resultado atualizar(int id, Musica entidade);
    Resultado deletar(int entidade);
}