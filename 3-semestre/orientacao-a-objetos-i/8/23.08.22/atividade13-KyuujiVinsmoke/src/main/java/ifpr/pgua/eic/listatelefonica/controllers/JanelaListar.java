package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardHomeHandler;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardResizeToggleHandler;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class JanelaListar implements Initializable
{
    @FXML
    private ListView<Contato> ltvContatos;

    @FXML
    private TextArea taDetalhes;

    @FXML
    private TextField tfBuscar;

    private ListaTelefonica listaTelefonica;

    public JanelaListar(ListaTelefonica listaTelefonica)
    {
        this.listaTelefonica = listaTelefonica;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        ltvContatos.getItems().clear();
        
        ltvContatos.getItems().addAll(listaTelefonica.getContatos());    
    }

    @FXML
    private void mostrarDetalhes(MouseEvent evento)
    {
        Contato contato = ltvContatos.getSelectionModel().getSelectedItem();

        if(contato != null){
            taDetalhes.clear();
            taDetalhes.appendText("Nome: "+contato.getNome()+"\n");
            taDetalhes.appendText("Telefone: "+contato.getTelefone()+"\n");
            taDetalhes.appendText("Email: "+contato.getEmail()+"\n");
        }
    }

    @FXML
    private void buscar(ActionEvent evento)
    {
        String inicio = tfBuscar.getText();
         
        ltvContatos.getItems().clear();
        ltvContatos.getItems().addAll(listaTelefonica.buscaPorNome(inicio)); 
    }

    @FXML
    private void voltar()
    {
        App.popScreen();
    }
}