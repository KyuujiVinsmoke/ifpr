package ifpr.pgua.eic.escola;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.escola.utils.BaseAppNavigator;
import ifpr.pgua.eic.escola.utils.ScreenRegistryFXML;

import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.controllers.JanelaPrincipal;

import ifpr.pgua.eic.escola.controllers.alunos.JanelaAlunos;
import ifpr.pgua.eic.escola.controllers.alunos.JanelaAlunosCadastrar;
import ifpr.pgua.eic.escola.controllers.alunos.JanelaAlunosListar;

import ifpr.pgua.eic.escola.controllers.cursos.JanelaCursos;
import ifpr.pgua.eic.escola.controllers.cursos.JanelaCursosCadastrar;
import ifpr.pgua.eic.escola.controllers.cursos.JanelaCursosListar;

import ifpr.pgua.eic.escola.controllers.professores.JanelaProfessores;
import ifpr.pgua.eic.escola.controllers.professores.JanelaProfessoresCadastrar;
import ifpr.pgua.eic.escola.controllers.professores.JanelaProfessoresListar;

public class App extends BaseAppNavigator 
{
    private Escola escola;

    @Override
    public void init() throws Exception 
    {
        super.init();

        escola = new Escola("nome", "telefone");
    }

    @Override
    public String getHome() 
    {
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() 
    {
        return "Escola";
    }

    @Override
    public void registrarTelas() 
    {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "fxml/principal.fxml", o->new JanelaPrincipal()));

        registraTela("ALUNOS", new ScreenRegistryFXML(App.class, "fxml/alunos/alunos.fxml", o->new JanelaAlunos()));
        registraTela("ALUNOSCADASTRAR", new ScreenRegistryFXML(App.class, "fxml/alunos/alunoscadastrar.fxml", o->new JanelaAlunosCadastrar(escola)));
        registraTela("ALUNOSLISTAR", new ScreenRegistryFXML(App.class, "fxml/alunos/alunoslistar.fxml", o->new JanelaAlunosListar(escola)));
    
        registraTela("PROFESSORES", new ScreenRegistryFXML(App.class, "fxml/professores/professores.fxml", o->new JanelaProfessores()));
        registraTela("PROFESSORESCADASTRAR", new ScreenRegistryFXML(App.class, "fxml/professores/professorescadastrar.fxml", o->new JanelaProfessoresCadastrar(escola)));
        registraTela("PROFESSORESLISTAR", new ScreenRegistryFXML(App.class, "fxml/professores/professoreslistar.fxml", o->new JanelaProfessoresListar(escola)));

        registraTela("CURSOS", new ScreenRegistryFXML(App.class, "fxml/cursos/cursos.fxml", o->new JanelaCursos()));
        registraTela("CURSOSCADASTRAR", new ScreenRegistryFXML(App.class, "fxml/cursos/cursoscadastrar.fxml", o->new JanelaCursosCadastrar(escola)));
        registraTela("CURSOSLISTAR", new ScreenRegistryFXML(App.class, "fxml/cursos/cursoslistar.fxml", o->new JanelaCursosListar(escola)));
    }

    /* 
    @Override
    public void atualizaEstilo() 
    {
        adicionarArquivoEstilo(getClass().getResource("css/estilo.css").toExternalForm());
    }
    */
}