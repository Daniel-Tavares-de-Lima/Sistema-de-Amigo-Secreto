package Controller;

import Main.App;
import Main.Classes.Grupos;
import Main.Classes.Pessoa;
import Main.Classes.TelasEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

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

    /*---MAIN */

    @FXML
    private ComboBox<Grupos>cbSorteio;

    private ObservableList<Grupos> obsSorteio;


    @FXML
    protected void comboBox(ActionEvent e){

        Grupos grupo = new Grupos();

        obsSorteio = FXCollections.observableArrayList(App.grupo.getGrupos());
        cbSorteio.setItems(obsSorteio);
    }

}
