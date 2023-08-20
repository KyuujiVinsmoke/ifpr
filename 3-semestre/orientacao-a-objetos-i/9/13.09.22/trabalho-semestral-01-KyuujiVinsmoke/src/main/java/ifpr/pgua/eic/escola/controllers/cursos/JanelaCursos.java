package ifpr.pgua.eic.escola.controllers.cursos;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaCursos 
{
    @FXML
    private void carregaTelaCursosCadastrar(ActionEvent evento)
    {
        App.changeScreenRegion("CURSOSCADASTRAR", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaCursosListar(ActionEvent evento)
    {
        App.changeScreenRegion("CURSOSLISTAR", BorderPaneRegion.CENTER);
    }
}