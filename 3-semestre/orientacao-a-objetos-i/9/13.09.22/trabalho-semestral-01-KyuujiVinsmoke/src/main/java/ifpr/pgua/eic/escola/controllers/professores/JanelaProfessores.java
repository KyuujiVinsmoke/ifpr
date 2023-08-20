package ifpr.pgua.eic.escola.controllers.professores;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaProfessores
{
    @FXML
    private void carregaTelaProfessoresCadastrar(ActionEvent evento)
    {
        App.changeScreenRegion("PROFESSORESCADASTRAR", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaProfessoresListar(ActionEvent evento)
    {
        App.changeScreenRegion("PROFESSORESLISTAR", BorderPaneRegion.CENTER);
    }
}