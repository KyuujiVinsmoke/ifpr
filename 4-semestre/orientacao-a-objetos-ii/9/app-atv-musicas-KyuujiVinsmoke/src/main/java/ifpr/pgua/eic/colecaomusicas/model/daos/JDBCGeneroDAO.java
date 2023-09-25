package ifpr.pgua.eic.colecaomusicas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.colecaomusicas.model.entities.Genero;

public class JDBCGeneroDAO implements GeneroDAO {
    
    private FabricaConexoes fabrica;

    public JDBCGeneroDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado salvar(Genero genero) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO generos(nome) VALUES (?)");
            pstm.setString(1, genero.getNome());
            int ret = pstm.executeUpdate();
            
            if (ret == 1) {
                pstm.close();
                con.close();
                return Resultado.sucesso("Gênero cadastrado", genero);
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
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM generos");
            ResultSet resultado = pstm.executeQuery();
            ArrayList<Genero> lista = new ArrayList<>();

            while(resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                Genero genero = new Genero(id, nome);
                lista.add(genero);
            }
            resultado.close();
            pstm.close();
            con.close();
            return Resultado.sucesso("Gêneros listados!", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarPorId(int id) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM generos WHERE id=?");
            pstm.setInt(1, id);
            ResultSet resultado = pstm.executeQuery();

            if(resultado.next()) {
                String nome = resultado.getString("nome");
                Genero genero = new Genero(id, nome);
                resultado.close();
                pstm.close();
                con.close();
                return Resultado.sucesso("Gênero encontrado!", genero);
            } else {
                return Resultado.erro("Gênero não encontrado!");
            }
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado buscarGeneroMusica(int musicaId) {
        try {
            Connection con = fabrica.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT generoId FROM musicas WHERE id=?");
            pstm.setInt(1, musicaId);
            ResultSet resultado = pstm.executeQuery();
            resultado.next();
            int generoId = resultado.getInt("generoId");
            resultado.close();
            pstm.close();
            con.close();
            return buscarPorId(generoId);
        } catch (SQLException e) {  
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado atualizar(int id, Genero genero) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Resultado deletar(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}