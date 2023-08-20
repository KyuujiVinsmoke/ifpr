package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaPrincipal 
{
    @FXML
    private void carregaTelaCadastro(ActionEvent evento)
    {
        App.changeScreenRegion("CADASTRO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaListar(ActionEvent evento)
    {
        App.changeScreenRegion("LISTAR", BorderPaneRegion.CENTER);
    }
}