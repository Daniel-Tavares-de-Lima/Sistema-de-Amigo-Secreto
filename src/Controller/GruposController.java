package Controller;

import Main.App;
import Main.Classes.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class GruposController{
    /*----HEADER */
    @FXML
    protected void bt2Pessoa(ActionEvent e){
        App.mudarTela(TelasEnum.PESSOAS);
    }
    @FXML
    protected void bt2Grupos(ActionEvent e){
        App.mudarTela(TelasEnum.GRUPOS);
    }
    @FXML
    protected void bt2Presentes(ActionEvent e){
        App.mudarTela(TelasEnum.PRESENTES);
    }
    @FXML
    protected void bt2Sorteio(ActionEvent e){
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /*-----FIM HEADER */


}