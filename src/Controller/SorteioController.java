package Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*------IMPORTS */
import Main.App;
import Main.Classes.Grupos;
import Main.Classes.Pessoa;
import Main.Classes.TelasEnum;
import Repositorios.IRepositorioSorteio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
/*------ */
import javafx.scene.control.TextField;

public class SorteioController {
    /*----HEADER */
    @FXML
    protected void bt4Pessoa(ActionEvent e) {
        App.mudarTela(TelasEnum.PESSOAS);
    }

    @FXML
    protected void bt4Grupos(ActionEvent e) {
        App.mudarTela(TelasEnum.GRUPOS);
    }

    @FXML
    protected void bt4Presentes(ActionEvent e) {
        App.mudarTela(TelasEnum.PRESENTES);
    }

    @FXML
    protected void bt4Sorteio(ActionEvent e) {
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /*-----FIM HEADER */

    /*---MAIN */

    /*------VARIAVEIS FXML */
    @FXML
    private ComboBox<Grupos> cbSorteio;
    @FXML
    private ComboBox<Grupos> cbSorteioGrupo;
    @FXML
    private ComboBox<Pessoa> cbPessoa;
    @FXML
    private TextField senha;
    /*------------ */

    /*----VARIAVEIS GRUPO */
    private ObservableList<Grupos> obsSorteio;
    private ObservableList<Grupos> grupoSelect;
    /** --- */
    /*-----VARIAVEIS PESSOAS */
    private ObservableList<Pessoa> obsSorteio1;
    // private ObservableList<Pessoa> obsSenhas;
    List<String> nomesAmigosSecretos;
    
    
    /*-------- */

    @FXML
    protected void initialize() {
        Interface.MudarTela.mudancaListeree(new Interface.MudarTela.mudanca() {
            @Override
            public void mudar(TelasEnum novaTela, Object userData) {
                if (novaTela.equals(TelasEnum.SORTEIO)) {
                    // ---INICIALIZA AS INFORMAÇÕES DE GRUPOS E ADICIONA COMBOBOX
                    obsSorteio = FXCollections.observableArrayList(App.grupo.getGrupos());
                    cbSorteio.setItems(obsSorteio);

                    // ---INICIALIZA AS INFORMAÇÕES DE GRUPOS E ADICIONA COMBOBOX (SEGUNDA TELA)
                    obsSorteio = FXCollections.observableArrayList(App.grupo.getGrupos());
                    cbSorteioGrupo.setItems(obsSorteio);

                    
                }
            }
        });
    }

    /*------BOTAO REALIZAR SORTEIO TELA 1*/

    @FXML
    protected void sorteio(ActionEvent e) {

        Grupos grupoSelecionado = cbSorteio.getValue();

        if (cbSorteio.getValue() != null) {

             /*---VERIFICA SE HOUVE O SORTEIO */
            if(grupoSelecionado.foiRealizadoSorteio()){
                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
                alertSalvaPessoa.setTitle("SORTEIO REALIZADO");
                alertSalvaPessoa.setContentText("O sorteio já foi realizado para este grupo");
                alertSalvaPessoa.show();
                /*------ */
            }  else{
                IRepositorioSorteio sistemas = new IRepositorioSorteio(grupoSelecionado.getPessoasCerta());
                // sistemas.realizarAmigoSecreto(grupoSelecionado.getPessoasCerta());

                nomesAmigosSecretos = sistemas.realizarAmigoSecreto(grupoSelecionado.getPessoasCerta());
                grupoSelecionado.setRealizadoSorteio(true);

                System.out.println(nomesAmigosSecretos);

              

                
                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.INFORMATION);
                alertSalvaPessoa.setTitle("Sorteio");
                alertSalvaPessoa.setContentText("Sorteio realizado com sucesso!");
                alertSalvaPessoa.show();
                /*------ */

                
            }

        } else {
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("CAMPO VAZIL");
            alertSalvaPessoa.setContentText("Por favor, selecione um campo");
            alertSalvaPessoa.show();
            /*------ */
        }
    }

    /*----TELA 2 */


    @FXML 
    protected void mudarPessoas(ActionEvent e){
        obsSorteio1 = FXCollections.observableArrayList(App.pessoa.getPessoas());
        cbPessoa.setItems(obsSorteio1);
        
        Grupos grupoEscolhido = cbSorteioGrupo.getValue();
        cbPessoa.getItems().clear();

        if(grupoEscolhido != null){
            List<Pessoa> pessoasDoGrupo = grupoEscolhido.getPessoasCerta();

            obsSorteio1.clear();
            obsSorteio1.addAll(pessoasDoGrupo);
        }else{
            obsSorteio1.clear();
        }
        
    }
    @FXML
    /// -----METODO PARA CONSULTAR O AMIGO SECRETO
    protected void consultarAmigo(ActionEvent e) {
        Grupos grupoEscolhido = cbSorteioGrupo.getValue();
        String senhaDigitada = senha.getText().trim(); // --Remove espaços em branco
        Pessoa pessoaEscolhida = cbPessoa.getValue();
        int indicePessoaEscolhida = cbPessoa.getSelectionModel().getSelectedIndex();

   

        if (cbSorteioGrupo.getValue() != null && cbPessoa.getValue() != null && senhaDigitada != null && !senhaDigitada.isEmpty()) {
            /*--------VERIFICAR SE A SENHA ESTÁ CORRETA */
            ArrayList<String> senhaListaPessoal = pessoaEscolhida.getSenhas();
            boolean senhaCorreta = false;
            for (String senhaArmazenada : senhaListaPessoal) {
                if (senhaArmazenada.equals(senhaDigitada)) {
                    senhaCorreta = true;
                   
                    /*---ALERT */
                    Alert alertSalvaPessoa = new Alert(Alert.AlertType.INFORMATION);
                    alertSalvaPessoa.setTitle("AMIGO SECRETO");
                    alertSalvaPessoa.setContentText("Amigo secreto de '" + pessoaEscolhida + "' no " + "'" + grupoEscolhido + "' é " + nomesAmigosSecretos.get(indicePessoaEscolhida));///--ESTA IMPRIMINDO NULO
                    alertSalvaPessoa.show();
                    /*------ */
                    
                    System.out.println("SENHA DISPONIVEL");
                    
                    break;// --SE ENCONTROU UMA SENHA CORRETA NAO PRECISA CONTIUNAR VERIFICANDO
                }
                // System.out.println(p.getSenha());
            }
            if(!senhaCorreta){
                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
                alertSalvaPessoa.setTitle("SENHA INCORRETA");
                alertSalvaPessoa.setContentText("Por favor, verifique sua senha");
                alertSalvaPessoa.show();
                /*------ */
            }
            /*------------------------ */

           
            
            

        }else {
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("CAMPO VAZIL");
            alertSalvaPessoa.setContentText("Por favor, selecione um campo");
            alertSalvaPessoa.show();
            /*------ */
        }

        /*------ */

    }

    /*-----FOOTER */
    @FXML
    protected void btnVoltar(ActionEvent e) {
        senha.setText("");

        App.mudarTela(TelasEnum.MAIN);

    }

}
