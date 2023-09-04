package Controller;

import Main.App;
import Main.Classes.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PresentesController {
    /*----HEADER */
    @FXML
    protected void bt3Pessoa(ActionEvent e){
        App.mudarTela(TelasEnum.PESSOAS);
    }
    @FXML
    protected void bt3Grupos(ActionEvent e){
        App.mudarTela(TelasEnum.GRUPOS);
    }
    @FXML
    protected void bt3Presentes(ActionEvent e){
        App.mudarTela(TelasEnum.PRESENTES);
    }
    @FXML
    protected void bt3Sorteio(ActionEvent e){
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /*-----FIM HEADER */
}
