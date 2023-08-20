package base.exemplos.parent.telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.Box;

import base.exemplos.parent.controllers.Estacionamento;
import base.exemplos.parent.controllers.Veiculo;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application
{
    private Estacionamento estacionamento = new Estacionamento("nome", "telefone");

    private Scene cena;

    private VBox vbox;
    private Text tMenuPrincipal;
    private Button btCadastrar;
    private Button btExibirVeiculos;
   
    private VBox vboxCadastrar;
    private Text tVeiculo;
    private Label lbPlaca;
    private TextField tfPlaca;
    private Label lbModelo;
    private TextField tfModelo;
    private Label lbFabricante;
    private TextField tfFabricante;
    private Label lbAnoFabricacao;
    private TextField tfAnoFabricacao;
    private Label lbCor;
    private TextField tfCor;
    private Button btCadastrarVeiculo;
    private Button btVoltar;

    private VBox vboxExibirVeiculos;
    private Text tExibirVeiculos;
    private ListView lvVeiculos;
    
    @Override
    public void init() throws Exception 
    {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        menuPrincipal();

        cena = new Scene(vbox,800,800);

        stage.setScene(cena);
        stage.show();
        stage.setTitle("Estacionamento");
    }

    private void menuPrincipal()
    {
        vbox = new VBox();

        tMenuPrincipal = new Text("Estacionamento\n\n");

        btCadastrar = new Button("Cadastrar Veículo");
        btCadastrar.setPrefWidth(200);
        btCadastrar.setOnAction(menuCadastrar());

        btExibirVeiculos = new Button("Exibir Veículos Cadastrados");
        btExibirVeiculos.setPrefWidth(200);
        btExibirVeiculos.setOnAction(menuExibirVeiculos());

        vbox.getChildren().add(tMenuPrincipal);
        vbox.getChildren().add(btCadastrar);
        vbox.getChildren().add(btExibirVeiculos);

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10.0);
    }

    private EventHandler menuCadastrar()
    {
        return new EventHandler<Event>() 
        {
            @Override
            public void handle(Event event) 
            {
               cadastrar();
            }
        };
    }

    private EventHandler menuExibirVeiculos()
    {
        return new EventHandler<Event>() 
        {
            @Override
            public void handle(Event event) 
            {
               exibirVeiculos();
            }
        };
    }

    private void cadastrar()
    {
        vboxCadastrar = new VBox();

        tVeiculo = new Text("Informações do Veículo\n\n");
        lbPlaca = new Label("Placa");
        tfPlaca = new TextField();
        lbModelo = new Label("Modelo");
        tfModelo = new TextField();
        lbFabricante = new Label("Fabricante");
        tfFabricante = new TextField();
        lbAnoFabricacao = new Label("Ano de Fabricação");
        tfAnoFabricacao = new TextField();
        lbCor = new Label("Cor");
        tfCor = new TextField();

        btCadastrarVeiculo = new Button("Cadastrar");
        btCadastrarVeiculo.setPrefWidth(100);
        btCadastrarVeiculo.setOnAction(cadastrarVeiculo());

        btVoltar = new Button("Voltar");
        btVoltar.setPrefWidth(100);
        btVoltar.setOnAction(voltarMenu());

        HBox hboxVeiculo = new HBox();
        hboxVeiculo.getChildren().add(tVeiculo);
        hboxVeiculo.setAlignment(Pos.CENTER);
        vboxCadastrar.getChildren().add(hboxVeiculo);

        vboxCadastrar.getChildren().add(lbPlaca);
        vboxCadastrar.getChildren().add(tfPlaca);
        vboxCadastrar.getChildren().add(lbModelo);
        vboxCadastrar.getChildren().add(tfModelo);
        vboxCadastrar.getChildren().add(lbFabricante);
        vboxCadastrar.getChildren().add(tfFabricante);
        vboxCadastrar.getChildren().add(lbAnoFabricacao);
        vboxCadastrar.getChildren().add(tfAnoFabricacao);
        vboxCadastrar.getChildren().add(lbCor);
        vboxCadastrar.getChildren().add(tfCor);

        HBox hboxBotoes = new HBox();
        hboxBotoes.getChildren().add(btCadastrarVeiculo);
        hboxBotoes.getChildren().add(btVoltar);
        hboxBotoes.setAlignment(Pos.BOTTOM_RIGHT);
        
        hboxBotoes.setSpacing(10);
        vboxCadastrar.getChildren().add(hboxBotoes);

        vboxCadastrar.setSpacing(5);
        vboxCadastrar.setPadding(new Insets(180, 200, 200, 200));
        cena.setRoot(vboxCadastrar);
    }
    
    private void exibirVeiculos()
    {   
        vboxExibirVeiculos = new VBox();
        
        tExibirVeiculos = new Text("Veículos Cadastrados\n\n");

        HBox hboxExibirVeiculos = new HBox();
        hboxExibirVeiculos.getChildren().add(tExibirVeiculos);
        hboxExibirVeiculos.setAlignment(Pos.CENTER);
        vboxExibirVeiculos.getChildren().add(hboxExibirVeiculos);

        lvVeiculos = new ListView<>();
        vboxExibirVeiculos.getChildren().addAll(lvVeiculos);

        for(Veiculo veiculo:estacionamento.listaTodosVeiculos()) 
        {
            lvVeiculos.getItems().add(veiculo);
        }

        btVoltar = new Button("Voltar");
        btVoltar.setPrefWidth(100);
        btVoltar.setOnAction(voltarMenu());

        HBox hboxBotoes = new HBox();
        hboxBotoes.getChildren().add(btVoltar);
        hboxBotoes.setAlignment(Pos.BOTTOM_RIGHT);

        hboxBotoes.setSpacing(10);
        vboxExibirVeiculos.getChildren().add(hboxBotoes);

        vboxExibirVeiculos.setSpacing(5);
        vboxExibirVeiculos.setPadding(new Insets(180, 100, 100, 100));
        cena.setRoot(vboxExibirVeiculos);
    }

    private EventHandler cadastrarVeiculo()
    {
        return new EventHandler<Event>() 
        {
            @Override
            public void handle(Event event) 
            {
                String placa = tfPlaca.getText();
                String modelo = tfModelo.getText();
                String fabricante = tfFabricante.getText();
                int anoFabricacao = Integer.valueOf(tfAnoFabricacao.getText());
                String cor = tfCor.getText();
                
                if (estacionamento.isCadastraVeiculo(placa, modelo, fabricante, anoFabricacao, cor))
                {
                    Alert ok = new Alert(AlertType.INFORMATION, "Cadastro Bem Sucedido");
                    ok.showAndWait();
                    cena.setRoot(vbox);
                }
                
                else
                {
                    Alert alerta = new Alert(AlertType.WARNING, "Placa Já Cadastrada");
                    alerta.showAndWait();
                }
            }
        };
    }

    private EventHandler voltarMenu()
    {
        return new EventHandler<Event>() 
        {
            @Override
            public void handle(Event event) 
            {
                cena.setRoot(vbox);
            }
        };
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}