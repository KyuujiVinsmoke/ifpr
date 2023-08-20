package ifpr.pgua.eic.escola.controllers.cursos;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Curso;
import ifpr.pgua.eic.escola.models.Escola;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class JanelaCursosListar implements Initializable 
{
    @FXML
    private ListView<Curso> ltvCursos;

    @FXML
    private TextField tfBusca;

    @FXML
    private TextArea taDetalhes;

    private Escola escola;

    public JanelaCursosListar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        System.out.println(escola.getCursos());
        ltvCursos.getItems().addAll(escola.getCursos());
    }

    @FXML
    private void mostraDetalhesCursos(MouseEvent evento)
    {
        taDetalhes.clear();
        
        Curso curso = ltvCursos.getSelectionModel().getSelectedItem();

        if(curso != null)
        {
            taDetalhes.appendText("Codigo: "+curso.getCodigo()+"\n");
            taDetalhes.appendText("Nome: "+curso.getNome()+"\n");
            taDetalhes.appendText("Descricao: "+curso.getDescricao()+"\n"); 
            taDetalhes.appendText("Carga Horaria: "+curso.getCargaHoraria()+"\n"); 
            taDetalhes.appendText("Professor: "+curso.getProfessor()+"\n");
        }
    }

    @FXML
    private void buscarCurso()
    {
        String nome = tfBusca.getText();

        ltvCursos.getItems().clear();
        ltvCursos.getItems().addAll(escola.buscarCurso(nome));
    }
}