package ifpr.pgua.eic.despesas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ifpr.pgua.eic.despesas.model.FabricaConexoes;
import ifpr.pgua.eic.despesas.model.entities.Despesa;
import ifpr.pgua.eic.despesas.model.results.Result;


public class JDBCDespesaDAO implements DespesaDAO {
    private  FabricaConexoes fabricaConexoes;

    public JDBCDespesaDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrar(Despesa despesa)  {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement stm = con.prepareStatement("INSERT INTO despesas(titulo, valor, data, tipo) VALUES (?, ?, ?, ?)");
            stm.setString(1, despesa.getTitulo());
            stm.setDouble(2, despesa.getValor());
            stm.setTimestamp(3, Timestamp.valueOf(despesa.getData()));
            stm.setString(4, despesa.getTipo());

            stm.execute();
            stm.close();
            con.close();
        } catch(SQLException exception) {
            exception.printStackTrace();
            return Result.fail("Falhou");
        }
        
        return null;
    }

    @Override
    public Result alterar(int id, Despesa despesa) {
        return null;
    }

    @Override
    public Result deletar( int id) {
        return null;
    }

    @Override
    public List<Despesa> listDespesa() {
        List<Despesa> despesa = new ArrayList<>();
        Despesa despesaAdd = null;

        try{
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement stm = con.prepareStatement("SELECT * FROM despesas");
            
            ResultSet resultSet = stm.executeQuery();

            while(resultSet.next()) {
                Integer idDespesas = resultSet.getInt("id");
                String tituloDespesas = resultSet.getString("titulo");
                Double valorDespesas = resultSet.getDouble("valor");
                LocalDateTime dataDespesas = resultSet.getTimestamp("data").toLocalDateTime();
                String tipoDespesas= resultSet.getString("tipo");

                despesaAdd = new Despesa(idDespesas, tituloDespesas, tipoDespesas, valorDespesas, dataDespesas);
                despesa.add(despesaAdd);
            }

            stm.close();
            con.close();

            return despesa;
        }
        
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}