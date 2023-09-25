package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Musica;
import ifpr.pgua.eic.colecaomusicas.model.entities.Playlist;
import ifpr.pgua.eic.colecaomusicas.model.entities.PlaylistMusica;

public class JDBCPlaylistMusicaDAO implements PlaylistMusicaDAO {
    
    private FabricaConexoes fabrica;

    public JDBCPlaylistMusicaDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado salvar(PlaylistMusica playlistMusica) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO playlistsMusicas(musicasId, playlistsId) VALUES (?,?)");
            pstm.setInt(1, playlistMusica.getMusica().getId());
            pstm.setInt(2, playlistMusica.getPlaylist().getId());
            int ret = pstm.executeUpdate();
            
            if(ret == 1){
                pstm.close();
                con.close();
                return Resultado.sucesso("Playlist cadastrada", playlistMusica);
            }
            return Resultado.erro("Erro desconhecido!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarPorPlaylist(Playlist playlist) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM playlistsMusicas WHERE playlistsId=?");
            pstm.setInt(1, playlist.getId());
            ResultSet resultado = pstm.executeQuery();

            if(resultado.next()) {
                int id = resultado.getInt("id");
                Musica musica = new Musica(id, null, id, id, null, null);
                PlaylistMusica playlistMusica = new PlaylistMusica (id, musica, playlist);
                resultado.close();
                pstm.close();
                con.close();
                return Resultado.sucesso("Playlist encontrado", playlistMusica);
            } else {
                return Resultado.erro("Playlist não encontrado!");
            }
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado deletar(PlaylistMusica playlistMusica) {
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
}