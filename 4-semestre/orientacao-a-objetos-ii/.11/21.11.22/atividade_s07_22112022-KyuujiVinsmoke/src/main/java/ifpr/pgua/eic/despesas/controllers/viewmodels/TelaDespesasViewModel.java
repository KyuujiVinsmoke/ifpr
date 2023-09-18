package ifpr.pgua.eic.despesas.controllers.viewmodels;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import ifpr.pgua.eic.despesas.model.entities.Despesa;
import ifpr.pgua.eic.despesas.model.repository.DespesaRepository;
import ifpr.pgua.eic.despesas.model.results.Result;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Alert.AlertType;

public class TelaDespesasViewModel {
    private StringProperty tituloProperty = new SimpleStringProperty();
    private ObjectProperty<SingleSelectionModel<String>> tipoProperty = new SimpleObjectProperty<>();
    private StringProperty valorProperty = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dataProperty = new SimpleObjectProperty<>();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();

    private ObservableList<DespesaRow> despesas = FXCollections.observableArrayList();

    //idealmente viria de um banco de dados
    //a lista de tipos
    private ObservableList<String> tipos = FXCollections.observableArrayList("Alimentação", "Lazer", "Transporte", "Sobrevivência");

    public StringProperty tituloProperty() {
        return tituloProperty;
    }

    public ObjectProperty<SingleSelectionModel<String>> tipoProperty() {
        return tipoProperty;
    }

    public StringProperty valorProperty() {
        return valorProperty;
    }

    public ObjectProperty<LocalDate> dataProperty() {
        return dataProperty;
    }

    public ObjectProperty<Result> alertProperty() {
        return alertProperty;
    }

    private DespesaRepository repository;

    public TelaDespesasViewModel(DespesaRepository repository) {
        this.repository = repository;

        updateList();
    }

    public void updateList() {
        despesas.clear();
        for (Despesa a : repository.listDespesa()) {
            despesas.add(new DespesaRow(a));
        }
        
        //alertProperty.setValue(Result.fail("BUSCAR DO BANCO DE DADOS"));
    }

    public void cadastrar() {
        try {
            String titulo = tituloProperty.getValue();
            String tipo = tipoProperty.getValue().getSelectedItem();
            
            String sValor = valorProperty.getValue();
            Double valor = Double.valueOf(sValor);

            LocalDate data = dataProperty.getValue();
            LocalDateTime dataHora = LocalDateTime.of(data, LocalTime.now());

            if(tipo == null) {
                Alert alert = new Alert(AlertType.INFORMATION, "É necessário selecionar o tipo!");
                alert.showAndWait();
                return;
            }

            repository.cadastrarDespesa(titulo, tipo, valor, dataHora);
            limpar();
        } catch(NullPointerException e) {
            Alert alert = new Alert(AlertType.INFORMATION, "É necessário preencher todos os dados corretamente!");
            alert.showAndWait();
            return;
        } catch(NumberFormatException e) {
            Alert alert = new Alert(AlertType.INFORMATION, "É necessário preencher todos os dados corretamente!");
            alert.showAndWait();
            return;
        }

        //alertProperty.setValue(Result.fail("INSERIR NO BANCO DE DADOS!!!"));
    }

    public void limpar() {
        tituloProperty.setValue("");
        tipoProperty.getValue().clearSelection();
        valorProperty.setValue("");
        dataProperty.setValue(null);
    }

    public ObservableList<DespesaRow> getDespesas() {
        return despesas;
    }

    public ObservableList<String> getTipos() {
        return tipos;
    } 
}