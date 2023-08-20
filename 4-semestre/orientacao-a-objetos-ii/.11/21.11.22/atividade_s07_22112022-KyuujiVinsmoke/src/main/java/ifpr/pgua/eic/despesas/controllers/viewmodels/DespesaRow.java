package ifpr.pgua.eic.despesas.controllers.viewmodels;

import java.time.format.DateTimeFormatter;

import ifpr.pgua.eic.despesas.model.entities.Despesa;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DespesaRow {
    
    private Despesa despesa;
    
    public DespesaRow(Despesa despesa){
        this.despesa = despesa;
    }

    public Despesa getDespesa(){
        return despesa;
    }


    /**
     * Propriedade para representar o atributo id da despesa.
     * 
     * @return SimpleStringProperty com o valor do id da despesa.
     */
    public StringProperty idProperty(){
        return new SimpleStringProperty(String.valueOf(despesa.getId()));
    }

    /**
     * Propriedade para representar o atributo titulo da despesa.
     * 
     * @return SimpleStringProperty com o valor do titulo da despesa.
     */

    public StringProperty tituloProperty(){
        return new SimpleStringProperty(despesa.getTitulo());
    }

    /**
     * Propriedade para representar o atributo valor da despesa.
     * 
     * @return SimpleStringProperty com o valor da despesa.
     */
    public StringProperty valorProperty(){
        return new SimpleStringProperty(String.valueOf(despesa.getValor()));
    }

    /**
     * Propriedade para representar o atributo tipo da despesa.
     * 
     * @return SimpleStringProperty com o valor do tipo da despesa.
     */
    public StringProperty tipoProperty(){
        return new SimpleStringProperty(despesa.getTipo());
    }

    /**
     * Propriedade para representar o atributo data da despesa.
     * 
     * @return SimpleStringProperty com o valor da data da despesa.
     */
    public StringProperty dataProperty(){
        return new SimpleStringProperty(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(despesa.getData()));
    }


}
