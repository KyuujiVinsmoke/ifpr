package ifpr.pgua.eic.despesas.model.daos;

import java.util.List;

import ifpr.pgua.eic.despesas.model.entities.Despesa;
import ifpr.pgua.eic.despesas.model.results.Result;

public interface DespesaDAO 
{
    Result cadastrar(Despesa despesa);
    Result alterar(int id, Despesa despesa);
    Result deletar(int id);
    List<Despesa> listDespesa();
}