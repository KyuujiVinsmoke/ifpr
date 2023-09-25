package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Artista;

public class JDBCArtistaDAO implements ArtistaDAO {
    
    private FabricaConexoes fabrica;

    public JDBCArtistaDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado salvar(Artista artista) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO artistas(nome,contato) VALUES (?,?)");
            pstm.setString(1,artista.getNome());
            pstm.setString(2, artista.getContato());
            int ret = pstm.executeUpdate();

            if(ret == 1) {
                pstm.close();
                con.close();
                return Resultado.sucesso("Artista cadastrado!", artista);
            }
            return Resultado.erro("Erro desconhecido!");
        } catch(SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listarTodos() {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM artistas");
            ResultSet resultado = pstm.executeQuery();
            ArrayList<Artista> lista = new ArrayList<>();

            while(resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String contato = resultado.getString("contato");
                Artista artista = new Artista(id,nome, contato);
                lista.add(artista);
            }
            resultado.close();
            pstm.close();
            con.close();
            return Resultado.sucesso("Lista de artistas", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarPorId(int id) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM artistas WHERE id=?");
            pstm.setInt(1, id);
            ResultSet resultado = pstm.executeQuery();
            
            if(resultado.next()) {
                String nome = resultado.getString("nome");
                String contato = resultado.getString("contato");
                Artista artista = new Artista(id, nome, contato);
                resultado.close();
                pstm.close();
                con.close();
                return Resultado.sucesso("Artista encontrado", artista);
            } else {
                return Resultado.erro("Artista não encontrado!");
            }
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarArtistaMusica(int musicaId) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT artistaId FROM musicas WHERE id=?");
            pstm.setInt(1, musicaId);
            ResultSet resultado = pstm.executeQuery();
            resultado.next();
            int artistaId = resultado.getInt("artistaId");
            resultado.close();
            pstm.close();
            con.close();
            return buscarPorId(artistaId);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado atualizar(int id, Artista artista) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Resultado deletar(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
}