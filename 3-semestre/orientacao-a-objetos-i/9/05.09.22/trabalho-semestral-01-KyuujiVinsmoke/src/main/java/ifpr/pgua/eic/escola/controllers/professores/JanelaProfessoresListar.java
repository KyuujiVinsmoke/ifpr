package ifpr.pgua.eic.escola.controllers.professores;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.models.pessoas.Professor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class JanelaProfessoresListar implements Initializable 
{
    @FXML
    private ListView<Professor> ltvProfessores;

    @FXML
    private TextField tfBusca;

    @FXML
    private TextArea taDetalhes;

    private Escola escola;

    public JanelaProfessoresListar(Escola escola)
    {
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        System.out.println(escola.getProfessores());
        ltvProfessores.getItems().addAll(escola.getProfessores());
    }

    @FXML
    private void mostraDetalhesProfessores(MouseEvent evento)
    {
        taDetalhes.clear();
        
        Professor professor = ltvProfessores.getSelectionModel().getSelectedItem();

        if(professor != null)
        {
            taDetalhes.appendText("CPF: "+professor.getCpf()+"\n");
            taDetalhes.appendText("Nome: "+professor.getNome()+"\n");
            taDetalhes.appendText("E-mail: "+professor.getEmail()+"\n"); 
            taDetalhes.appendText("Telefone: "+professor.getTelefone()+"\n");
            taDetalhes.appendText("Salario: "+professor.getSalario()+"\n");  
        }
    }

    @FXML
    private void buscarProfessorCpf()
    {
        String cpf = tfBusca.getText();

        ltvProfessores.getItems().clear();
        ltvProfessores.getItems().addAll(escola.buscarProfessorCpf(cpf));
    }
}