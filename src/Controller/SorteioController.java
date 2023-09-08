package Controller;

/*------IMPORTS */
import Main.App;
import Main.Classes.Grupos;
import Main.Classes.Pessoa;
import Main.Classes.TelasEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
/*------ */

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

    /*------VARIAVEIS FXML */
    @FXML
    private ComboBox<Grupos>cbSorteio;
    @FXML
    private ComboBox<Grupos> cbSorteio1;
    @FXML
    private ComboBox<Pessoa> cbPessoa;
    /*------------ */


    /*----VARIAVEIS GRUPO */
    private ObservableList<Grupos> obsSorteio;
    /**--- */
    /*-----VARIAVEIS PESSOAS */
    private ObservableList<Pessoa> obsSorteio1;
    
    @FXML
   protected void initialize(){
      Interface.MudarTela.mudancaListeree(new Interface.MudarTela.mudanca() {
         @Override
         public void mudar(TelasEnum novaTela, Object userData){
            if(novaTela.equals(TelasEnum.SORTEIO)){
                obsSorteio = FXCollections.observableArrayList(App.grupo.getGrupos());
                cbSorteio.setItems(obsSorteio);

                obsSorteio = FXCollections.observableArrayList(App.grupo.getGrupos());
                cbSorteio1.setItems(obsSorteio);

                obsSorteio1 = FXCollections.observableArrayList(App.pessoa.getPessoas());
                cbPessoa.setItems(obsSorteio1);
                
                
                
            }
         }
      });
   }

}
