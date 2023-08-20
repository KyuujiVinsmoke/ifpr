package ifpr.pgua.eic.escola.controllers;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;

public class JanelaPrincipal 
{
    @FXML
    VBox left;

    @FXML
    private void carregaTelaAlunos()
    {
        limparEstilo();
        left.getStyleClass().add("left-alunos");
        App.changeScreenRegion("ALUNOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaProfessores()
    {
        limparEstilo();
        left.getStyleClass().add("left-professores");
        App.changeScreenRegion("PROFESSORES", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaCursos()
    {
        limparEstilo();
        left.getStyleClass().add("left-cursos");
        App.changeScreenRegion("CURSOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaMatriculas()
    {
        limparEstilo();
        left.getStyleClass().add("left-matriculas");
        App.changeScreenRegion("MATRICULAS", BorderPaneRegion.CENTER);
    }

    public void limparEstilo()
    {
        left.getStyleClass().remove("left-alunos");
        left.getStyleClass().remove("left-professores");
        left.getStyleClass().remove("left-cursos");
        left.getStyleClass().remove("left-matriculas");
    }
}