package ifpr.pgua.eic.escola.controllers;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.fxml.FXML;

public class JanelaPrincipal 
{
    @FXML
    private void carregaTelaAlunos()
    {
        App.changeScreenRegion("ALUNOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaCursos()
    {
        App.changeScreenRegion("CURSOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaProfessores()
    {
        App.changeScreenRegion("PROFESSORES", BorderPaneRegion.CENTER);
    }
}