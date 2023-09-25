package ifpr.pgua.eic.colecaomusicas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Genero;

public interface GeneroDAO {
    Resultado salvar(Genero entidade);
    Resultado listarTodos();
    Resultado buscarPorId(int id);
    Resultado buscarGeneroMusica(int id);
    Resultado atualizar(int id, Genero entidade);
    Resultado deletar(int entidade);
}