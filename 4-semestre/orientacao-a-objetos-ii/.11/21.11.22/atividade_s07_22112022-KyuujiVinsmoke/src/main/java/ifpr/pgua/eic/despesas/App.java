package ifpr.pgua.eic.despesas;

import ifpr.pgua.eic.despesas.controllers.TelaDespesas;
import ifpr.pgua.eic.despesas.controllers.TelaPrincipal;
import ifpr.pgua.eic.despesas.controllers.viewmodels.TelaDespesasViewModel;
import ifpr.pgua.eic.despesas.model.FabricaConexoes;
import ifpr.pgua.eic.despesas.model.daos.DespesaDAO;
import ifpr.pgua.eic.despesas.model.daos.JDBCDespesaDAO;
import ifpr.pgua.eic.despesas.model.repository.DespesaRepository;
import ifpr.pgua.eic.despesas.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.despesas.utils.Navigator.ScreenRegistryFXML;

public class App extends BaseAppNavigator 
{
    private DespesaDAO despesaDao;
    private DespesaRepository despesaRepository;

    @Override
    public void init() throws Exception 
    {
        despesaDao = new JDBCDespesaDAO(FabricaConexoes.getInstance());
        despesaRepository = new DespesaRepository(despesaDao);
        super.init();
    }

    @Override
    public void stop() throws Exception 
    {
        super.stop();
    }

    @Override
    public String getHome() 
    {
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() 
    {
        return "Despesas";
    }

    @Override
    public void registrarTelas() 
    {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(getClass(), "fxml/principal.fxml", (o)->new TelaPrincipal()));
        registraTela("DESPESAS", new ScreenRegistryFXML(getClass(), "fxml/despesas.fxml", (o)->new TelaDespesas(new TelaDespesasViewModel(despesaRepository))));  
    }
}