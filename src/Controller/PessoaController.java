package Controller;

import java.util.ArrayList;
import Main.App;
import Main.Classes.Pessoa;

import Main.Classes.TelasEnum;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class PessoaController {
    /*-----HEADER */
    @FXML
    protected void bt1Pessoas(ActionEvent e){
        App.mudarTela(TelasEnum.PESSOAS);
    }
    @FXML
    protected void bt1Grupos(ActionEvent e){
        App.mudarTela(TelasEnum.GRUPOS);
    }
    @FXML 
    protected void bt1Presentes(ActionEvent e){
        App.mudarTela(TelasEnum.PRESENTES);
    }
    @FXML
    protected void bt1Sorteio(ActionEvent e){
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /**----FIM HEADER */


    /*-----MAIN */
    @FXML
    private TextField nomeCompleto;
    @FXML
    private TextField apelido;
    @FXML
    private TextField senha;
    @FXML
    private ComboBox<Pessoa>cbPessoa;

    private ObservableList<Pessoa> obsPessoa;

    @FXML
    protected void btSalvar(ActionEvent e){
        //--VERIFICAR SE NAO ESTA NULO
        String nomeLabel = nomeCompleto.getText();
        String apelidoLabel = apelido.getText();
        String senhaLabel = senha.getText();

        if(nomeLabel != null && !nomeLabel.isEmpty() && apelidoLabel != null && !apelidoLabel.isEmpty() && senhaLabel != null && !senhaLabel.isEmpty()){
            
            Pessoa pessoa = new Pessoa(nomeLabel);
            
            App.pessoa.addPessoa(pessoa);

            /*---COMBO BOX */
            obsPessoa = FXCollections.observableArrayList(App.pessoa.getPessoas());
            cbPessoa.setItems(obsPessoa);
            /*--------- */

            nomeCompleto.setText("");
            apelido.setText("");
            senha.setText("");
            nomeCompleto.requestFocus();

            for(Pessoa p : App.pessoa.getPessoas()){
                System.out.println(p);
            }
        }else{
            System.out.println("A label esta vazia");
        }
         
    }
    /*---FIM MAIN */


    /*---FOOTER-- */
    @FXML
    protected void btnVoltar(ActionEvent e){
        nomeCompleto.setText("");
        apelido.setText("");
        senha.setText("");
        App.mudarTela(TelasEnum.MAIN);

    }
    /*-----FIM FOOTER */


}
