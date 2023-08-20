package ifpr.pgua.eic.quizapp;

import java.util.ArrayList;
import javax.swing.Action;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppGUI extends Application
{
    private ControladorQuiz controladorQuiz;

    private Scene cena;
    private VBox vbox;
    private Text numero;
    private Text enunciado;
    private Text acertos;
    private Text erros;
    private Button reiniciar;
    private Button alternativa1;
    private Button alternativa2;
    private Button alternativa3;
    private Button alternativa4;
    private Text resultado;
    private Button proxima;
    
    @Override
    public void init() throws Exception 
    {
        super.init();

        ArrayList<Questao> lista = new ArrayList<>();
        
        lista.add(new Questao("Qual a capital do Paraná?", "Curitiba", new String[]{"Floripa", "Porto Alegre", "São Paulo"}));
        lista.add(new Questao("Qual a capital de São Paulo?", "São Paulo", new String[]{"Floripa", "Rio de Janeiro", "Campo Grande"}));
        lista.add(new Questao("Qual a capital do Acre?", "Rio Branco", new String[]{"Manaus","Palmas", "João Pessoa"}));
        lista.add(new Questao("Qual a capital de Rondonia?", "Porto Velho", new String[]{"Belém", "Macapá", "Manaus"}));

        controladorQuiz = new ControladorQuiz(lista);
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        inicializaComponentes();
        atualizaTela();

        cena = new Scene(vbox,300,300);

        stage.setScene(cena);
        stage.show();
        stage.setTitle("Quiz");
    }

    private void inicializaComponentes()
    {
        numero = new Text ("sei la");
        enunciado = new Text("Olá Mundo!! Agora com GUI!!!");
        
        alternativa1 = new Button("Alternativa 1");
        alternativa1.setPrefWidth(200);
        alternativa1.setOnAction(respondePergunta());

        alternativa2 = new Button("Alternativa 2");
        alternativa2.setPrefWidth(200);
        alternativa2.setOnAction(respondePergunta());

        alternativa3 = new Button("Alternativa 3");
        alternativa3.setPrefWidth(200);
        alternativa3.setOnAction(respondePergunta());

        alternativa4 = new Button("Alternativa 4");
        alternativa4.setPrefWidth(200);
        alternativa4.setOnAction(respondePergunta());
        
        resultado = new Text("Resultado");
        proxima = new Button("Próxima");
        proxima.setOnAction(proximaPergunta());
        
        vbox = new VBox();

        painelQuiz();
    }

    private void painelQuiz()
    {
        vbox.getChildren().add(numero);
        vbox.getChildren().add(enunciado);
        vbox.getChildren().add(alternativa1);
        vbox.getChildren().add(alternativa2);
        vbox.getChildren().add(alternativa3);
        vbox.getChildren().add(alternativa4);
        vbox.getChildren().add(resultado);
        vbox.getChildren().add(proxima);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10.0);

        resultado.setVisible(false);
        proxima.setVisible(false);
    }

    private void atualizaTela()
    {   
        if (controladorQuiz.temProximaQuestao())
        {
            Questao questao = controladorQuiz.getQuestao();
            int n = controladorQuiz.indiceQuestaoAtual() + 1;
            numero.setText("Pergunta " +n+ "/4");
            enunciado.setText(questao.getEnunciado());
            alternativa1.setText(questao.getAlternativas().get(0));
            alternativa2.setText(questao.getAlternativas().get(1));
            alternativa3.setText(questao.getAlternativas().get(2));
            alternativa4.setText(questao.getAlternativas().get(3));
            
            alternativa1.setDisable(false);
            alternativa2.setDisable(false);
            alternativa3.setDisable(false);
            alternativa4.setDisable(false);

            resultado.setVisible(false);
            proxima.setVisible(false);
        }

        else
        {
            vbox.getChildren().remove(numero);
            vbox.getChildren().remove(enunciado);
            vbox.getChildren().remove(alternativa1);
            vbox.getChildren().remove(alternativa2);
            vbox.getChildren().remove(alternativa3);
            vbox.getChildren().remove(alternativa4);
            vbox.getChildren().remove(resultado);
            vbox.getChildren().remove(proxima);
            painelReiniciar();
        }
    }

    private EventHandler respondePergunta()
    {
        return new EventHandler<Event>() 
        {
            @Override
            public void handle(Event event) 
            {
                Button clicado = (Button)event.getSource();
                String alternativa = clicado.getText();

                boolean ret = controladorQuiz.respondeQuestao(alternativa);

                if(ret)
                {
                    resultado.setText("Acertou!!");
                }
                
                else
                {
                    resultado.setText("Errou!!!");
                }

                alternativa1.setDisable(true);
                alternativa2.setDisable(true);
                alternativa3.setDisable(true);
                alternativa4.setDisable(true);

                resultado.setVisible(true);
                proxima.setVisible(true);
            }
        };
    }

    private EventHandler proximaPergunta()
    {
        return new EventHandler<Event>() 
        {
            @Override
            public void handle(Event event) 
            {
                if(controladorQuiz.temProximaQuestao())
                {
                    controladorQuiz.proximaQuestao();
                    atualizaTela();
                }
            }
        };
    }

    private void painelReiniciar ()
    {
        acertos = new Text ("Acertos: ");
        erros = new Text("Erros: ");
        
        acertos.setText("Acertos: " +controladorQuiz.getAcertos());
        erros.setText("Erros: " +controladorQuiz.getErros());
        
        reiniciar = new Button("Reiniciar");
        reiniciar.setOnAction(reiniciarQuiz());

        vbox.getChildren().add(acertos);
        vbox.getChildren().add(erros);
        vbox.getChildren().add(reiniciar);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10.0);
    }

    private EventHandler reiniciarQuiz()
    {
        return new EventHandler<Event>() 
        {
            @Override
            public void handle(Event event) 
            {
                controladorQuiz.reiniciar();
                vbox.getChildren().remove(acertos);
                vbox.getChildren().remove(erros);
                vbox.getChildren().remove(reiniciar);

                painelQuiz();
                atualizaTela();
            }
        };
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}