package Controller;

import Main.App;
import Main.Classes.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class PessoaController {
    @FXML

    protected void btnVoltar(ActionEvent e){
        App.mudarTela(telas.MAIN);
    }
}
