package Main;

/*----- */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Main.Classes.TelasEnum;
import Repositorios.IRepositorioGrupo;
import Repositorios.IRepositorioPessoa;
import Repositorios.IRepositorioPresente;
import Repositorios.IRepositorioSorteio;
import Interface.MudarTela;
/*------- */


public class App extends Application {

    /*----FXML */
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
    /*-- SORTEIO*/
    public static IRepositorioSorteio sorteios;

    /*----MUDAR TELA */
    public static MudarTela mudarTela;

    // public static Grupos gruposParaVer;

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
        primaryStage.setResizable(false);
        primaryStage.show();

        
    }

    public static void main(String[] args) {
        pessoa = new IRepositorioPessoa();
        grupo = new IRepositorioGrupo();
        presente = new IRepositorioPresente();
        sorteios = new IRepositorioSorteio();
        mudarTela = new MudarTela();

        // gruposParaVer = new Grupos();

        launch(args);
    }
    

    public static void mudarTela(TelasEnum telas, Object userData) {
        switch (telas) {
            case MAIN:
                stage.setScene(mainSistema);
                mudarTela.notificar(TelasEnum.MAIN, userData);
                break;
            case PESSOAS:
                stage.setScene(cdtsPessoas);
                mudarTela.notificar(TelasEnum.PESSOAS, userData);
                break;
            case GRUPOS:
                stage.setScene(cdtsGrupos);
                mudarTela.notificar(TelasEnum.GRUPOS, userData);
                break;
            case PRESENTES:
                stage.setScene(presentes);
                mudarTela.notificar(TelasEnum.PRESENTES, userData);
                break;
            case SORTEIO:
                stage.setScene(sorteio);
                mudarTela.notificar(TelasEnum.SORTEIO, userData);
                break;   
        
        }
    }

    public static void mudarTela(TelasEnum telas){
        mudarTela(telas, null);
    }


}