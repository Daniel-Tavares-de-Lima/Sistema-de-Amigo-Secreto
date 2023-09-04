package Controller;

import Main.App;
import Main.Classes.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SorteioController {
     /*----HEADER */
    @FXML
    protected void bt4Pessoa(ActionEvent e){
        App.mudarTela(TelasEnum.PESSOAS);
    }
    @FXML
    protected void bt4Grupos(ActionEvent e){
        App.mudarTela(TelasEnum.GRUPOS);
    }
    @FXML
    protected void bt4Presentes(ActionEvent e){
        App.mudarTela(TelasEnum.PRESENTES);
    }
    @FXML
    protected void bt4Sorteio(ActionEvent e){
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /*-----FIM HEADER */
}
