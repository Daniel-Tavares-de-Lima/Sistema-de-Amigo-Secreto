package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Main.Classes.TelasEnum;
import Repositorios.IRepositorioGrupo;
import Repositorios.IRepositorioPessoa;
import Repositorios.IRepositorioPresente;
import Main.Classes.Pessoa;

public class App extends Application {

    /*----MAIN */
    private static Stage stage;
    private static Scene mainSistema;
    private static Scene cdtsPessoas;
    private static Scene cdtsGrupos;
    private static Scene presentes;
    private static Scene sorteio;
    /*----- */

    /*--PESSOAS */
    public static IRepositorioPessoa pessoa;

    /*--GRUPOS */
    public static IRepositorioGrupo grupo;

    /*---PRESENTES */
    public static IRepositorioPresente presente;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        primaryStage.setTitle("Amigo Secreto");

        //--TELA PRINCIPAL
        Parent fxmlMain = FXMLLoader.load(this.getClass().getResource("./view/mainSistemaAmigoSecreto.fxml"));
        mainSistema = new Scene(fxmlMain, 530, 480);

        //---TELA DE CADASTRAMENTO DE PESSOAS
        Parent fxmlPessoas = FXMLLoader.load(this.getClass().getResource("./view/cadastramentoDePessoas.fxml"));
        cdtsPessoas = new Scene(fxmlPessoas, 530, 480);

        //---TELA DE GRUPOS
        Parent fxmlGrupos = FXMLLoader.load(this.getClass().getResource("./view/Grupo.fxml"));
        cdtsGrupos = new Scene(fxmlGrupos, 530,480);

        //---TELA DE PRESENTES
        Parent fxmlPresentes = FXMLLoader.load(this.getClass().getResource("./view/cadastramentoDePresentes.fxml"));
        presentes = new Scene(fxmlPresentes,530,480);

        //--TELA DE SORTEIO
        Parent fxmlSorteio = FXMLLoader.load(this.getClass().getResource("./view/Sorteio.fxml"));
        sorteio = new Scene(fxmlSorteio,530,480);
        /* ---------------*/ 

        primaryStage.setScene(mainSistema);
        primaryStage.show();

        //--CARREGANDO METODO PESSOA CONTROLER
        
    }

    public static void main(String[] args) {
        pessoa = new IRepositorioPessoa();
        grupo = new IRepositorioGrupo();
        presente = new IRepositorioPresente();
        
        launch(args);
    }
    

    public static void mudarTela(TelasEnum telas) {
        switch (telas) {
            case MAIN:
                stage.setScene(mainSistema);
                break;
            case PESSOAS:
                stage.setScene(cdtsPessoas);
                break;
            case GRUPOS:
                stage.setScene(cdtsGrupos);
                break;
            case PRESENTES:
                stage.setScene(presentes);
                break;
            case SORTEIO:
                stage.setScene(sorteio);
                break;   
        
        }
    }

    
}