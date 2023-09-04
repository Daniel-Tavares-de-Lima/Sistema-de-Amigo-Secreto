package Controller;

import Main.App;
import Main.Classes.telasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SorteioController {
     /*----HEADER */
    @FXML
    protected void bt4Pessoa(ActionEvent e){
        App.mudarTela(telasEnum.PESSOAS);
    }
    @FXML
    protected void bt4Grupos(ActionEvent e){
        App.mudarTela(telasEnum.GRUPOS);
    }
    @FXML
    protected void bt4Presentes(ActionEvent e){
        App.mudarTela(telasEnum.PRESENTES);
    }
    @FXML
    protected void bt4Sorteio(ActionEvent e){
        App.mudarTela(telasEnum.SORTEIO);
    }
    /*-----FIM HEADER */
}
