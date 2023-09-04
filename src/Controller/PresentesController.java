package Controller;

import Main.App;
import Main.Classes.telasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PresentesController {
    /*----HEADER */
    @FXML
    protected void bt3Pessoa(ActionEvent e){
        App.mudarTela(telasEnum.PESSOAS);
    }
    @FXML
    protected void bt3Grupos(ActionEvent e){
        App.mudarTela(telasEnum.GRUPOS);
    }
    @FXML
    protected void bt3Presentes(ActionEvent e){
        App.mudarTela(telasEnum.PRESENTES);
    }
    @FXML
    protected void bt3Sorteio(ActionEvent e){
        App.mudarTela(telasEnum.SORTEIO);
    }
    /*-----FIM HEADER */
}
