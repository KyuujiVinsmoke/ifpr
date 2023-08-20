package ifpr.pgua.eic.escola.controllers.matriculas;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaMatriculas 
{
    @FXML
    private void carregaTelaMatricularAlunos(ActionEvent evento)
    {
        App.changeScreenRegion("MATRICULARALUNOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaDesmatricularAlunos(ActionEvent evento)
    {
        App.changeScreenRegion("DESMATRICULARALUNOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaMatriculasListar(ActionEvent evento)
    {
        App.changeScreenRegion("MATRICULASLISTAR", BorderPaneRegion.CENTER);
    }
}