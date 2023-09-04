package Main;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {


    private static Stage stage;
    private static Scene mainSistema;
    private static Scene cdtsPessoas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        primaryStage.setTitle("Amigo Secreto");
        String opi;

        //--TELA PRINCIPAL
        Parent fxmlMain = FXMLLoader.load(this.getClass().getResource("./view/mainSistemaAmigoSecreto.fxml"));
        mainSistema = new Scene(fxmlMain, 530, 480);

        //---TELA DE CADASTRAMENTO DE PESSOAS
        Parent fxmlPessoas = FXMLLoader.load(this.getClass().getResource("./view/cadastramentoDePessoas.fxml"));
        cdtsPessoas = new Scene(fxmlPessoas, 530, 480);

        primaryStage.setScene(mainSistema);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    

    public static void mudarTela(String main) {
        switch (main) {
            case "main":
                stage.setScene(mainSistema);
                break;
            case "pessoas":
                stage.setScene(cdtsPessoas);
                break;
        }
    }
}