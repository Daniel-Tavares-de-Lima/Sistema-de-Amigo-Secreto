package Controller;

import Main.App;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController{
   @FXML
   //---TODO EVENTO TEM QUE SER PROTECT
   protected void btnNovoAction(ActionEvent e){
        App.mudarTela("pessoas");
   }




}

