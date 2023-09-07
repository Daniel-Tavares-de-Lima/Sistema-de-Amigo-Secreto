package Controller;

import Main.App;
import Main.Classes.TelasEnum;
import javafx.collections.FXCollections;
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

   
   @FXML
   protected void initialize(){
      Interface.MudarTela.mudancaListeree(new Interface.MudarTela.mudanca() {
         @Override
         public void mudar(TelasEnum novaTela, Object userData){
            if(novaTela.equals(TelasEnum.SORTEIO)){
                
                
            }
         }
      });
   }

}


