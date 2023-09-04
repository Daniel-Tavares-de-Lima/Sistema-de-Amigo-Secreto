package Controller;

import Main.App;
import Main.Classes.telasEnum;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController{
   /*------HEADER--- */
   @FXML
   protected void btnNovoAction(ActionEvent e){
        App.mudarTela(telasEnum.PESSOAS);
   }
   @FXML
   protected void btGrupos(ActionEvent e){
      App.mudarTela(telasEnum.GRUPOS);
   }
   @FXML
   protected void btPresentes(ActionEvent e){
      App.mudarTela(telasEnum.PRESENTES);
   }
   @FXML
   protected void btSorteio(ActionEvent e){
      App.mudarTela(telasEnum.SORTEIO);
   }
   /*---FIM HEADERR */

}


