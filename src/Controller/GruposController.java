package Controller;

import Main.App;
import Main.Classes.telasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class GruposController{
    /*----HEADER */
    @FXML
    protected void bt2Pessoa(ActionEvent e){
        App.mudarTela(telasEnum.PESSOAS);
    }
    @FXML
    protected void bt2Grupos(ActionEvent e){
        App.mudarTela(telasEnum.GRUPOS);
    }
    @FXML
    protected void bt2Presentes(ActionEvent e){
        App.mudarTela(telasEnum.PRESENTES);
    }
    @FXML
    protected void bt2Sorteio(ActionEvent e){
        App.mudarTela(telasEnum.SORTEIO);
    }
    /*-----FIM HEADER */


}