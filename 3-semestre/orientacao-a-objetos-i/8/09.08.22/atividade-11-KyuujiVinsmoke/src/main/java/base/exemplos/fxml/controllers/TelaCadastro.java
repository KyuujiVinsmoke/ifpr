package base.exemplos.fxml.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class TelaCadastro 
{
    @FXML
    private TextField tfPlaca;

    @FXML
    private TextField tfModelo;
    
    @FXML
    private TextField tfCor;
    
    @FXML
    private TextField tfFabricante;

    @FXML
    private TextField tfAnoFabricacao;

    @FXML
    private void cadastrar (ActionEvent event)
    {
        String placa = tfPlaca.getText();
        String modelo = tfModelo.getText();
        String cor = tfCor.getText();
        String Fabricante = tfFabricante.getText();
        int anoFabricacao = Integer.valueOf(tfAnoFabricacao.getText());
    }
}