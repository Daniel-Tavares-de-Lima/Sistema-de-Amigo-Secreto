package Controller;

import Main.App;
import Main.Classes.telasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class PessoaController {
    /*-----HEADER */
    @FXML
    protected void bt1Pessoas(ActionEvent e){
        App.mudarTela(telasEnum.PESSOAS);
    }
    @FXML
    protected void bt1Grupos(ActionEvent e){
        App.mudarTela(telasEnum.GRUPOS);
    }
    @FXML 
    protected void bt1Presentes(ActionEvent e){
        App.mudarTela(telasEnum.PRESENTES);
    }
    @FXML
    protected void bt1Sorteio(ActionEvent e){
        App.mudarTela(telasEnum.SORTEIO);
    }
    /**----FIM HEADER */


    /*-----MAIN */

   
    /*---FIM MAIN */


    /*---FOOTER-- */
    @FXML
    protected void btnVoltar(ActionEvent e){
        App.mudarTela(telasEnum.MAIN);
    }
    /*-----FIM FOOTER */


}
