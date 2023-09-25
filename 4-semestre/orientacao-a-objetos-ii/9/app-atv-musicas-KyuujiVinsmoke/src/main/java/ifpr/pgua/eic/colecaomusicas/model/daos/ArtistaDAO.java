package ifpr.pgua.eic.colecaomusicas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Artista;

public interface ArtistaDAO {
    Resultado salvar(Artista entidade);
    Resultado listarTodos();
    Resultado buscarPorId(int id);
    Resultado buscarArtistaMusica(int musicaId);
    Resultado atualizar(int id, Artista entidade);
    Resultado deletar(int entidade);
}