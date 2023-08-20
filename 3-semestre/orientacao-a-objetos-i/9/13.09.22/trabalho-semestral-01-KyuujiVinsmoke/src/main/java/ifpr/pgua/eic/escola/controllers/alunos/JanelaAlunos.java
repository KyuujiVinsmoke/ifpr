package ifpr.pgua.eic.escola.controllers.alunos;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaAlunos
{
    @FXML
    private void carregaTelaAlunosCadastrar(ActionEvent evento)
    {
        App.changeScreenRegion("ALUNOSCADASTRAR", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaAlunosListar(ActionEvent evento)
    {
        App.changeScreenRegion("ALUNOSLISTAR", BorderPaneRegion.CENTER);
    }
}