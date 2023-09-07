package Controller;

import java.time.LocalDate;

import Main.App;
import Main.Classes.Grupos;
import Main.Classes.Pessoa;
import Main.Classes.TelasEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class GruposController {
    /*----HEADER */
    @FXML
    protected void bt2Pessoa(ActionEvent e) {
        App.mudarTela(TelasEnum.PESSOAS);
    }

    @FXML
    protected void bt2Grupos(ActionEvent e) {
        App.mudarTela(TelasEnum.GRUPOS);
    }

    @FXML
    protected void bt2Presentes(ActionEvent e) {
        App.mudarTela(TelasEnum.PRESENTES);
    }

    @FXML
    protected void bt2Sorteio(ActionEvent e) {
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /*-----FIM HEADER */

    /*-----MAIN---*/
    @FXML
    private DatePicker data;
    @FXML
    private TextField tfNomeGrupo;
    @FXML
    private ChoiceBox<Grupos> cbGrupos;

    private ObservableList<Grupos> obsGrupos;

    int comparar;

    // ---METODO PARA O DATEPICKER
    public void getData(ActionEvent e) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate calenData = data.getValue();

        comparar = dataAtual.compareTo(calenData);

        System.out.println(calenData.toString());
    }

    // ---METODO PARA SALVAR O NOME DO GRUPO

    @FXML
    protected void salvarGrupo(ActionEvent e) {

        // ---VERIFICAR SE NÃO ESTA NULO OU VAZIO
        String labelGrupo = tfNomeGrupo.getText();

        if (labelGrupo != null && !labelGrupo.isEmpty()) {
            if (comparar <= 0) {
                Grupos grupo = new Grupos(labelGrupo);

                App.grupo.addGrupos(grupo);

                /*---COMBO BOX */
                obsGrupos = FXCollections.observableArrayList(App.grupo.getGrupos());
                cbGrupos.setItems(obsGrupos);
                cbGrupos.setValue(grupo);

                /*------- */

                tfNomeGrupo.setText("");
                tfNomeGrupo.requestFocus();
                data.getEditor().clear();

                for (Grupos g : App.grupo.getGrupos()) {
                    System.out.println(g);
                }
            }else{
                //---EXCEPTION
                System.out.println("ESCOLHA UMA DATA CERTA");
                data.getEditor().clear();
            }

        }else {
            System.out.println("A Label esta vazia");
        }
    }

}