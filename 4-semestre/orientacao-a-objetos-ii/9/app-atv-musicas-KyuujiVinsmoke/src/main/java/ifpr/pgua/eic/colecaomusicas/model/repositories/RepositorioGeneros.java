package ifpr.pgua.eic.colecaomusicas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.daos.GeneroDAO;
import ifpr.pgua.eic.colecaomusicas.model.entities.Genero;

public class RepositorioGeneros {
    private GeneroDAO dao;

    public RepositorioGeneros(GeneroDAO dao) {
        this.dao = dao;
    }

    public Resultado cadastrarGenero(String nome) {
        if(nome.isEmpty() || nome.isBlank()) {
            return Resultado.erro("Nome inválido!");
        }

        Genero genero = new Genero(nome);
        return dao.salvar(genero);
    }

    public Resultado listarGeneros() {
        return dao.listarTodos();
    }
}