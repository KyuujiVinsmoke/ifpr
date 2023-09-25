package ifpr.pgua.eic.colecaomusicas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.daos.ArtistaDAO;
import ifpr.pgua.eic.colecaomusicas.model.entities.Artista;

public class RepositorioArtistas {
    private ArtistaDAO artistaDAO;

    public RepositorioArtistas(ArtistaDAO artistaDAO) {
        this.artistaDAO = artistaDAO;
    }

    public Resultado cadastrarArtista(String nome, String contato) {
        if(nome.isEmpty() || nome.isBlank()) {
            return Resultado.erro("Nome inválido!");
        }

        if(contato.isBlank() || contato.isEmpty()) {
            return Resultado.erro("Contato inválido!");
        }

        Artista artista = new Artista(nome, contato);
        return artistaDAO.salvar(artista);
    }

    public Resultado listarArtistas() {
        return artistaDAO.listarTodos();
    }
}