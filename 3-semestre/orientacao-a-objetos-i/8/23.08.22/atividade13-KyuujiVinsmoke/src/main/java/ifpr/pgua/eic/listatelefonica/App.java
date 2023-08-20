package ifpr.pgua.eic.listatelefonica;

import ifpr.pgua.eic.listatelefonica.controllers.JanelaCadastro;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaListar;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaPrincipal;
import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import ifpr.pgua.eic.listatelefonica.utils.BaseAppNavigator;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistry;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistryFXML;

public class App extends BaseAppNavigator 
{
    private ListaTelefonica listaTelefonica;
    private Contato contato;

    @Override
    public void init() throws Exception 
    {
        super.init();

        listaTelefonica = new ListaTelefonica();
        contato = new Contato("nome", "email", "telefone");
    }
    
    public static void main(String[] args) 
    {
        launch();
    }

    @Override
    public String getHome() 
    {
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() 
    {
        return "Lista Telefônica";
    }

    @Override
    public void registrarTelas() 
    {
        registraTela("PRINCIPAL",new ScreenRegistryFXML(App.class, "principal.fxml", o->new JanelaPrincipal()));
        registraTela("CADASTRO", new ScreenRegistryFXML(App.class, "cadastro.fxml", o->new JanelaCadastro(listaTelefonica)));
        registraTela("LISTAR", new ScreenRegistryFXML(App.class, "listar.fxml", o->new JanelaListar(listaTelefonica)));
    }
}