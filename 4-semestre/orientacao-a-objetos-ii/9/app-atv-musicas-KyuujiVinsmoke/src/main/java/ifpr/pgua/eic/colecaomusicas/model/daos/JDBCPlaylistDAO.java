package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.utils.DBUtils;

public class JDBCPlaylistDAO implements PlaylistDAO {
    
    private FabricaConexoes fabrica;

    public JDBCPlaylistDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado salvar(Playlist playlist) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO playlists(nome) VALUES (?)");
            pstm.setString(1, playlist.getNome());
            int ret = pstm.executeUpdate();
            int id = DBUtils.getLastId((pstm));
            playlist.setId(id);

            if (ret == 1) {
                pstm.close();
                con.close();
                return Resultado.sucesso("Playlist cadastrada", playlist);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listarTodos() {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM playlists");
            ResultSet resultado = pstm.executeQuery();
            ArrayList<Playlist> lista = new ArrayList<>();

            while(resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                Playlist playlist = new Playlist(id, nome);
                lista.add(playlist);
            }
            resultado.close();
            pstm.close();
            con.close();
            return Resultado.sucesso("Playlists listadas!", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarPorId(int id) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM playlists WHERE id=?");
            pstm.setInt(1, id);
            ResultSet resultado = pstm.executeQuery();

            if(resultado.next()){
                String nome = resultado.getString("nome");
                Playlist playlist = new Playlist(id, nome);
                resultado.close();
                pstm.close();
                con.close();
                return Resultado.sucesso("Playlist encontrada!", playlist);
            } else {
                return Resultado.erro("Playlist não encontrada!");
            }
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado atualizar(int id, Playlist playlist) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Resultado deletar(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}