package base.exemplos.fxml;

import java.net.URL;

import base.exemplos.fxml.controllers.TelaCadastro;
import base.exemplos.fxml.controllers.TelaPrincipal;
import base.utils.BaseAppNavigator;
import base.utils.ScreenRegistry;
import javafx.scene.Parent;

public class App extends BaseAppNavigator{

    public static final ScreenRegistry PRINCIPAL = new ScreenRegistry(App.class,"telas/principal.fxml",o->new TelaPrincipal());
    public static final ScreenRegistry CADASTRO = new ScreenRegistry(App.class,"telas/cadastro.fxml",o->new TelaCadastro());

    @Override
    public ScreenRegistry getHomeFXML() {
        return CADASTRO;
    }

    @Override
    public Parent getHomeParent() {
        return null;
    }

    @Override
    public String getAppTitle() {
        return "Teste";
    }


    
}
