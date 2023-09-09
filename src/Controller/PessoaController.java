package Controller;


import java.util.List;

import Main.App;
import Main.Classes.Pessoa;
import Main.Classes.Presentes;
import Main.Classes.TelasEnum;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
            Pessoa pessoa = new Pessoa(nomeLabel,apelidoLabel, senhaLabel, senhaLabel);
            App.pessoa.addPessoa(pessoa);
            /*---COMBO BOX */
            obsPessoa = FXCollections.observableArrayList(App.pessoa.getPessoas());
            cbPessoa.setItems(obsPessoa);
            cbPessoa.setValue(pessoa);
            /*--------- */

            /*---ALERT PESSOA SALVA */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.INFORMATION);
            alertSalvaPessoa.setTitle("PESSOA SALVA");
            alertSalvaPessoa.setContentText("PESSOA SALVA COM SUCESSO!");
            alertSalvaPessoa.show();
            /*------ */

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
            /*---ALERT PESSOA NAO SALVA */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("ITEM VAZIO");
            alertSalvaPessoa.setContentText("POR FAVOR, DIGITE UM CAMPO");
            alertSalvaPessoa.show();
            /*------ */
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
                // presentesDisponiveis = FXCollections.observableArrayList(App.presente.getPresentesEscolhidos());
                // presenteDaPessoa.setItems(presentesDisponiveis);
              
                cbPessoa.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pessoa>() {
                    @Override
                    public void changed(ObservableValue<? extends Pessoa> observable, Pessoa oldValue, Pessoa newValue){
                        if(newValue != null){
                            List<Presentes> presentesEmPessoas = newValue.getPresenteCerto();
                            presentesDisponiveis = FXCollections.observableArrayList(presentesEmPessoas);
                            presenteDaPessoa.setItems(presentesDisponiveis);
                            
                        }
                    }
                });
            }
         }
      });
   }

   @FXML 
   //---METODO PARA ADICIONAR PESSOAS A LISTVIEW
   protected void btAddPresente(ActionEvent e){
        Presentes itemPresentes = todosOsPresentes.getSelectionModel().getSelectedItem();
        Pessoa pessoasSelecionadas = cbPessoa.getValue();

        if(cbPessoa.getValue() != null && itemPresentes != null){
            if(!pessoasSelecionadas.getPresenteCerto().contains(itemPresentes)){
                pessoasSelecionadas.adicionarPresentes(itemPresentes);

                presentesDisponiveis = FXCollections.observableArrayList(pessoasSelecionadas.getPresenteCerto());
                presenteDaPessoa.setItems(presentesDisponiveis);
            }else{
                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
                alertSalvaPessoa.setTitle("Presente adicionado");
                alertSalvaPessoa.setContentText("Esse presente já foi add em: " + pessoasSelecionadas);
                alertSalvaPessoa.show();
                /*------ */
            }

            for(Presentes p : pessoasSelecionadas.getPresenteCerto()){
                System.out.println("O presente esta com a pessoa" + pessoasSelecionadas + "o nome: " + p);
            }
        }else{
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("CAMPO VAZIL");
            alertSalvaPessoa.setContentText("Por favor, selecione um campo");
            alertSalvaPessoa.show();
            /*------ */
        }
    }

    @FXML
    //--METODO PARA DELETAR PESSOAS DA LISTVIEW
    protected void deletePresente(ActionEvent e){
        Presentes itemPresenPessoas = presenteDaPessoa.getSelectionModel().getSelectedItem();
        Pessoa pessoaSelecionada = cbPessoa.getValue();

        if(itemPresenPessoas != null && pessoaSelecionada != null){
            pessoaSelecionada.removerPresente(itemPresenPessoas);
            presentesDisponiveis = FXCollections.observableArrayList(pessoaSelecionada.getPresenteCerto());
            presenteDaPessoa.setItems(presentesDisponiveis);
        }else{
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("CAMPO VAZIL");
            alertSalvaPessoa.setContentText("Por favor, selecione um campo");
            alertSalvaPessoa.show();
            /*------ */
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

    @FXML protected void btnSalvar(ActionEvent e){
        /*---ALERT */
        Alert alertSalvaPessoa = new Alert(Alert.AlertType.INFORMATION);
        alertSalvaPessoa.setTitle("CAMPO VAZIL");
        alertSalvaPessoa.setContentText("Presentes salvas em pessoa.");
        alertSalvaPessoa.show();
        /*------ */
    }
    /*-----FIM FOOTER */


}
