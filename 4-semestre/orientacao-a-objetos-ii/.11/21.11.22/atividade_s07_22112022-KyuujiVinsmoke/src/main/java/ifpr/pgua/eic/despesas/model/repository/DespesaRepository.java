package ifpr.pgua.eic.despesas.model.repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.despesas.model.daos.DespesaDAO;
import ifpr.pgua.eic.despesas.model.entities.Despesa;
import ifpr.pgua.eic.despesas.model.results.Result;

public class DespesaRepository 
{
    private List<Despesa> despesa;
    private DespesaDAO dao;

    public DespesaRepository(DespesaDAO dao)
    {
        this.dao = dao;
    }

    public Result cadastrarDespesa(String titulo, String tipo, Double valor, LocalDateTime data)
    {
        Despesa despesa = new Despesa(titulo, tipo, valor, data);
        return dao.cadastrar(despesa);
    }

    public List<Despesa> listDespesa()
    {
        despesa = dao.listDespesa();
        return Collections.unmodifiableList(despesa);
    }
}