package ifpr.pgua.eic.despesas.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.despesas.controllers.viewmodels.DespesaRow;
import ifpr.pgua.eic.despesas.controllers.viewmodels.TelaDespesasViewModel;
import ifpr.pgua.eic.despesas.model.results.Result;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaDespesas extends BaseController implements Initializable {

    @FXML
    private TextField tfTitulo;

    @FXML
    private ComboBox<String> cbTipos;

    @FXML
    private TextField tfValor;

    @FXML
    private DatePicker dpData;


    @FXML
    private TableColumn<DespesaRow,String> tbcTitulo;

    @FXML
    private TableColumn<DespesaRow, String> tbcTipo;

    @FXML
    private TableColumn<DespesaRow, String> tbcValor;

    @FXML
    private TableColumn<DespesaRow, String> tbcData;


    @FXML
    private TableView<DespesaRow> tbDespesas;

    
    @FXML
    private Button btCadastrar;
    
    @FXML
    private Button btLimpar;


    private TelaDespesasViewModel viewModel;


    public TelaDespesas(TelaDespesasViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //define quais serão as propriedades que servirão para preencher
        //o valor da coluna. Note que o nome da propriedade deve possuir
        //um get equivalente no modelo que representa a linha da tabela.
        tbcTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tbcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        
        //liga o conjunto de itens da tabela com a lista de clientes do viewmodel
        tbDespesas.setItems(viewModel.getDespesas());

        viewModel.alertProperty().addListener((ChangeListener<Result>) (observable, oldVal, newVal) -> {
            // TODO Auto-generated method stub
            showMessage(newVal);
        });

        //liga a propriedade texto do textfield nome com a propriedade do viewmodel
        tfTitulo.textProperty().bindBidirectional(viewModel.tituloProperty());
        
        tfValor.textProperty().bindBidirectional(viewModel.valorProperty());
        
        dpData.valueProperty().bindBidirectional(viewModel.dataProperty());

        viewModel.tipoProperty().bindBidirectional(cbTipos.selectionModelProperty());

        cbTipos.setItems(viewModel.getTipos());

        viewModel.updateList();
    }

    @FXML
    private void cadastrar(){
        viewModel.cadastrar();
    }

    @FXML
    private void limpar(){
        viewModel.limpar();
    }
}