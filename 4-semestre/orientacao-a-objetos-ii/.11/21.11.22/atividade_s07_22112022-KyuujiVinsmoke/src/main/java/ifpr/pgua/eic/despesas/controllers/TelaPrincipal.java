package ifpr.pgua.eic.despesas.controllers;

import ifpr.pgua.eic.despesas.App;
import ifpr.pgua.eic.despesas.utils.Navigator.BorderPaneRegion;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {
    

    @FXML
    private void carregarDespesas(){
        App.changeScreenRegion("DESPESAS", BorderPaneRegion.CENTER);
    }

}
