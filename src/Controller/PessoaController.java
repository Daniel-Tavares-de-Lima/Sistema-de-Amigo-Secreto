package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class PessoaController {
    @FXML

    protected void btnVoltar(ActionEvent e){
        App.mudarTela("main");
    }
}
