package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import Main.App;
import Main.Classes.Grupos;
import Main.Classes.Pessoa;
import Main.Classes.Presentes;
import Main.Classes.TelasEnum;
import Repositorios.IRepositorioPessoa;
import Repositorios.IRepositorioPresente;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
    /*--------VARIAVEIS FXML */
    @FXML
    private TextField nomeCompleto;
    @FXML
    private TextField apelido;
    @FXML
    private TextField senha;
    @FXML
    private ComboBox<Pessoa>cbPessoa;
    @FXML
    private ComboBox<String> presenPessoa;
    @FXML
    private TextField idAdd;
    @FXML
    private ListView<Presentes> todosOsPresentes;
    @FXML
    private ListView<Presentes> presenteDaPessoa;
    @FXML
    private Button addButton;
    /*--------------- */
    
    /*--------PRESENTES */
    private ObservableList<Presentes> presentesDisponiveis;
    private ObservableList<Presentes> obsPresentes;
    private ArrayList<Presentes> presentes = new ArrayList<>();
    private Presentes presenteio;
    Presentes itemPresen;
    /*----------- */
   

    /*----VARIAVEIS */
    Pessoa selecao;
    private ObservableList<Pessoa> obsPessoa;
    String nomeLabel;
    /*--------- */


    /*--------------TELA 1 */
    @FXML
    protected void btSalvar(ActionEvent e){
        //--VERIFICAR SE NAO ESTA NULO
        nomeLabel = nomeCompleto.getText();
        String apelidoLabel = apelido.getText();
        String senhaLabel = senha.getText();

        if(nomeLabel != null && !nomeLabel.isEmpty() && apelidoLabel != null && !apelidoLabel.isEmpty() && senhaLabel != null && !senhaLabel.isEmpty()){
            
            Pessoa pessoa = new Pessoa(nomeLabel,apelidoLabel, senhaLabel);
        
            App.pessoa.addPessoa(pessoa);
            
            /*---COMBO BOX */
            obsPessoa = FXCollections.observableArrayList(App.pessoa.getPessoas());
            cbPessoa.setItems(obsPessoa);
            cbPessoa.setValue(pessoa);
            /*--------- */


            nomeCompleto.setText("");
            apelido.setText("");
            senha.setText("");
            nomeCompleto.requestFocus();

            for(Pessoa p : App.pessoa.getPessoas()){
                System.out.println(p.getNome());
            }

            for(Pessoa p : App.pessoa.getApelidos()){
                System.out.println(p.getApelido());
            }

            for(Pessoa p : App.pessoa.getSenha()){
                System.out.println(p.getSenha());
            }
            

        }else{
            System.out.println("A label esta vazia");
        }
         
    }
    /*------------------------ */

    /*-----------TELA 2--*/
    /*-----METODO QUE MANDA AS INFORMAÇÕES DA TELA PRESENTE PARA A TELA PESSOA */
    @FXML
   protected void initialize(){
      Interface.MudarTela.mudancaListeree(new Interface.MudarTela.mudanca() {
         @Override
         public void mudar(TelasEnum novaTela, Object userData){
            if(novaTela.equals(TelasEnum.PESSOAS)){
                obsPresentes = FXCollections.observableArrayList(App.presente.getPresentes());
                todosOsPresentes.setItems(obsPresentes);
              
            }
         }
      });
   }

   @FXML 
   //---METODO PARA ADICIONAR PESSOAS A LISTVIEW
   protected void btAddPresente(ActionEvent e){
        itemPresen = todosOsPresentes.getSelectionModel().getSelectedItem();
        if(cbPessoa.getValue() != null && itemPresen != null){

            presenteio = itemPresen;
            presentes.add(presenteio);
            presentesDisponiveis = FXCollections.observableArrayList(presentes);
            presenteDaPessoa.setItems(presentesDisponiveis);

            System.out.println(itemPresen);
        }else{
            //---EXCEPTION
            System.out.println("Label VAZIA"); 
        }
    }

    @FXML
    //--METODO PARA DELETAR PESSOAS DA LISTVIEW
    protected void deletePresente(ActionEvent e){
        Presentes itemPresenPessoas = presenteDaPessoa.getSelectionModel().getSelectedItem();
        if(itemPresenPessoas != null){
            Presentes delPresentes = itemPresenPessoas;
            presentes.remove(delPresentes);
            presentesDisponiveis = FXCollections.observableArrayList(presentes);
            presenteDaPessoa.setItems(presentesDisponiveis);
        }else{
            System.out.println("SELECIONE UM CAMPO!");
        }
    }

   /*------------------ */

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
