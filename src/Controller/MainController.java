package Controller;

import Main.App;
import Main.Classes.TelasEnum;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController{
   /*------HEADER--- */
   @FXML
   protected void btnNovoAction(ActionEvent e){
        App.mudarTela(TelasEnum.PESSOAS);
   }
   @FXML
   protected void btGrupos(ActionEvent e){
      App.mudarTela(TelasEnum.GRUPOS);
   }
   @FXML
   protected void btPresentes(ActionEvent e){
      App.mudarTela(TelasEnum.PRESENTES);
   }
   @FXML
   protected void btSorteio(ActionEvent e){
      App.mudarTela(TelasEnum.SORTEIO);
   }
   /*---FIM HEADERR */

}


