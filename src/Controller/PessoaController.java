package Controller;

import java.util.ArrayList;
import Main.App;
import Main.Classes.Grupos;
import Main.Classes.Pessoa;
import Main.Classes.Presentes;
import Main.Classes.TelasEnum;
import Repositorios.IRepositorioPresente;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
    @FXML
    private TextField nomeCompleto;
    @FXML
    private TextField apelido;
    @FXML
    private TextField senha;
    @FXML
    private ComboBox<Pessoa>cbPessoa;
    @FXML
    private TextArea taTodosOsPresen;
    @FXML
    private TextArea taPresenDaPessoa;
    @FXML
    private TextField idAdd;
    


    private ObservableList<Pessoa> obsPessoa;
    private ObservableList<String> presentesDisponiveis = FXCollections.observableArrayList();

    private ArrayList<String> presentes;


    /*--------------TELA 1 */
    @FXML
    protected void btSalvar(ActionEvent e){
        //--VERIFICAR SE NAO ESTA NULO
        String nomeLabel = nomeCompleto.getText();
        String apelidoLabel = apelido.getText();
        String senhaLabel = senha.getText();

        if(nomeLabel != null && !nomeLabel.isEmpty() && apelidoLabel != null && !apelidoLabel.isEmpty() && senhaLabel != null && !senhaLabel.isEmpty()){
            
            Pessoa pessoa = new Pessoa(nomeLabel, senhaLabel);
            Pessoa pessoaApelido = new Pessoa(apelidoLabel);
            
            App.pessoa.addPessoa(pessoa);
            App.pessoa.addApelidos(pessoaApelido);
            

            /*---COMBO BOX */
            obsPessoa = FXCollections.observableArrayList(App.pessoa.getPessoas());
            cbPessoa.setItems(obsPessoa);
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
    @FXML
   protected void initialize(){
      Interface.MudarTela.mudancaListeree(new Interface.MudarTela.mudanca() {
         @Override
         public void mudar(TelasEnum novaTela, Object userData){
            if(novaTela.equals(TelasEnum.PESSOAS)){
                taTodosOsPresen.setEditable(false);
                taPresenDaPessoa.setEditable(false);
                
                int controle = 0;

                taTodosOsPresen.setText("ID | PRESENTE\n\n");
                presentes = new ArrayList<String>();

                for(Presentes p : App.presente.getPresentes()){
                    String texto = p.toString();
                    presentes.add(controle, p.toString());
                    
                    taTodosOsPresen.appendText(controle +  ".    " + texto + "\n");
                    controle++;
                }

                
            }
         }
      });
   }

   @FXML 
   protected void btAdd(ActionEvent e){
        String idLabel = idAdd.getText();
        


        if(idLabel != null && !idLabel.isEmpty() && cbPessoa.getValue() != null){
            int idNumero = Integer.parseInt(idLabel);
            for(int i = 0; i < presentes.size(); i++){
                
                if(i == idNumero){
                    taPresenDaPessoa.setText(presentes.get(i));
        
                }else{
                    //----EXCEPTION
                    System.out.println("DIGITE UM ID VALIDO");
                    idAdd.setText("");
                    
                }
                System.out.println(idNumero);
            }
            
        }else{
            //---EXCEPTION
            System.out.println("Label VAZIA");
            idAdd.setText("");
            
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
