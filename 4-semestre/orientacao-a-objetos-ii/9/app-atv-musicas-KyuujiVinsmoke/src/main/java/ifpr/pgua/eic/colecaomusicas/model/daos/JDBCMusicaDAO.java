package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Artista;
import ifpr.pgua.eic.colecaomusicas.model.entities.Genero;
import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.utils.DBUtils;

public class JDBCMusicaDAO implements MusicaDAO {
    
    private FabricaConexoes fabrica;

    public JDBCMusicaDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado salvar(Musica musica) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO musicas(nome,duracao,anoLancamento,artistaId,generoId) VALUES (?,?,?,?,?)");
            pstm.setString(1, musica.getNome());
            pstm.setInt(2, musica.getDuracao());
            pstm.setInt(3, musica.getAnoLancamento());
            pstm.setInt(4, musica.getArtista().getId());
            pstm.setInt(5, musica.getGenero().getId());
            int ret = pstm.executeUpdate();

            if(ret == 1) {
                pstm.close();
                con.close();
                return Resultado.sucesso("Música cadastrada", musica);
            }
            return Resultado.erro("Erro desconhecido!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listarTodos() {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM musicas");
            ResultSet resultado = pstm.executeQuery();
            ArrayList<Musica> lista = new ArrayList<>();

            while(resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int duracao = resultado.getInt("duracao");
                int anoLancamento = resultado.getInt("anoLancamento");
                Musica musica = new Musica(id, nome, anoLancamento, duracao, null, null);
                lista.add(musica);
            }
            resultado.close();
            pstm.close();
            con.close();
            return Resultado.sucesso("Musicas listadas", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarPorId(int id) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM musicas WHERE id=(?)");
            pstm.setInt(1, id);
            ResultSet resultado = pstm.executeQuery();
            ArrayList<Musica> lista = new ArrayList<>();
            
            while(resultado.next()) {
                String nome = resultado.getString("nome");
                int anoLancamento = resultado.getInt("anoLancamento");
                int duracao = resultado.getInt("duracao");
                Musica musica = new Musica(id, nome, anoLancamento, duracao);
                lista.add(musica);
            }
            
            resultado.close();
            pstm.close();
            con.close();
            return Resultado.sucesso("Musica encontrado!", lista); 
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado atualizar(int id, Musica musica) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Resultado deletar(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
}